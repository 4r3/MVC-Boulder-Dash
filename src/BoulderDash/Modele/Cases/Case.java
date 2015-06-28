package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;

public abstract class Case implements Interactions, Refresh {

	private int x;
	private int y;
	boolean vide;

	/**
	 * constructeur, crée une case non vide avec sa position interne a x,y
	 * 
	 * @param x
	 * @param y
	 */
	public Case(int x, int y) {
		this(x, y, false);
	}

	/**
	 * constructeur, crée une case quipeut etre vide avec sa position interne a
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
	 * fonction de recupération su sprite de la case
	 */
	public abstract Animation getAnimation();

	/**
	 * fonction permetant de verifier si la case est vide
	 */
	public boolean isVide() {
		return vide;
	}

	/**
	 * fonction permettant de savoir si la iorité de la case est superieure a
	 * celle d'une autre les case les plus bas dans le tableau sont les plus
	 * prioritaires
	 */
	public boolean isSuperior(Case C) {
		return getY() > C.getY();
	}

	/**
	 * fonction d'interaction avec un objet chutable, est appelé quand un
	 * element chutable tombe vers une case, retourne stable par defaut
	 */
	@Override
	public EtatChutable chutableArrive(Niveau N) {
		return EtatChutable.Stable;
	}

	/**
	 * fonction d'interaction avec un personnage, est appelé quand un personnage
	 * arrive vers une case, retourne false par defaut
	 */
	@Override
	public boolean PersonageArrive(Niveau N) {
		return false;
	}

	/**
	 * fonction d'interaction avec un enemi, est appelé quand un enemi arrive
	 * vers une case, retourne false par defaut
	 */
	@Override
	public boolean EnemiArrive(Niveau N) {
		return false;
	}

	/**
	 * fonction de mise a jour de la case, ne fait rien par defaut
	 */
	@Override
	public void refresh(Niveau N) {
	}

	/**
	 * fonction de mise a jour de l'animation, permet de changer d'animation
	 * pour les objets dont l'animation change
	 */
	@Override
	public void refreshAnim() {
	}

	/**
	 * fonction permetant de savoir si l'objet doit rester ou non dans la table
	 * de mise a jour
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
