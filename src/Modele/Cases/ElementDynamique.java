package Modele.Cases;

import Modele.Niveau;

public abstract class ElementDynamique extends Case
{
	private int pos_x;
	private int pos_y;

	public ElementDynamique(int pos_x, int pos_y)
	{
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	public abstract void refresh(Niveau N);

	public int getPos_x()
	{
		return pos_x;
	}

	public void setPos_x(int pos_x)
	{
		this.pos_x = pos_x;
	}

	public int getPos_y()
	{
		return pos_y;
	}

	public void setPos_y(int pos_y)
	{
		this.pos_y = pos_y;
	}

	public void setPos(int pos_x, int pos_y)
	{
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
}
