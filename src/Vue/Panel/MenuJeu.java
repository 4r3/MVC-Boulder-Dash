package Vue.Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.GestionSourisMenuJeu;
import Modele.Variables;

@SuppressWarnings("serial")
public class MenuJeu extends JPanel {

	public MenuJeu(Fenetre fen) {
		initMenuPrincipal(fen);
	}

	private void initMenuPrincipal(Fenetre fen) {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JButton revenirJeu = new JButton("Revenir au jeu");
		JButton recommencerJeu = new JButton("Recommencer le niveau");
		JButton changerNiveau = new JButton("Changer de niveau");
		JButton revenirMenu = new JButton("Retourner au menu principal");

		revenirJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		recommencerJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		changerNiveau.setAlignmentX(Component.CENTER_ALIGNMENT);
		revenirMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

		new GestionSourisMenuJeu(fen, revenirJeu, recommencerJeu,
				changerNiveau, revenirMenu);
		add(revenirJeu);
		add(changerNiveau);
		add(revenirMenu);
	}
}