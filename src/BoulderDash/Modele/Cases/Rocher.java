/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

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

	/**
	 * interaction avec le personnage, pousse le rocher à gauche ou à droite si
	 * il y a de la place
	 */
	@Override
	public boolean PersonageArrive(Niveau N) {
		if (N.getPerso().getDeplace() == Directions.Gauche) {
			if (N.getCase(getX() - 1, getY()).isVide()) {
				N.echangeCases(getX(), getY(), getX() - 1, getY());
				N.addUptable(getX(), getY());
				N.remplirUpTable(getX() + 1, getY());
			}
		} else if (N.getPerso().getDeplace() == Directions.Droite) {
			if (N.getCase(getX() + 1, getY()).isVide()) {
				N.echangeCases(getX(), getY(), getX() + 1, getY());
				N.addUptable(getX(), getY());
				N.remplirUpTable(getX() - 1, getY());
			}
		}
		return false;
	}

	/**
	 * retourne le sprite du Rocher
	 */
	@Override
	public Animation getAnimation() {
		return TableAnimation.getRocher();
	}
}
