package Vue.Panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.TableAnimation;
import Modele.Cases.Personnage;

public class AirePlateauEditeur extends JPanel implements Observer {

	private Niveau niveau;

	public AirePlateauEditeur(Niveau niveau) {
		this.niveau = niveau;
		niveau.addObserver(this);
		initAireEdition();
	}

	private void initAireEdition() {
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
				drawDashedLine(g, 0, ((b + 1) * Variables.TAILLE_CASE) - 1,
						niveau.getLongueur() * Variables.TAILLE_CASE,
						((b + 1) * Variables.TAILLE_CASE) - 1);
			}
			drawDashedLine(g, ((a + 1) * Variables.TAILLE_CASE) - 1, 0,
					((a + 1) * Variables.TAILLE_CASE) - 1, niveau.getHauteur()
							* Variables.TAILLE_CASE);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) {

		// creates a copy of the Graphics instance
		Graphics2D g2d = (Graphics2D) g.create();

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 3 }, 0);
		g2d.setStroke(dashed);
		g2d.setColor(Color.white);
		g2d.drawLine(x1, y1, x2, y2);

		// gets rid of the copy
		g2d.dispose();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawNiveau(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
