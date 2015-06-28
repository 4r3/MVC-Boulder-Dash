/**
 * 
 */
package BoulderDash.Vue.Jeu;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BoulderDash.Controlleur.Jeu.GestionMenuChoix;
import BoulderDash.Modele.Jeu;
import BoulderDash.Modele.Variables;

/**
 * Vue permettant de choisir le niveau
 * 
 * @author 4r3
 */
@SuppressWarnings("serial")
public class MenuChoixNiveau extends JPanel {

	/**
	 * Initialisation du menu
	 */
	public MenuChoixNiveau() {
		initMenu();
	}

	/**
	 * Initialisation du menu
	 */
	private void initMenu() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);
		setBackground(Variables.COULEUR);

		JLabel logo = new JLabel(new ImageIcon("./sprites/titre.png"));

		JComboBox<String> Liste = new JComboBox<>(Jeu.getListeNiveaux());
		Liste.setMaximumSize(new Dimension(200, 30));

		JButton lancerJeu = new JButton("Jouer");
		JButton retour = new JButton("Retour");

		logo.setAlignmentX(CENTER_ALIGNMENT);
		Liste.setAlignmentX(CENTER_ALIGNMENT);
		lancerJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		retour.setAlignmentX(Component.CENTER_ALIGNMENT);

		GestionMenuChoix ctrl = new GestionMenuChoix(lancerJeu, retour, Liste);
		lancerJeu.addActionListener(ctrl);
		retour.addActionListener(ctrl);

		add(logo);
		add(Box.createVerticalStrut(15));
		add(Liste);
		add(Box.createVerticalStrut(15));
		add(lancerJeu);
		add(Box.createVerticalStrut(15));
		add(retour);
	}
}
