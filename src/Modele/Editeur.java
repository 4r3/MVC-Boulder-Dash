package Modele;

import java.util.Observable;

public class Editeur extends Observable {

	private Niveau niveau;

	public Editeur() {
		this.niveau = new Niveau();
	}

	public void createNiveau(int x, int y) {
		this.niveau = new Niveau(x, y);
	}

	public Niveau getNiveau() {
		return niveau;
	}

}
