package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;

public abstract class Case implements Interactions, Refresh {

	private int x;
	private int y;
	boolean vide;

	public Case(int x, int y) {
		this(x, y, false);
	}

	public Case(int x, int y, boolean vide) {
		this.x = x;
		this.y = y;
		this.vide = vide;
	}

	@SuppressWarnings("static-method")
	public String ID() {
		return "C";
	}

	public abstract Animation getAnimation();

	public boolean isVide() {
		return vide;
	}

	// methodes communes

	/**
	 * @param elementDynamique
	 * @return
	 */
	public boolean isSuperior(Case C) {
		return getY() > C.getY();
	}

	@Override
	public EtatChutable chutableArrive(Niveau N) {
		return EtatChutable.Stable;
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		return false;
	}

	@Override
	public void refresh(Niveau N) {
	}

	@Override
	public void refreshAnim() {
	}

	@Override
	public boolean stayInUpTable() {
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
