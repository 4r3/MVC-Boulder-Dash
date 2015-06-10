package Modele;

public class Editeur {

	Niveau niveau;

	public Editeur() {
		this.niveau = new Niveau();
	}

	public void createNiveau(int x, int y) {
		this.niveau = new Niveau(x, y);
	}

}
