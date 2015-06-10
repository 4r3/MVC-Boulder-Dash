package Vue.Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.GestionSourisMenuEditeur;
import Modele.Variables;

@SuppressWarnings("serial")
public class MenuEditeur extends JPanel {

	public MenuEditeur() {
		initMenuPrincipal();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void initMenuPrincipal() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JButton revenirEditeur = new JButton("Revenir à l'éditeur");
		JButton chargerNiveau = new JButton("Charger un niveau");
		JButton sauvegarderNiveau = new JButton("Sauvegarder le niveau");
		JButton revenirMenu = new JButton("Retourner au menu principal");

		revenirEditeur.setAlignmentX(Component.CENTER_ALIGNMENT);
		chargerNiveau.setAlignmentX(Component.CENTER_ALIGNMENT);
		sauvegarderNiveau.setAlignmentX(Component.CENTER_ALIGNMENT);
		revenirMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

		new GestionSourisMenuEditeur(revenirEditeur, chargerNiveau,
				sauvegarderNiveau, revenirMenu);
		add(revenirEditeur);
		add(chargerNiveau);
		add(sauvegarderNiveau);
		add(revenirMenu);
	}
}
