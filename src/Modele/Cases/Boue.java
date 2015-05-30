package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

public class Boue extends Case implements InterPersonnage
{

	public Boue()
	{

	}

	@Override
	public Animation getAnimation(Niveau N)
	{
		return N.getTableAnim().getBoue();
	}

	@Override
	public String ID()
	{
		return "B";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.insereVide(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);
	}
}
