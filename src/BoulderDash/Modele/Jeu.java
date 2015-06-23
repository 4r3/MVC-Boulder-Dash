package BoulderDash.Modele;

import java.io.File;
import java.util.Observable;

import javax.swing.JOptionPane;

import BoulderDash.BoulderDash;
import BoulderDash.Vue.Vues;

public class Jeu extends Observable {

	private Niveau level;
	private String levelPath;
	private boolean pause;

	public Jeu() {
		level = null;
	}

	public void chargerNiveau(String path) {
		levelPath = path;
		level = new Niveau(path);
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

		if (level == null) {
			return;
		}

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
			if (!pause) {
				if (i == 0) {
					try {
						level.refresh();
					} catch (NullPointerException e) {
						corruptedLevel();
						return;
					}
				}

				level.refreshAnim();

				i = (i + 1) % Variables.CYCLES;

				setChanged();
				notifyObservers(1);
			}
		}
		BoulderDash.setState(EtatApplication.MenuPrincipal);
	}

	public void pauseOn() {
		pause = true;
	}

	public void pauseOff() {
		pause = false;
	}

	private void corruptedLevel() {
		JOptionPane.showMessageDialog(BoulderDash.getFen(), "Niveau corompu",
				"ERREUR", JOptionPane.ERROR_MESSAGE);
		BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
		BoulderDash.setState(EtatApplication.MenuPrincipal);
	}

	/**
	 * 
	 */
	public void restartLevel() {
		chargerNiveau(levelPath);
	}
}