package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.TableAnimation;
import Modele.Cases.Personnage;

@SuppressWarnings("serial")
public class AirePlateauJeu extends JPanel {

	private Niveau niveau;

	public AirePlateauJeu(Niveau niveau) {
		this.niveau = niveau;
		initAireDeJeu();

	}

	private void initAireDeJeu() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(this.niveau.getLongueur()
				* Variables.TAILLE_CASE, this.niveau.getHauteur()
				* Variables.TAILLE_CASE));
		setDoubleBuffered(true);
	}

	private void drawNiveau(Graphics g) {
		int a, b;
		for (a = 0; a < this.niveau.getLongueur(); a++) {
			for (b = 0; b < this.niveau.getHauteur(); b++) {
				g.drawImage(TableAnimation.getVide().getSprite(), a
						* Variables.TAILLE_CASE, b * Variables.TAILLE_CASE,
						null);
				if (!(niveau.getCase(a, b) instanceof Personnage)) {
					g.drawImage(
							niveau.getCase(a, b).getAnimation().getSprite(), a
									* Variables.TAILLE_CASE, b
									* Variables.TAILLE_CASE, null);
				}
				g.drawImage(niveau.getPerso().getAnimation().getSprite(),
						niveau.getPerso().getPos_x() * Variables.TAILLE_CASE
								+ niveau.getPerso().getoffsetX(), niveau
								.getPerso().getPos_y()
								* Variables.TAILLE_CASE
								+ niveau.getPerso().getoffsetY(), null);
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
	 * @param niveau
	 *            the niveau to set
	 */
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

}
