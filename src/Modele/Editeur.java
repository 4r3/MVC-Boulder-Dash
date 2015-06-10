package Modele;

public class Editeur {

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
