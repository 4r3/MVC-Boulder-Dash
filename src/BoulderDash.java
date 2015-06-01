import javax.swing.JFrame;

import Modele.Jeu;
import Modele.Niveau;
import Modele.Animation.TableAnimation;
import Vue.Panel.Fenetre;

public class BoulderDash {

	public static void main(String[] args) {
		Niveau niveau = new Niveau(20, 15, 5, 5, 18, 18);
		Jeu jeu = new Jeu();

		niveau.insereDiamant(5, 1);

		niveau.insereDiamant(5, 2);

		niveau.insereDiamant(4, 2);

		niveau.insereRocher(2, 2);

		niveau.insereMurMagique(5, 10);

		// niveau.exporter("level1");

		JFrame fen = new Fenetre(niveau, jeu);
		fen.setVisible(true);

		int i = 0;

		while (!niveau.isFini()) {
			try {
				Thread.sleep(200 / 6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (i == 0) {
				niveau.refresh();
			} else {
				TableAnimation.refreshAnim();
				niveau.refreshAnim();
			}

			i = (i + 1) % 6;
		}
		System.exit(0);
	}
}
