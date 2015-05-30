package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

public class Vide extends Case implements InterPersonnage
{

	public Vide()
	{

	}

	public Animation getAnimation(Niveau N)
	{
		return N.getTableAnim().getVide();
	}

	@Override
	public String ID()
	{
		return "V";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);

	}
}
