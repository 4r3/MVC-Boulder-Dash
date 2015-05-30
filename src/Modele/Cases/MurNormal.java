package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

public class MurNormal extends Case
{

	public MurNormal()
	{

	}

	@Override
	public Animation getAnimation(Niveau N)
	{
		return N.getTableAnim().getMur();
	}

	@Override
	public String ID()
	{
		return "N";
	}
}
