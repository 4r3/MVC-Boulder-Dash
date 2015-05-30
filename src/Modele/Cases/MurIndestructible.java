package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

public class MurIndestructible extends Case
{

	public MurIndestructible()
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
		return "M";
	}
}
