/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

/**
 * @author 4r3
 * 
 */
public class MurMagique extends Case
{
	private boolean active;

	public MurMagique()
	{
		active = false;
	}

	public void activer()
	{
		active = true;
	}

	public boolean isActive()
	{
		return active;
	}

	@Override
	public String ID()
	{
		if ( active ) {
			return "T";
		} else {
			return "X";
		}
	}

	@Override
	public Animation getAnimation(Niveau N)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
