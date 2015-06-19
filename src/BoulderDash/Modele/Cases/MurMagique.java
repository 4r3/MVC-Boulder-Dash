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

	// TODO trouver comment se débarasser du instanceof
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

	// TODO trouver comment se débarasser du instanceof
	@Override
	public EtatChutable chutableArrive(Niveau N) {
		if (((Chutable) N.getCase(getX(), getY() - 1)).chute()) {
			if (!active) {
				activer(N);
			}
			N.remUptable(N.getCase(getX(), getY() - 1));
			if (N.getCase(getX(), getY() + 1).isVide()) {
				if (N.getCase(getX(), getY() - 1) instanceof Diamant) {
					N.insereRocher(getX(), getY() + 1);
				} else {

					N.insereDiamant(getX(), getY() + 1);
				}
				((Chutable) N.getCase(getX(), getY() + 1)).setChute();
			}
			N.insereVide(getX(), getY() - 1);

			return EtatChutable.Chute;
		} else {
			return modeMur(N);
		}
	}

	private EtatChutable modeMur(Niveau N) {
		if ((N.getCase(getX() + 1, getY() - 1).isVide())
				&& (N.getCase(getX() + 1, getY()).isVide())) {
			if (((Chutable) N.getCase(getX(), getY() - 1)).instable()) {
				N.echangeCases(getX() + 1, getY(), getX(), getY() - 1);
				N.remplirUpTable(getX(), getY() - 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else if (N.getCase(getX() - 1, getY()).isVide()
				&& N.getCase(getX() - 1, getY() - 1).isVide()) {
			if (((Chutable) N.getCase(getX(), getY() - 1)).instable()) {
				N.echangeCases(getX(), getY() - 1, getX() - 1, getY());
				N.remplirUpTable(getX(), getY() - 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else {
			return EtatChutable.Stable;
		}
	}
}
