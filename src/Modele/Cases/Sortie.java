/**
 * 
 */
package Modele.Cases;

/**
 * @author 4r3
 *
 */
public class Sortie extends Case
{
	private boolean ouverte;

	public Sortie()
	{
		setOuverte(false);
	}

	@Override
	public String ID()
	{
		return "S";
	}

	public boolean isOuverte()
	{
		return ouverte;
	}

	public void setOuverte(boolean ouverte)
	{
		this.ouverte = ouverte;
	}
}
