package BoulderDash.Modele;

import java.io.File;
import java.util.Observable;

public class Jeu extends Observable {

	private Niveau level;

	public Jeu() {
		level = null;
		level = new Niveau("./niveaux/level3.csv");
	}

	public void chargerNiveau(String path) {
		level = new Niveau(path);
		setChanged();
		notifyObservers(2);
	}

	public Niveau getNiveau() {
		return level;
	}

	public static String[] getListeNiveaux() {
		File f = new File("./niveaux");
		File[] paths;

		String[] S = null;

		paths = f.listFiles();

		S = new String[paths.length];

		for (int i = 0; i < paths.length; i++) {
			S[i] = paths[i].toString();
		}
		return S;
	}

	public void gestion() {
		int i = 0;
		long time = System.currentTimeMillis();

		while (!level.isFini()) {
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
				level.refresh();
			}

			level.refreshAnim();

			i = (i + 1) % Variables.CYCLES;

			setChanged();
			notifyObservers(1);
		}
	}
}