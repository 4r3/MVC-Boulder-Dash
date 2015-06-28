package BoulderDash.Vue.Jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Variables;
import BoulderDash.Modele.Animation.TableAnimation;

/**
 * Vue du terrain du jeu où l'on peut déplacer Rockford
 * 
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class AirePlateauJeu extends JPanel {

	/**
	 * Niveau affiché
	 */
	private Niveau niveau;

	/**
	 * Initialisation du panel
	 */
	public AirePlateauJeu(Niveau niveau) {
		this.niveau = niveau;
		initAireDeJeu();

	}

	/**
	 * Initialisation du panel
	 */
	private void initAireDeJeu() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(this.niveau.getLongueur()
				* Variables.TAILLE_CASE, this.niveau.getHauteur()
				* Variables.TAILLE_CASE));
		setDoubleBuffered(true);
	}

	/**
	 * Dessin du terrain
	 */
	private void drawNiveau(Graphics g) {
		int a, b;
		for (a = 0; a < this.niveau.getLongueur(); a++) {
			for (b = 0; b < this.niveau.getHauteur(); b++) {
				try {
					g.drawImage(TableAnimation.getVide().getSprite(), a
							* Variables.TAILLE_CASE, b * Variables.TAILLE_CASE,
							null);
				} catch (NullPointerException e) {
				}
				if (niveau.getCase(a, b) != niveau.getPerso()) {
					g.drawImage(
							niveau.getCase(a, b).getAnimation().getSprite(), a
									* Variables.TAILLE_CASE, b
									* Variables.TAILLE_CASE, null);
				}
				try {
					g.drawImage(niveau.getPerso().getAnimation().getSprite(),
							niveau.getPerso().getX() * Variables.TAILLE_CASE
									+ niveau.getPerso().getoffsetX(), niveau
									.getPerso().getY()
									* Variables.TAILLE_CASE
									+ niveau.getPerso().getoffsetY(), null);
				} catch (NullPointerException e) {
				}
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawNiveau(g);
	}

	/**
	 * Change le niveau à afficher
	 * 
	 * @param niveau
	 *            la niveau à afficher
	 */
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

}
