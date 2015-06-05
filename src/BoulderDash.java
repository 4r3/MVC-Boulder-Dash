import java.awt.CardLayout;

import Modele.Jeu;
import Modele.Niveau;
import Modele.Variables;
import Vue.Panel.Fenetre;

public class BoulderDash {

	public static void main(String[] args) {
		Niveau niveau = new Niveau("level2");
		// int t = (int) (Math.random() * 4);
		// int x = 1 + (int) (Math.random() * niveau.getLongueur());
		// int y = 1 + (int) (Math.random() * niveau.getHauteur());

		// Niveau niveau = new Niveau(20, 15, 5, 5, 18, 18);
		Jeu jeu = new Jeu();
		// System.out.println(t);
		// switch (t) {
		// case 0:
		// niveau.insereVide(x, y);
		// break;
		// case 1:
		// niveau.insereDiamant(x, y);
		// break;
		// case 2:
		// niveau.insereRocher(x, y);
		// break;
		// case 3:
		// niveau.insereMurNormal(x, y);
		// break;
		// default:
		// niveau.insereVide(x, y);
		// break;
		// }

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

		Fenetre fen = new Fenetre(niveau, jeu);
		fen.setVisible(true);

		int i = 0;
		long time = System.currentTimeMillis();

		while (true) {
			while (!niveau.isFini()) {
				time = Variables.FRAME + System.currentTimeMillis() - time;
				if (time <= 0) {
					time = 1;
				}
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				time = System.currentTimeMillis();
				if (i == 0) {
					niveau.refresh();
				}

				niveau.refreshAnim();

				i = (i + 1) % Variables.CYCLES;

			}
			CardLayout cl = (CardLayout) (fen.getCards().getLayout());
			cl.show(fen.getCards(), Fenetre.MENUPRICIPAL);
			fen.getMenuPrinc().grabFocus();
		}
	}
}
