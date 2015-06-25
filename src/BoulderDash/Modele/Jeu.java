package BoulderDash.Modele;

import java.io.File;
import java.util.Observable;

import javax.swing.JOptionPane;

import BoulderDash.BoulderDash;
import BoulderDash.Vue.Vues;

public class Jeu extends Observable {

	private Niveau level;
	private String levelPath;
	private int score;
	private boolean pause;
	private boolean interuption;
	private boolean niveauFini;

	public Jeu() {
		score = 0;
		levelPath = null;
		level = null;
	}

	public void chargerNiveau(String path) {
		deleteObservers();
		niveauFini = false;
		interuption = false;
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

		while (!level.isFini() && !interuption) {
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
				notifyObservers();
			}
		}
		if (!interuption) {
			try {
				Thread.sleep(Variables.FRAME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			level.refreshAnim();
			niveauFini = true;
			setChanged();
			notifyObservers();
			if (level.getPerso().isVivant()) {
				score += level.getScore();
				score += level.getTmax();
			} else {
				score = 0;
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

	private static void corruptedLevel() {
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

	public int getScore() {
		return score + level.getScore();
	}

	public void interompre() {
		interuption = true;
	}

	/**
	 * 
	 */
	public boolean isFini() {
		return niveauFini;
	}
}