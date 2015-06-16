package Modele;

import java.util.Observable;

import BoulderDash.BoulderDash;
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
			BoulderDash.getEdit().niveau.inserePersonage(x, y);
			break;
		case Sortie:
			BoulderDash.getEdit().niveau.insereSortie(x, y);
			break;
		case Diamant:
			BoulderDash.getEdit().niveau.insereDiamant(x, y);
			break;
		case Rocher:
			BoulderDash.getEdit().niveau.insereRocher(x, y);
			break;
		case Vide:
			BoulderDash.getEdit().niveau.insereVide(x, y);
			break;
		case Boue:
			BoulderDash.getEdit().niveau.insereBoue(x, y);
			break;
		case Mur:
			BoulderDash.getEdit().niveau.insereMurNormal(x, y);
			break;
		case Mur_Indestructible:
			BoulderDash.getEdit().niveau.insereMurIndestructible(x, y);
			break;
		case Mur_Magique:
			BoulderDash.getEdit().niveau.insereMurMagique(x, y);
			break;
		case Papillon:
			BoulderDash.getEdit().niveau.inserePapillon(x, y);
			break;
		}
		setChanged();
		notifyObservers();
	}

}
