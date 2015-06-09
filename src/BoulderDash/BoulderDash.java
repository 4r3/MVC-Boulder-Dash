package BoulderDash;

import Modele.Jeu;
import Vue.Panel.Fenetre;
import Vue.Panel.Vues;

public class BoulderDash {

	private static Jeu jeu;
	private static Fenetre fen;

	private static void init() {
		jeu = new Jeu();

		fen = new Fenetre(jeu);
		fen.setVisible(true);

	}

	private static void Application() {
		while (true) {
			jeu.gestion();
			fen.changerCardLayout(Vues.MENUPRINCIPAL);
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
}
