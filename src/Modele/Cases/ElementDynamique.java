package Modele.Cases;

import Modele.Niveau;

public abstract class ElementDynamique extends Case {
	private int pos_x;
	private int pos_y;
	private int offsetx;
	private int offsety;

	public ElementDynamique(int pos_x, int pos_y) {
		this(pos_x, pos_y, false);
	}

	public ElementDynamique(int pos_x, int pos_y, boolean personnage) {
		super(false, personnage);
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		offsetx = 0;
		offsety = 0;
	}

	public abstract void refresh(Niveau N);

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

	public void setPos(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	/**
	 * @param elementDynamique
	 * @return
	 */
	public boolean isInferior(ElementDynamique Ed) {
		return (pos_y < Ed.getPos_y())
				|| (pos_y == Ed.getPos_y() && pos_x < Ed.getPos_x());
	}

	/**
	 * @param elementDynamique
	 * @return
	 */
	public boolean isSuperior(ElementDynamique Ed) {
		return pos_y > Ed.getPos_y();
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
