/**
 * 
 */
package BoulderDash.Vue.Jeu;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import BoulderDash.Controlleur.Jeu.GestionMenuChoix;
import BoulderDash.Modele.Jeu;
import BoulderDash.Modele.Variables;

/**
 * @author 4r3
 * 
 */
@SuppressWarnings("serial")
public class MenuChoixNiveau extends JPanel {

	/**
	 * @param fenetre
	 */
	public MenuChoixNiveau() {

		initMenu();

	}

	private void initMenu() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JComboBox<String> Liste = new JComboBox<>(Jeu.getListeNiveaux());

		JButton lancerJeu = new JButton("Jouer");
		JButton retour = new JButton("Retour");

		lancerJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		retour.setAlignmentX(Component.CENTER_ALIGNMENT);

		GestionMenuChoix ctrl = new GestionMenuChoix(lancerJeu, retour, Liste);
		lancerJeu.addActionListener(ctrl);
		retour.addActionListener(ctrl);

		add(Liste);
		add(lancerJeu);
		add(retour);
	}
}
