package BoulderDash.Vue.Editeur;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Toolkit;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import BoulderDash.Controlleur.Editeur.GestionSourisInsertionEditeur;
import BoulderDash.Modele.Variables;
import BoulderDash.Modele.Animation.TableAnimation;

/**
 * Vue du terrain de l'éditeur où l'on peut placer des éléments
 * 
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class AirePlateauEditeur extends JPanel {

	/**
	 * Initialisation du panel
	 */
	public AirePlateauEditeur() {
		super();
		initAireEdition();
	}

	/**
	 * Initialisation du panel
	 */
	private void initAireEdition() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(BoulderDash.getEdit().getNiveau()
				.getLongueur()
				* Variables.TAILLE_CASE, BoulderDash.getEdit().getNiveau()
				.getHauteur()
				* Variables.TAILLE_CASE));
		setDoubleBuffered(true);

		GestionSourisInsertionEditeur ctrl = new GestionSourisInsertionEditeur();
		addMouseListener(ctrl);
		addMouseMotionListener(ctrl);
	}

	/**
	 * Initialisation de la zone du terrain
	 */
	private static void drawNiveau(Graphics g) {
		int x, y;
		for (x = 0; x < BoulderDash.getEdit().getNiveau().getLongueur(); x++) {
			for (y = 0; y < BoulderDash.getEdit().getNiveau().getHauteur(); y++) {
				g.drawImage(TableAnimation.getVide().getSpriteImmobile(), x
						* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE,
						null);
				g.drawImage(BoulderDash.getEdit().getNiveau().getCase(x, y)
						.getAnimation().getSpriteImmobile(), x
						* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE,
						null);
				drawDashedLine(g, 0, ((y + 1) * Variables.TAILLE_CASE) - 1,
						BoulderDash.getEdit().getNiveau().getLongueur()
								* Variables.TAILLE_CASE,
						((y + 1) * Variables.TAILLE_CASE) - 1);
			}
			drawDashedLine(g, ((x + 1) * Variables.TAILLE_CASE) - 1, 0,
					((x + 1) * Variables.TAILLE_CASE) - 1, BoulderDash
							.getEdit().getNiveau().getHauteur()
							* Variables.TAILLE_CASE);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Dessine les lignes blanches
	 */
	public static void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) {

		Graphics2D g2d = (Graphics2D) g.create();

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 3 }, 0);
		g2d.setStroke(dashed);
		g2d.setColor(Color.white);
		g2d.drawLine(x1, y1, x2, y2);

		g2d.dispose();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawNiveau(g);
	}

	/**
	 * Repaint un élément uniquement
	 * 
	 * @param x
	 *            emplacement horizontal de l'élément
	 * @param y
	 *            emplacement vertical de l'élément
	 */
	public void repaint_xy(int x, int y) {
		Graphics g = getGraphics();
		try {
			g.drawImage(TableAnimation.getVide().getSpriteImmobile(), x
					* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE, null);
			g.drawImage(BoulderDash.getEdit().getNiveau().getCase(x, y)
					.getAnimation().getSpriteImmobile(), x
					* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE, null);
		} catch (NullPointerException e) {
			System.err.println("erreur dessin sprite");
		}

		drawDashedLine(g, 0, ((y + 1) * Variables.TAILLE_CASE) - 1, BoulderDash
				.getEdit().getNiveau().getLongueur()
				* Variables.TAILLE_CASE, ((y + 1) * Variables.TAILLE_CASE) - 1);

		drawDashedLine(g, ((x + 1) * Variables.TAILLE_CASE) - 1, 0,
				((x + 1) * Variables.TAILLE_CASE) - 1, BoulderDash.getEdit()
						.getNiveau().getHauteur()
						* Variables.TAILLE_CASE);

		Toolkit.getDefaultToolkit().sync();
	}

}
