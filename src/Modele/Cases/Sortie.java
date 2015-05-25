/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;

/**
 * @author 4r3
 *
 */
public class Sortie extends Case implements InterPersonnage
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

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		if ( ouverte ) {
			N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
			N.getPerso().setPos(x, y);
			N.setFini();
		}
	}
}
