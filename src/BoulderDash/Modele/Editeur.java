package BoulderDash.Modele;

import java.util.Observable;

import BoulderDash.Modele.Animation.ChoixAnimation;
import BoulderDash.Modele.Cases.MurMagique;

public class Editeur extends Observable {

	private Niveau niveau;
	private ChoixAnimation iconActif;
	private int changedX;
	private int changedY;

	public Editeur() {
		this.setIconActif(ChoixAnimation.Personnage_Idle);
		changedX = -1;
		changedY = -1;
	}

	/**
	 * crée un niveau de taille standard
	 */
	public void createNiveau() {
		this.niveau = new Niveau();
		changedX = -1;
		changedY = -1;
		setChanged();
		notifyObservers();
	}

	/**
	 * crée un niveau de taille x par y dans l'éditeur
	 * 
	 * @param x
	 * @param y
	 */
	public void createNiveau(int x, int y) {
		this.niveau = new Niveau(x, y);
		changedX = -1;
		changedY = -1;
		setChanged();
		notifyObservers();
	}

	/**
	 * charge dans l'éditeur le niveau avec le chemin transmis en paramètre
	 * 
	 * @param path
	 *            chemin du niveau
	 */
	public void loadNiveau(String path) {
		niveau = new Niveau(path);
		changedX = -1;
		changedY = -1;
		setChanged();
		notifyObservers();
	}

	/**
	 * récupère le niveau dans l'éditeur
	 * 
	 * @return niveau de l'éditeur
	 */
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * @return récupère quel type de case est choisi
	 */
	public ChoixAnimation getIconActif() {
		return iconActif;
	}

	/**
	 * choisit le type de case à insérer dans le niveau
	 * 
	 * @param iconActif
	 *            case à choisir
	 */
	public void setIconActif(ChoixAnimation iconActif) {
		this.iconActif = iconActif;
	}

	@SuppressWarnings("incomplete-switch")
	public void modifierNiveau(int x, int y) {
		switch (iconActif) {
		case Personnage_Idle:
			if (niveau.getPerso() == null) {
				niveau.inserePersonage(x, y);
			} else {
				changedX = niveau.getPerso().getX();
				changedY = niveau.getPerso().getY();
				niveau.inserePersonage(x, y);
				setChanged();
				notifyObservers();
			}
			break;
		case Sortie:
			if (niveau.getSortie() == null) {
				niveau.insereSortie(x, y);
			} else {
				changedX = niveau.getSortie().getX();
				changedY = niveau.getSortie().getY();
				niveau.insereSortie(x, y);
				setChanged();
				notifyObservers();
			}
			niveau.getSortie().Ouvrir();
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
			((MurMagique) niveau.getCase(x, y)).activer(niveau);
			break;
		case Papillon:
			niveau.inserePapillon(x, y);
			break;
		}
		changedX = x;
		changedY = y;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return position x de la case modifiée
	 */
	public int getChangedX() {
		return changedX;
	}

	/**
	 * @return position y de la case modifiée
	 */
	public int getChangedY() {
		return changedY;
	}

	/**
	 * sauvegarde le niveau
	 * 
	 * @param nom
	 *            nom du niveau
	 */
	public void save(String nom) {
		niveau.exporter(nom);

	}

}
