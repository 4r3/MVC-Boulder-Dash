package BoulderDash.Controlleur.Editeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.Jeu;
import BoulderDash.Vue.Vues;

public class GestionMenuEditeur implements ActionListener {

	private JMenuItem nouveau;
	private JMenuItem charger;
	private JMenuItem sauvgarder;
	private JMenuItem configurer;
	private JMenuItem quitter;

	public GestionMenuEditeur(JMenuItem nouveau, JMenuItem charger,
			JMenuItem sauvgarder, JMenuItem configurer, JMenuItem quitter) {

		this.nouveau = nouveau;
		this.charger = charger;
		this.sauvgarder = sauvgarder;
		this.configurer = configurer;
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
		} else if (arg0.getSource() == this.configurer) {
			config();
		}
	}

	private static void save() {
		String nom = (String) JOptionPane.showInputDialog(BoulderDash.getFen(),
				"Entrez le nom de votre niveau", "Sauvegarde",
				JOptionPane.PLAIN_MESSAGE);
		if (nom != null && nom != "") {
			BoulderDash.getEdit().save(nom);
		}
	}

	private static void load() {
		String[] liste = Jeu.getListeNiveaux();
		String path = (String) JOptionPane.showInputDialog(
				BoulderDash.getFen(), "Quel niveau voulez vous charger",
				"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, liste,
				liste[0]);
		BoulderDash.getEdit().loadNiveau(path);
	}

	private static void config() {
		JTextField diamants = new JTextField(5);
		JTextField temps = new JTextField(5);
		diamants.setText("" + BoulderDash.getEdit().getNiveau().getDscore());
		temps.setText("" + BoulderDash.getEdit().getNiveau().getTmax());
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Diamants requis"));
		myPanel.add(diamants);
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		myPanel.add(new JLabel("Temps maximum :"));
		myPanel.add(temps);

		int result = JOptionPane.showConfirmDialog(BoulderDash.getFen(),
				myPanel, "Entrez les paramettres du niveau",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			try {
				int Dscore = Integer.parseInt(diamants.getText());
				int Tmax = Integer.parseInt(temps.getText());
				BoulderDash.getEdit().getNiveau().setDscore(Dscore);
				BoulderDash.getEdit().getNiveau().setTmax(Tmax);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(BoulderDash.getFen(),
						"Veuillez entrer des valeurs numériques");
			}
		}
	}
}