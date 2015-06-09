/**
 * 
 */
package Vue.Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import Controlleur.GestionBoutonsMenuChoix;
import Modele.Jeu;
import Modele.Variables;

/**
 * @author 4r3
 *
 */
@SuppressWarnings("serial")
public class MenuChoixNiveau extends JPanel {

	/**
	 * @param fenetre
	 */
	public MenuChoixNiveau(Fenetre fenetre) {

		initMenu(fenetre);

	}

	private void initMenu(Fenetre fenetre) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JList<String> Liste = new JList<String>(Jeu.getListeNiveaux());

		JButton lancerJeu = new JButton("Jouer");
		JButton retour = new JButton("Retour");

		lancerJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		retour.setAlignmentX(Component.CENTER_ALIGNMENT);

		GestionBoutonsMenuChoix ctrl = new GestionBoutonsMenuChoix(lancerJeu,
				retour, Liste);
		lancerJeu.addActionListener(ctrl);
		retour.addActionListener(ctrl);

		add(Liste);
		add(lancerJeu);
		add(retour);
	}
}
