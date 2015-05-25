package Modele.Cases;

import Modele.Niveau;

public class Personnage extends ElementDynamique implements Vivant
{
	Directions Deplace;
	boolean vivant;

	public Personnage(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		Deplace = Directions.Null;
	}

	public void setDeplace(Directions D)
	{
		Deplace = D;
	}

	public Directions getDeplace()
	{
		return Deplace;
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
		if ( C instanceof InterPersonnage ) {
			((InterPersonnage) C).PersonageArrive(N, xdest, ydest);
		} else if ( C instanceof Diamant ) {
			N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
			N.insereVide(getPos_x(), getPos_y());
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos(xdest, ydest);
			N.AddDscore();
			N.remUptable(C);
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

	@Override
	public void tuer(Niveau N)
	{
		N.setFini();
	}
}
