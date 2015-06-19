package BoulderDash.Controlleur.Editeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.Jeu;
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
			load();
		} else if (arg0.getSource() == this.sauvgarder) { // Sauvegarder niveau
			save();
		} else if (arg0.getSource() == this.quitter) { // Retour menu principal
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
		}
	}

	private static void save() {
		System.out.println("save");
		String nom = (String) JOptionPane.showInputDialog(BoulderDash.getFen(),
				"Entrez le nom de votre niveau", "Sauvegarde",
				JOptionPane.PLAIN_MESSAGE);
		System.out.println(nom);
		BoulderDash.getEdit().save(nom);
	}

	private static void load() {
		String[] liste = Jeu.getListeNiveaux();
		String path = (String) JOptionPane.showInputDialog(
				BoulderDash.getFen(), "Complete the sentence:\n"
						+ "\"Green eggs and...\"", "Customized Dialog",
				JOptionPane.PLAIN_MESSAGE, null, liste, liste[0]);
		BoulderDash.getEdit().loadNiveau(path);
	}
}