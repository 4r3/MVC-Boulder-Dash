/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * @author 4r3
 *
 */
public abstract class Chutable extends Case {
	private EtatChutable etat;

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Chutable(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		etat = EtatChutable.Stable;
	}

	@Override
	public void refresh(Niveau N) {
		Case C = N.getCase(getX(), getY() + 1);
		etat = C.chutableArrive(N);
	}

	public void setChute() {
		etat = EtatChutable.Chute;
	}

	public boolean chute() {
		return etat == EtatChutable.Chute;
	}

	public void setInstable() {
		etat = EtatChutable.Instable;
	}

	public boolean instable() {
		return etat != EtatChutable.Stable;
	}

	public void setStable() {
		etat = EtatChutable.Stable;
	}

	public boolean stable() {
		return etat == EtatChutable.Stable;
	}

	@Override
	public EtatChutable chutableArrive(Niveau N) {
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

	@Override
	public void refreshAnim() {

	}
}
