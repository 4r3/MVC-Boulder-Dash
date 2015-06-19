package BoulderDash.Modele.Cases;

public abstract class ElementDynamique extends Case {
	private int offsetx;
	private int offsety;

	public ElementDynamique(int x, int y) {
		super(x, y);
		offsetx = 0;
		offsety = 0;
	}

	/**
	 * @param elementDynamique
	 * @return
	 */
	public boolean isInferior(ElementDynamique Ed) {
		return (getY() < Ed.getY())
				|| (getY() == Ed.getY() && getX() < Ed.getX());
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
