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
	@SuppressWarnings("incomplete-switch")
	@Override
	public void deplacer(Niveau N, Directions D)
	{
		int xdest = getPos_x();
		int ydest = getPos_y();
		switch ( D ) {
			case Bas :
				ydest++;
				break;
			case Droite :
				xdest++;
				break;
			case Gauche :
				xdest--;
				break;
			case Haut :
				ydest--;
				break;
			default :
				return;
		}
		if ( N.getCase(xdest, ydest).getClass().getName() == "Modele.Cases.Boue" ) {
			N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
			N.insereVide(getPos_x(), getPos_y());
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos(xdest, ydest);
		} else if ( N.getCase(xdest, ydest).getClass().getName() == "Modele.Cases.Vide" ) {
			N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos(xdest, ydest);
		}
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
