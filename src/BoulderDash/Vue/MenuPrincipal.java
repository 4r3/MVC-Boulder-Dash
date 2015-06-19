package BoulderDash.Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import BoulderDash.Controlleur.GestionBoutonsMenu;
import BoulderDash.Modele.Variables;

@SuppressWarnings("serial")
public class MenuPrincipal extends JPanel {

	public MenuPrincipal(Fenetre fen) {
		initMenuPrincipal(fen);
		setFocusable(true);
	}

	private void initMenuPrincipal(Fenetre fen) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JButton lancerJeu = new JButton("Jeu");
		JButton lancerEditeur = new JButton("Editeur");
		JButton quitter = new JButton("Quitter");

		lancerJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		lancerEditeur.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitter.setAlignmentX(Component.CENTER_ALIGNMENT);

		GestionBoutonsMenu ctrl;
		ctrl = new GestionBoutonsMenu(lancerJeu, lancerEditeur, quitter);
		lancerJeu.addActionListener(ctrl);
		lancerEditeur.addActionListener(ctrl);
		quitter.addActionListener(ctrl);

		add(lancerJeu);
		add(lancerEditeur);
		add(quitter);
	}
}
