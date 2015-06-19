/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

/**
 * @author 4r3
 * 
 */
public class Diamant extends Chutable {

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Diamant(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	@Override
	public String ID() {
		return "D";
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(), getY());
		N.insereVide(N.getPerso().getX(), N.getPerso().getY());
		N.remplirUpTable(N.getPerso().getX(), N.getPerso().getY());
		N.AddDscore();
		N.remUptable(this);
		return true;
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getDiamant();
	}

}
