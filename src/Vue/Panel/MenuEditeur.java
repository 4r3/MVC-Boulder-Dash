package Vue.Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.GestionSourisMenuEditeur;
import Modele.Variables;

@SuppressWarnings("serial")
public class MenuEditeur extends JPanel {

	public MenuEditeur(Fenetre fen) {
		initMenuPrincipal(fen);
	}

	private void initMenuPrincipal(Fenetre fen) {
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

		new GestionSourisMenuEditeur(fen, revenirEditeur, chargerNiveau,
				sauvegarderNiveau, revenirMenu);
		add(chargerNiveau);
		add(sauvegarderNiveau);
		add(revenirMenu);
	}
}