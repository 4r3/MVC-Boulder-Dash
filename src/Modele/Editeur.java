package Modele;

import java.util.Observable;

public class Editeur extends Observable {

	Niveau niveau;

	public Editeur() {
		this.niveau = new Niveau();
	}

	public void createNiveau(int x, int y) {
		this.niveau = new Niveau(x, y);
	}

}
