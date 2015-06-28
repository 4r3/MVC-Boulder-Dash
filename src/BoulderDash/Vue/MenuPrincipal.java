package BoulderDash.Vue;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BoulderDash.Controlleur.GestionBoutonsMenu;
import BoulderDash.Modele.Variables;

/**
 * Vue du menu principal
 * 
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class MenuPrincipal extends JPanel {

	/**
	 * Initialisation du menu principal
	 */
	public MenuPrincipal() {
		initMenuPrincipal();
		setFocusable(true);
	}

	/**
	 * Initialisation du menu principal
	 */
	private void initMenuPrincipal() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setBackground(Variables.COULEUR);
		setDoubleBuffered(true);

		JLabel logo = new JLabel(new ImageIcon("./sprites/titre.png"));

		JButton lancerJeu = new JButton("Jeu");
		JButton lancerEditeur = new JButton("Editeur");
		JButton quitter = new JButton("Quitter");

		logo.setAlignmentX(CENTER_ALIGNMENT);
		lancerJeu.setAlignmentX(CENTER_ALIGNMENT);
		lancerEditeur.setAlignmentX(CENTER_ALIGNMENT);
		quitter.setAlignmentX(CENTER_ALIGNMENT);

		GestionBoutonsMenu ctrl;
		ctrl = new GestionBoutonsMenu(lancerJeu, lancerEditeur, quitter);
		lancerJeu.addActionListener(ctrl);
		lancerEditeur.addActionListener(ctrl);
		quitter.addActionListener(ctrl);

		add(logo);
		add(Box.createVerticalStrut(15));
		add(lancerJeu);
		add(Box.createVerticalStrut(15));
		add(lancerEditeur);
		add(Box.createVerticalStrut(15));
		add(quitter);
	}
}
