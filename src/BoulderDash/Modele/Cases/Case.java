package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;

public abstract class Case implements Interactions, Refresh {

	private int x;
	private int y;
	boolean vide;

	/**
	 * constructeur, crée une case non vide avec sa position interne à x,y
	 * 
	 * @param x
	 * @param y
	 */
	public Case(int x, int y) {
		this(x, y, false);
	}

	/**
	 * constructeur, crée une case qui peut être vide avec sa position interne à
	 * x,y
	 * 
	 * @param x
	 * @param y
	 */
	public Case(int x, int y, boolean vide) {
		this.x = x;
		this.y = y;
		this.vide = vide;
	}

	/**
	 * Retourne l'identifiant de la case
	 */
	@SuppressWarnings("static-method")
	public String ID() {
		return "C";
	}

	/**
	 * fonction de récupération du sprite de la case
	 */
	public abstract Animation getAnimation();

	/**
	 * fonction permettant de vérifier si la case est vide
	 */
	public boolean isVide() {
		return vide;
	}

	/**
	 * fonction permettant de savoir si la priorité de la case est supérieure à
	 * celle d'une autre ; les cases les plus basses dans le tableau sont les
	 * plus prioritaires
	 */
	public boolean isSuperior(Case C) {
		return getY() > C.getY();
	}

	/**
	 * fonction d'interaction avec un objet chutable, est appelée quand un
	 * élément chutable tombe vers une case, retourne stable par défaut
	 */
	@Override
	public EtatChutable chutableArrive(Niveau N) {
		return EtatChutable.Stable;
	}

	/**
	 * fonction d'interaction avec un personnage, est appelé quand un personnage
	 * arrive vers une case, retourne false par défaut
	 */
	@Override
	public boolean PersonageArrive(Niveau N) {
		return false;
	}

	/**
	 * fonction d'interaction avec un enemi, est appelé quand un enemi arrive
	 * vers une case, retourne false par défaut
	 */
	@Override
	public boolean EnemiArrive(Niveau N) {
		return false;
	}

	/**
	 * fonction de mise à jour de la case, ne fait rien par défaut
	 */
	@Override
	public void refresh(Niveau N) {
	}

	/**
	 * fonction de mise à jour de l'animation, permet de changer d'animation
	 * pour les objets dont l'animation change
	 */
	@Override
	public void refreshAnim() {
	}

	/**
	 * fonction permetant de savoir si l'objet doit rester ou non dans la table
	 * de mise à jour
	 */
	@Override
	public boolean stayInUpTable() {
		return false;
	}

	/**
	 * getter de la position en x de la case
	 */
	public int getX() {
		return x;
	}

	/**
	 * setter de la position en x de la case
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getter de la position en y de la case
	 */
	public int getY() {
		return y;
	}

	/**
	 * setter de la position en y de la case
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * setter des positions en x et y de la case
	 */
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
