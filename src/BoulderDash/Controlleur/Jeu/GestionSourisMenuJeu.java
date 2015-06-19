package BoulderDash.Controlleur.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BoulderDash.BoulderDash;
import BoulderDash.Vue.Vues;

public class GestionSourisMenuJeu implements ActionListener {

	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;

	public GestionSourisMenuJeu(JButton b1, JButton b2, JButton b3, JButton b4) {

		this.bouton1 = b1;
		this.bouton2 = b2;
		this.bouton3 = b3;
		this.bouton4 = b4;

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) { // Revenir au jeu
			BoulderDash.getFen().changerVue(Vues.TABLEAUJEU);
		} else if (arg0.getSource() == this.bouton2) { // Recommencer le niveau

		} else if (arg0.getSource() == this.bouton3) { // Changer le niveau
			BoulderDash.getFen().changerVue(Vues.MENUCHOIXNIVEAU);

		} else if (arg0.getSource() == this.bouton4) { // Revenir au menu
														// principal

			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
		}
	}
}