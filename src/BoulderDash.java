import javax.swing.JFrame;

import Modele.Jeu;
import Modele.Niveau;
import Modele.Animation.TableAnimation;
import Vue.Panel.Fenetre;

public class BoulderDash {

	public static void main(String[] args) {
		Niveau niveau = new Niveau("level1");

		// Niveau niveau = new Niveau(20, 15, 5, 5, 18, 18);
		Jeu jeu = new Jeu();

		// niveau.insereDiamant(5, 1);
		// niveau.insereDiamant(5, 2);
		//
		// niveau.insereRocher(2, 2);
		//
		// niveau.insereMurMagique(5, 10);
		// niveau.insereMurMagique(6, 10);
		//
		// niveau.afficheDebug();
		//
		// niveau.exporter("level1");

		JFrame fen = new Fenetre(niveau, jeu);
		fen.setVisible(true);

		int i = 0;
		long time = System.currentTimeMillis();

		while (!niveau.isFini()) {
			time = System.currentTimeMillis() - time;
			try {
				Thread.sleep(50 - time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			time = System.currentTimeMillis();
			if (i == 0) {
				niveau.refresh();
			}
			TableAnimation.refreshAnim();
			niveau.refreshAnim();

			i = (i + 1) % 4;

		}
		System.exit(0);

	}
}
