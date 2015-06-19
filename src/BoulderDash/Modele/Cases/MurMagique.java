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
public class MurMagique extends Case {
	private boolean active;

	public MurMagique(int x, int y) {
		super(x, y);
		active = false;
	}

	public void activer(Niveau N) {
		active = true;
		if (N.getCase(getX() - 1, getY()) instanceof MurMagique
				&& !((MurMagique) N.getCase(getX() - 1, getY())).isActive()) {
			((MurMagique) N.getCase(getX() - 1, getY())).activer(N);
		}

		if (N.getCase(getX() + 1, getY()) instanceof MurMagique
				&& !((MurMagique) N.getCase(getX() + 1, getY())).isActive()) {
			((MurMagique) N.getCase(getX() + 1, getY())).activer(N);
		}
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public String ID() {
		if (active) {
			return "T";
		} else {
			return "X";
		}
	}

	@Override
	public Animation getAnimation() {
		if (active) {
			return TableAnimation.getMurMagique();
		} else {
			return TableAnimation.getMur();
		}
	}

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y) {
		if (((Chutable) N.getCase(x, y)).chute()) {
			if (!active) {
				activer(N);
			}
			N.remUptable(N.getCase(x, y));
			if (N.getCase(x, y + 2).isVide()) {
				if (N.getCase(x, y) instanceof Diamant) {
					N.insereRocher(x, y + 2);
				} else {

					N.insereDiamant(x, y + 2);
				}
				((Chutable) N.getCase(x, y + 2)).setChute();
			}
			N.insereVide(x, y);

			return EtatChutable.Chute;
		} else {
			return modeMur(N, x, y);
		}
	}

	private static EtatChutable modeMur(Niveau N, int x, int y) {
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
