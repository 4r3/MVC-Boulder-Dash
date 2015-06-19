package BoulderDash.Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import BoulderDash.Controlleur.GestionSourisMenuJeu;
import BoulderDash.Modele.Variables;

@SuppressWarnings("serial")
public class MenuJeu extends JPanel {

	public MenuJeu() {
		initMenuPrincipal();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void initMenuPrincipal() {
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

		new GestionSourisMenuJeu(revenirJeu, recommencerJeu, changerNiveau,
				revenirMenu);
		add(revenirJeu);
		add(changerNiveau);
		add(revenirMenu);
	}
}