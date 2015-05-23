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
		Case C = N.getCase(xdest, ydest);
		if ( C instanceof Boue ) {
			N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
			N.insereVide(getPos_x(), getPos_y());
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos(xdest, ydest);
		} else if ( C instanceof Vide ) {
			N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos(xdest, ydest);
		} else if ( C instanceof Sortie ) {
			if ( ((Sortie) C).isOuverte() ) {
				N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
				N.insereVide(getPos_x(), getPos_y());
				setPos(xdest, ydest);
				N.setFini();
			}
		} else if ( C instanceof Rocher ) {
			if ( Deplace == Directions.Gauche ) {
				if ( N.getCase(xdest - 1, ydest) instanceof Vide ) {
					N.echangeCases(xdest, ydest, xdest - 1, ydest);
					N.remplirUpTable(xdest, ydest);
				}
			} else if ( Deplace == Directions.Droite ) {
				if ( N.getCase(xdest + 1, ydest) instanceof Vide ) {
					N.echangeCases(xdest, ydest, xdest + 1, ydest);
					N.remplirUpTable(xdest, ydest);
				}
			}
		} else {
			System.out.println(N.getCase(xdest, ydest).getClass().getName());
		}
		setDeplace(Directions.Null);
	}

	@Override
	public String ID()
	{
		return "P";
	}
}
