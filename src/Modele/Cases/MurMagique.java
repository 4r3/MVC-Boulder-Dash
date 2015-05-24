/**
 * 
 */
package Modele.Cases;

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
}
