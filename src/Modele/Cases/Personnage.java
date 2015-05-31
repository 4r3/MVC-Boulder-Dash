package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.ChoixAnimation;

public class Personnage extends ElementDynamique implements Vivant
{
	Directions Deplace;
	private ChoixAnimation animation;
	boolean vivant;

	public Personnage(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		Deplace = Directions.Null;

		animation = ChoixAnimation.Personnage_Idle;
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
				animation = ChoixAnimation.Personnage_Marche_Bas;
				break;
			case Droite :
				xdest++;
				animation = ChoixAnimation.Personnage_Marche_Droite;
				break;
			case Gauche :
				animation = ChoixAnimation.Personnage_Marche_Gauche;
				xdest--;
				break;
			case Haut :
				ydest--;
				animation = ChoixAnimation.Personnage_Marche_Haut;
				break;
			case Null :
				animation = ChoixAnimation.Personnage_Idle;
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
	}

	@Override
	public Animation getAnimation(Niveau N)
	{
		return N.getTableAnim().Personnage(animation);
	}

	@Override
	public String ID()
	{
		return "P";
	}

	@Override
	public void tuer(Niveau N)
	{
		animation = ChoixAnimation.Personnage_Mort;
		//N.setFini();
	}
}
