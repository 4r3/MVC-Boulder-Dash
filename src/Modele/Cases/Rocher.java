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
public class Rocher extends Chutable implements InterPersonnage {

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
	public boolean PersonageArrive(Niveau N, int x, int y) {
		if (N.getPerso().getDeplace() == Directions.Gauche) {
			if (N.getCase(x - 1, y) instanceof Vide) {
				N.echangeCases(x, y, x - 1, y);
				N.addUptable(x - 1, y);
				N.remplirUpTable(x, y);
				setPos_x(x - 1);
			}
		} else if (N.getPerso().getDeplace() == Directions.Droite) {
			if (N.getCase(x + 1, y) instanceof Vide) {
				N.echangeCases(x, y, x + 1, y);
				N.addUptable(x + 1, y);
				N.remplirUpTable(x, y);
				setPos_x(x + 1);
			}
		}
		return false;
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getRocher();
	}
}
