/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;

/**
 * @author 4r3
 *
 */
public class Chutable extends ElementDynamique
{
	private boolean chute;

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Chutable(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		chute = false;
	}

	@Override
	public void refresh(Niveau N)
	{
		Case C = N.getCase(getPos_x(), getPos_y() + 1);
		if ( C instanceof Vide ) {
			N.echangeCases(getPos_x(), getPos_y(), getPos_x(), getPos_y() + 1);
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos_y(getPos_y() + 1);
			chute = true;
		} else if ( C instanceof Chutable || C instanceof MurNormal || C instanceof Sortie ) {
			if ( (N.getCase(getPos_x() + 1, getPos_y()) instanceof Vide) && (N.getCase(getPos_x() + 1, getPos_y() + 1) instanceof Vide) ) {
				N.echangeCases(getPos_x(), getPos_y(), getPos_x() + 1, getPos_y() + 1);
				N.remplirUpTable(getPos_x(), getPos_y());
				setPos(getPos_x() + 1, getPos_y() + 1);
				chute = true;
			} else if ( (N.getCase(getPos_x() - 1, getPos_y()) instanceof Vide) && (N.getCase(getPos_x() - 1, getPos_y() + 1) instanceof Vide) ) {
				N.echangeCases(getPos_x(), getPos_y(), getPos_x() - 1, getPos_y() + 1);
				N.remplirUpTable(getPos_x(), getPos_y());
				setPos(getPos_x() - 1, getPos_y() + 1);
				chute = true;
			} else {
				chute = false;
			}
		} else if ( C instanceof Vivant && chute ) {
			((Vivant) C).tuer(N);
		} else {
			chute = false;
		}
	}

	/**
	 * @return
	 */
	public boolean enChute()
	{
		return chute;
	}
}
