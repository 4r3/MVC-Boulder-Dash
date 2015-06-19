package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

public abstract class ElementDynamique extends Case {
	private int offsetx;
	private int offsety;

	public ElementDynamique(int x, int y) {
		super(x, y);
		offsetx = 0;
		offsety = 0;
	}

	public abstract void refresh(Niveau N);

	/**
	 * @param elementDynamique
	 * @return
	 */
	public boolean isInferior(ElementDynamique Ed) {
		return (getY() < Ed.getY())
				|| (getY() == Ed.getY() && getX() < Ed.getX());
	}

	/**
	 * @param elementDynamique
	 * @return
	 */
	public boolean isSuperior(ElementDynamique Ed) {
		return getY() > Ed.getY();
	}

	/**
	 * @return
	 */
	public int getoffsetX() {
		return offsetx;
	}

	public int getoffsetY() {
		return offsety;
	}

	public void setoffsetX(int x) {
		offsetx = x;
	}

	public void setoffsetY(int y) {
		offsety = y;
	}
}
