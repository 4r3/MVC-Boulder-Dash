package BoulderDash;

import BoulderDash.Modele.Editeur;
import BoulderDash.Modele.Jeu;
import BoulderDash.Vue.Fenetre;
import BoulderDash.Vue.Vues;

public class BoulderDash {

	private static Jeu jeu;
	private static Fenetre fen;
	private static Editeur edit;

	private static void init() {
		jeu = new Jeu();
		edit = new Editeur();

		fen = new Fenetre(jeu);
		fen.setVisible(true);

	}

	private static void Application() {
		while (true) {
			jeu.gestion();
			fen.changerVue(Vues.MENUPRINCIPAL);
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
}
