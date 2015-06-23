package BoulderDash.Controlleur.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import BoulderDash.BoulderDash;
import BoulderDash.Vue.Vues;

public class GestionMenuJeu implements ActionListener {

	public GestionMenuJeu(JButton b1) {

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BoulderDash.getJeu().pauseOn();
		Object[] options = { "Menu principal", "Recommencer le niveau",
				"Changer de niveau", "Retour au jeu" };
		int n = JOptionPane.showOptionDialog(BoulderDash.getFen(), ""
				+ "Menu pause", "", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[3]);
		switch (n) {
		case 0:
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
			break;
		case 1:
			BoulderDash.getJeu().restartLevel();
			BoulderDash.getFen().changerVue(Vues.TABLEAUJEU);
			break;
		case 2:
			BoulderDash.getFen().changerVue(Vues.MENUCHOIXNIVEAU);
			break;
		default:
			break;
		}
		BoulderDash.getJeu().pauseOff();
		BoulderDash.getFen().refocus();
	}
}
