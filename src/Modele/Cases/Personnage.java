package Modele.Cases;

import Modele.Niveau;

public class Personnage extends ElementDynamique
{
	Directions Deplace;

	public Personnage(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		Deplace = Directions.Null;
	}

	public void setDeplace(Directions D)
	{
		Deplace = D;
	}

	@Override
	public void refresh(Niveau N)
	{
		int xdest = getPos_x();
		int ydest = getPos_y();
		switch ( Deplace ) {
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
			case Null :
				return;
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
		setDeplace(Directions.Null);
	}

	@Override
	public String ID()
	{
		return "P";
	}
}
