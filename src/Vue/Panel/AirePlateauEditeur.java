package Vue.Panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Toolkit;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import Controlleur.GestionSourisInsertionEditeur;
import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.TableAnimation;

@SuppressWarnings("serial")
public class AirePlateauEditeur extends JPanel {

	private Niveau niveau;

	public AirePlateauEditeur() {
		super();
		this.niveau = BoulderDash.getEdit().getNiveau();
		initAireEdition();
	}

	private void initAireEdition() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(this.niveau.getLongueur()
				* Variables.TAILLE_CASE, this.niveau.getHauteur()
				* Variables.TAILLE_CASE));
		setDoubleBuffered(true);

		GestionSourisInsertionEditeur ctrl = new GestionSourisInsertionEditeur();
		addMouseListener(ctrl);
		addMouseMotionListener(ctrl);
	}

	private void drawNiveau(Graphics g) {
		int x, y;
		for (x = 0; x < this.niveau.getLongueur(); x++) {
			for (y = 0; y < this.niveau.getHauteur(); y++) {
				g.drawImage(TableAnimation.getVide().getSpriteImmobile(), x
						* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE,
						null);
				g.drawImage(niveau.getCase(x, y).getAnimation()
						.getSpriteImmobile(), x * Variables.TAILLE_CASE, y
						* Variables.TAILLE_CASE, null);
				drawDashedLine(g, 0, ((y + 1) * Variables.TAILLE_CASE) - 1,
						niveau.getLongueur() * Variables.TAILLE_CASE,
						((y + 1) * Variables.TAILLE_CASE) - 1);
			}
			drawDashedLine(g, ((x + 1) * Variables.TAILLE_CASE) - 1, 0,
					((x + 1) * Variables.TAILLE_CASE) - 1, niveau.getHauteur()
							* Variables.TAILLE_CASE);
		}
		Toolkit.getDefaultToolkit().sync();
	}

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

	public Niveau getNiveau() {
		return niveau;
	}

	public void repaint_xy(int x, int y) {
		Graphics g = getGraphics();
		g.drawImage(TableAnimation.getVide().getSpriteImmobile(), x
				* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE, null);
		g.drawImage(niveau.getCase(x, y).getAnimation().getSpriteImmobile(), x
				* Variables.TAILLE_CASE, y * Variables.TAILLE_CASE, null);

		drawDashedLine(g, 0, ((y + 1) * Variables.TAILLE_CASE) - 1,
				niveau.getLongueur() * Variables.TAILLE_CASE,
				((y + 1) * Variables.TAILLE_CASE) - 1);

		drawDashedLine(g, ((x + 1) * Variables.TAILLE_CASE) - 1, 0,
				((x + 1) * Variables.TAILLE_CASE) - 1, niveau.getHauteur()
						* Variables.TAILLE_CASE);

		Toolkit.getDefaultToolkit().sync();
	}

}
