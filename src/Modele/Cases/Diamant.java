/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;

/**
 * @author 4r3
 *
 */
public class Diamant extends Chutable implements InterPersonnage
{

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Diamant(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
	}

	@Override
	public String ID()
	{
		return "D";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.insereVide(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);
		N.AddDscore();
		N.remUptable(this);

	}

}
