package Modele;

import java.util.Observable;

import Modele.Animation.ChoixAnimation;

public class Editeur extends Observable {

	private Niveau niveau;
	private ChoixAnimation iconActif;

	public Editeur() {
		this.niveau = new Niveau();
		this.setIconActif(ChoixAnimation.Personnage_Idle);
	}

	public void createNiveau(int x, int y) {
		this.niveau = new Niveau(x, y);
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public ChoixAnimation getIconActif() {
		return iconActif;
	}

	public void setIconActif(ChoixAnimation iconActif) {
		this.iconActif = iconActif;
	}

	@SuppressWarnings("incomplete-switch")
	public void modifierNiveau(int x, int y) {
		switch (iconActif) {
		case Personnage_Idle:
			niveau.inserePersonage(x, y);
			break;
		case Sortie:
			niveau.insereSortie(x, y);
			break;
		case Diamant:
			niveau.insereDiamant(x, y);
			break;
		case Rocher:
			niveau.insereRocher(x, y);
			break;
		case Vide:
			niveau.insereVide(x, y);
			break;
		case Boue:
			niveau.insereBoue(x, y);
			break;
		case Mur:
			niveau.insereMurNormal(x, y);
			break;
		case Mur_Indestructible:
			niveau.insereMurIndestructible(x, y);
			break;
		case Mur_Magique:
			niveau.insereMurMagique(x, y);
			break;
		case Papillon:
			niveau.inserePapillon(x, y);
			break;
		}
		setChanged();
		notifyObservers();
	}

}
