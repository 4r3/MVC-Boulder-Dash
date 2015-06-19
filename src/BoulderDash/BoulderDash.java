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

	private static void init() {
		state = EtatApplication.MenuPrincipal;
		jeu = new Jeu();
		edit = null;

		fen = new Fenetre();
		fen.setVisible(true);

	}

	private static void Application() {
		while (true) {
			switch (state) {
			case ChoixNiveau:
			case EditeurNew:
				edit = new Editeur();
				state = EtatApplication.Editeur;
				break;
			case Editeur:
				break;
			case Jeu:
				jeu.gestion();
				break;
			case MenuPrincipal:
			default:
				break;
			}

		}
	}

	public static void main(String[] args) {
		BoulderDash.init();
		BoulderDash.Application();
	}

	public static Jeu getJeu() {
		return jeu;
	}

	public static Fenetre getFen() {
		return fen;
	}

	public static Editeur getEdit() {
		return edit;
	}

	public static void setState(EtatApplication state) {
		BoulderDash.state = state;
	}
}
