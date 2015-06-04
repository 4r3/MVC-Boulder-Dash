package Vue.Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.GestionSourisMenu;
import Modele.Variables;

public class MenuPrincipal extends JPanel {

	public MenuPrincipal(Fenetre fen) {
		initMenuPrincipal(fen);
		setFocusable(true);
	}

	private void initMenuPrincipal(Fenetre fen) {
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

		GestionSourisMenu gsm = new GestionSourisMenu(fen, lancerJeu,
				lancerEditeur, quitter);
		add(lancerJeu);
		add(lancerEditeur);
		add(quitter);
	}
}
