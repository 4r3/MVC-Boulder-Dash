package BoulderDash.Controlleur.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.EtatApplication;
import BoulderDash.Modele.Variables;
import BoulderDash.Vue.Vues;

public class GestionMenuJeu implements ActionListener {

	JButton b1;
	JButton b2;

	public GestionMenuJeu(JButton b1, JButton b2) {

		this.b1 = b1;
		this.b2 = b2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BoulderDash.getJeu().pauseOn();
		if (arg0.getSource() == b1) {
			menu();
		} else if (arg0.getSource() == b2) {
			aide();
		}

		BoulderDash.getJeu().pauseOff();
		BoulderDash.getFen().refocus();
	}

	private static void menu() {
		Object[] options = { "Menu principal", "Recommencer le niveau",
				"Changer de niveau", "Retour au jeu" };
		int n = JOptionPane.showOptionDialog(BoulderDash.getFen(), ""
				+ "Menu pause", "", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[3]);
		switch (n) {
		case 0:
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
			BoulderDash.getJeu().getNiveau().setFini();
			break;
		case 1:
			BoulderDash.getJeu().restartLevel();
			BoulderDash.setState(EtatApplication.Jeu);
			BoulderDash.getFen().changerVue(Vues.TABLEAUJEU);
			break;
		case 2:
			BoulderDash.getFen().changerVue(Vues.MENUCHOIXNIVEAU);
			break;
		default:
			break;
		}
	}

	private static void aide() {
		JOptionPane.showMessageDialog(BoulderDash.getFen(), Variables.HELP);
	}
}
