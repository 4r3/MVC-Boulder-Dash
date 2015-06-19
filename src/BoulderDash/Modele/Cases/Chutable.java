/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * @author 4r3
 *
 */
public abstract class Chutable extends ElementDynamique {
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
		etat = ((InterChutable) C).chutableArrive(N, getX(), getY());
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
		} else if (N.getCase(x - 1, y).isVide()
				&& N.getCase(x - 1, y + 1).isVide()) {
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

	@Override
	public void refreshAnim() {

	}
}
