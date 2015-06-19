package BoulderDash.Controlleur.Editeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import BoulderDash.BoulderDash;
import BoulderDash.Vue.Vues;

public class GestionMenuEditeur implements ActionListener {

	private JMenuItem nouveau;
	private JMenuItem charger;
	private JMenuItem sauvgarder;
	private JMenuItem quitter;

	public GestionMenuEditeur(JMenuItem nouveau, JMenuItem charger,
			JMenuItem sauvgarder, JMenuItem quitter) {

		this.nouveau = nouveau;
		this.charger = charger;
		this.sauvgarder = sauvgarder;
		this.quitter = quitter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.nouveau) { // Retour éditeur
			BoulderDash.getEdit().createNiveau();
		} else if (arg0.getSource() == this.charger) { // Charger niveau
			System.out.println("load");
		} else if (arg0.getSource() == this.sauvgarder) { // Sauvegarder niveau
			System.out.println("save");
		} else if (arg0.getSource() == this.quitter) { // Retour menu principal
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
		}
	}
}