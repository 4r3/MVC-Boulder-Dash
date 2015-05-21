package Modele.Cases;

import Modele.Niveau;

public class Personnage extends ElementDynamique
{
	public Personnage(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Modele.Cases.ElementDynamique#collision(Modele.Niveau,
	 * Modele.Cases.Case)
	 */
	@Override
	public void collision(Niveau N, Case C)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Modele.Cases.ElementDynamique#deplacer()
	 */
	@Override
	public void deplacer()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Niveau N)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public String ID()
	{
		return "P";
	}
}
