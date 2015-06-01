import javax.swing.JFrame;

import Modele.Niveau;
import Modele.Animation.TableAnimation;
import Vue.Panel.Fenetre;

public class BoulderDash {

	public static void main(String[] args) {
		// Niveau niveau = new Niveau("level0");

		Niveau niveau = new Niveau(20, 15, 5, 5, 18, 18);

		niveau.insereDiamant(5, 1);

		niveau.insereRocher(2, 2);

		// niveau.insereMurMagique(5, 10);

		niveau.afficheDebug();

		// niveau.importer("level0");

		JFrame fen = new Fenetre(niveau);
		fen.setVisible(true);

		int i = 0;

		while (!niveau.isFini()) {
			try {
				Thread.sleep(50);
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
