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

	/**
	 * crée un nouveau jeu, avec son score à 0 et ses informations de niveau à
	 * null
	 */
	public Jeu() {
		score = 0;
		levelPath = null;
		level = null;
	}

	/**
	 * charge un niveau situé au chemin path, initialise les données niveau du
	 * jeu
	 * 
	 * @param path
	 *            chemin vers le niveau
	 */
	public void chargerNiveau(String path) {
		deleteObservers();
		niveauFini = false;
		interuption = false;
		levelPath = path;
		level = new Niveau(path);
	}

	/**
	 * permet de récupérer le niveau du jeu
	 * 
	 * @return niveau dans le jeu
	 */
	public Niveau getNiveau() {
		return level;
	}

	/**
	 * récupère la liste des niveaux
	 * 
	 * @return String[] liste des niveaux
	 */
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

	/**
	 * Boucle de jeu, gère le déroulement du jeu
	 */
	public void gestion() {
		int i = 0;
		long time = System.currentTimeMillis();

		if (level == null) {
			return;
		}

		while (!level.isFini() && !interuption) {
			// mesure du temps d'éxecution du dernier cycle, et calcul du temps
			// d'attente pour ce cycle
			time = Variables.FRAME + System.currentTimeMillis() - time;
			if (time <= 0) {
				time = 1;
			}
			// temps d'attente du cycle
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time = System.currentTimeMillis();
			// gestion de la pause
			if (!pause) {
				// gestion du cycle de mise à jour jeu, s'exécute tous les X
				// cycles
				if (i == 0) {
					try {
						level.refresh();
					} catch (NullPointerException e) {
						corruptedLevel();
						return;
					}
				}

				// rafraichisement des animations du jeu
				level.refreshAnim();

				i = (i + 1) % Variables.CYCLES;

				// notification des changements à la fenêtre
				setChanged();
				notifyObservers();
			}
		}
		// gestion de fin de jeux
		BoulderDash.setState(EtatApplication.MenuPrincipal);
		// verification si le jeux a été interompu
		if (!interuption) {
			// si le jeu n'a pas été interompu alors on incremente le score
			try {
				Thread.sleep(Variables.FRAME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			level.refreshAnim();
			niveauFini = true;
			int nScore = level.getTmax() + level.getScore();
			setChanged();
			notifyObservers();
			if (level.getPerso().isVivant()) {
				score += nScore;
			} else {
				score = 0;
			}
		}
	}

	/**
	 * met le jeu en pause
	 */
	public void pauseOn() {
		pause = true;
	}

	/**
	 * désactive la pause
	 */
	public void pauseOff() {
		pause = false;
	}

	/**
	 * message d'erreur lors d'un crash du niveau
	 */
	private static void corruptedLevel() {
		JOptionPane.showMessageDialog(BoulderDash.getFen(), "Niveau corompu",
				"ERREUR", JOptionPane.ERROR_MESSAGE);
		BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
		BoulderDash.setState(EtatApplication.MenuPrincipal);
	}

	/**
	 * redémarre le niveau en cours, perte du score réalisé sur le niveau en
	 * cours
	 */
	public void restartLevel() {
		chargerNiveau(levelPath);
	}

	/**
	 * remet le score à 0
	 */
	public void resetScore() {
		score = 0;
	}

	/**
	 * récupère le score du niveau additionné à celui du jeu
	 */
	public int getScore() {
		return score + level.getScore();
	}

	/**
	 * interrompt le jeu (appelé par les menus lorsque l'on redemarre ou quitte
	 * le niveau)
	 */
	public void interompre() {
		interuption = true;
	}

	/**
	 * récupère si le niveau à été fini
	 */
	public boolean isFini() {
		return niveauFini;
	}
}