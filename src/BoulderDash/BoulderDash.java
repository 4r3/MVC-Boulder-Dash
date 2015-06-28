package BoulderDash;

import BoulderDash.Modele.Editeur;
import BoulderDash.Modele.EtatApplication;
import BoulderDash.Modele.Jeu;
import BoulderDash.Vue.Fenetre;

public class BoulderDash {

	private static Jeu jeu;
	private static Fenetre fen;
	private static Editeur edit;
	private static EtatApplication state;

	/**
	 * fonction d'initialisation du jeu
	 */
	private static void init() {
		state = EtatApplication.MenuPrincipal;
		jeu = new Jeu();
		edit = new Editeur();

		fen = new Fenetre();
		fen.setVisible(true);

	}

	/**
	 * fonction de jeu, s'exécute pendant tout le programme
	 */
	private static void Application() {
		while (true) {
			switch (state) {
			case Jeu:
				jeu.gestion();
				break;
			// $CASES-OMITTED$
			default:
				break;
			}

		}
	}

	/**
	 * main du programme, initialise le programme et le lance
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BoulderDash.init();
		BoulderDash.Application();
	}

	/**
	 * permet de récuperer le seul Jeu
	 * 
	 * @return
	 */
	public static Jeu getJeu() {
		return jeu;
	}

	/**
	 * permet de récuperer la fenêtre du jeu
	 * 
	 * @return
	 */
	public static Fenetre getFen() {
		return fen;
	}

	/**
	 * permet de récupérer l'éditeur du jeu
	 * 
	 * @return
	 */
	public static Editeur getEdit() {
		return edit;
	}

	/**
	 * permet de définir dans quel état est le programme
	 * 
	 * @param state
	 */
	public static void setState(EtatApplication state) {
		BoulderDash.state = state;
	}
}
