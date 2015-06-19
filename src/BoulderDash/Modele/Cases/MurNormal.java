package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

public class MurNormal extends Case {

	/**
	 * @param x
	 * @param y
	 */
	public MurNormal(int x, int y) {
		super(x, y);
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getMur();
	}

	@Override
	public String ID() {
		return "N";
	}

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y) {
		if ((N.getCase(x + 1, y).isVide())
				&& (N.getCase(x + 1, y + 1).isVide())) {
			if (((Chutable) N.getCase(x, y)).instable()) {
				N.echangeCases(x, y, x + 1, y + 1);
				N.remplirUpTable(x, y);
				((Chutable) N.getCase(x + 1, y + 1)).setXY(x + 1, y + 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else if ((N.getCase(x - 1, y).isVide())
				&& (N.getCase(x - 1, y + 1).isVide())) {
			if (((Chutable) N.getCase(x, y)).instable()) {
				N.echangeCases(x, y, x - 1, y + 1);
				N.remplirUpTable(x, y);
				((Chutable) N.getCase(x - 1, y + 1)).setXY(x - 1, y + 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else {
			return EtatChutable.Stable;
		}
	}
}
