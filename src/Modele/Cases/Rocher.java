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
public class Rocher extends Chutable {

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Rocher(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	@Override
	public String ID() {
		return "R";
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		if (N.getPerso().getDeplace() == Directions.Gauche) {
			if (N.getCase(getX() - 1, getY()).isVide()) {
				N.echangeCases(getX(), getY(), getX() - 1, getY());
				N.addUptable(getX() - 1, getY());
				N.remplirUpTable(getX(), getY());
			}
		} else if (N.getPerso().getDeplace() == Directions.Droite) {
			if (N.getCase(getX() + 1, getY()).isVide()) {
				N.echangeCases(getX(), getY(), getX() + 1, getY());
				N.addUptable(getX() + 1, getY());
				N.remplirUpTable(getX(), getY());
			}
		}
		return false;
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getRocher();
	}
}
