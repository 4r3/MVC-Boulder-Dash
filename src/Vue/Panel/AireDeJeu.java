package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Modele.Niveau;
import Modele.Variables;
import Modele.Cases.Vide;

@SuppressWarnings("serial")
public class AireDeJeu extends JPanel implements Observer {

	private Niveau niveau;

	public AireDeJeu(Niveau niveau) {
		this.niveau = niveau;
		niveau.addObserver(this);
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
		Vide vide = new Vide();
		for (a = 0; a < this.niveau.getLongueur(); a++) {
			for (b = 0; b < this.niveau.getHauteur(); b++) {
				g.drawImage(vide.getAnimation().getSprite(), a
						* Variables.TAILLE_CASE, b * Variables.TAILLE_CASE,
						null);
				g.drawImage(this.niveau.getCase(a, b).getAnimation()
						.getSprite(), a * Variables.TAILLE_CASE, b
						* Variables.TAILLE_CASE, null);
			}
		}
		Toolkit.getDefaultToolkit().sync();
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
