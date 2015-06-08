import java.awt.CardLayout;
import java.io.File;

import Modele.Jeu;
import Modele.Niveau;
import Modele.Variables;
import Vue.Panel.Fenetre;

public class BoulderDash {

	public static void main(String[] args) {

		// listing des niveaux

		File f = new File("./niveaux");
		File[] paths;

		paths = f.listFiles();

		// for each pathname in pathname array
		for (File path : paths) {
			// prints file and directory paths
			System.out.println(path);
		}
		// System.exit(0);

		//
		//
		//
		//
		//
		//
		//
		//

		Niveau niveau = new Niveau("./niveaux/level2.csv");
		// int t = (int) (Math.random() * 4);
		// int x = 1 + (int) (Math.random() * niveau.getLongueur());
		// int y = 1 + (int) (Math.random() * niveau.getHauteur());

		// Niveau niveau = new Niveau(20, 15, 5, 5, 18, 18);
		Jeu jeu = new Jeu();

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
