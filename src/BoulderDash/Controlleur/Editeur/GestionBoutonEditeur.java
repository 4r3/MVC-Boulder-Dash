package BoulderDash.Controlleur.Editeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.Animation.ChoixAnimation;

public class GestionBoutonEditeur implements ActionListener {

	JButton bouton1;
	JButton bouton2;
	JButton bouton3;
	JButton bouton4;
	JButton bouton5;
	JButton bouton6;
	JButton bouton7;
	JButton bouton8;
	JButton bouton9;

	/**
	 * constructeur, permet de stocker tous les boutons
	 */
	public GestionBoutonEditeur(JButton b1, JButton b2, JButton b3, JButton b4,
			JButton b5, JButton b6, JButton b7, JButton b8, JButton b9) {

		this.bouton1 = b1;
		this.bouton2 = b2;
		this.bouton3 = b3;
		this.bouton4 = b4;
		this.bouton5 = b5;
		this.bouton6 = b6;
		this.bouton7 = b7;
		this.bouton8 = b8;
		this.bouton9 = b9;
	}

	/**
	 * sélectionne dans le modèle le type d'objet à insérer dans le niveau
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) { // Sélection Rockford
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Personnage_Idle);
		} else if (arg0.getSource() == this.bouton2) { // Sélection Sortie
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Sortie);
		} else if (arg0.getSource() == this.bouton3) { // Sélection Diamant
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Diamant);
		} else if (arg0.getSource() == this.bouton4) { // Sélection Rocher
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Rocher);
		} else if (arg0.getSource() == this.bouton5) { // Sélection Vide
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Vide);
		} else if (arg0.getSource() == this.bouton6) { // Sélection Boue
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Boue);
		} else if (arg0.getSource() == this.bouton7) { // Sélection Mur
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Mur);
		} else if (arg0.getSource() == this.bouton8) { // Sélection Mur
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Mur_Magique);
		} else if (arg0.getSource() == this.bouton9) { // Sélection Mur Magique
			BoulderDash.getEdit().setIconActif(ChoixAnimation.Papillon);
		}
	}
}
