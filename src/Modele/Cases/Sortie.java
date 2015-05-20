/**
 * 
 */
package Modele.Cases;

/**
 * @author 4r3
 *
 */
public class Sortie extends Murs
{
	private boolean ouverte;

	public Sortie()
	{
		ouverte = false;
	}

	@Override
	public String ID()
	{
		return "S";
	}
}
