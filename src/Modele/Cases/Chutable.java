/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;

/**
 * @author 4r3
 *
 */
public abstract class Chutable extends ElementDynamique implements
		InterChutable, RefreshAnim {
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
		Case C = N.getCase(getPos_x(), getPos_y() + 1);
		if (C instanceof InterChutable) {
			etat = ((InterChutable) C)
					.chutableArrive(N, getPos_x(), getPos_y());
		} else if (C instanceof Vivant && etat == EtatChutable.Chute) {
			((Vivant) C).tuer(N);
		} else {
			etat = EtatChutable.Stable;
		}
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
		if ((N.getCase(x + 1, y) instanceof Vide)
				&& (N.getCase(x + 1, y + 1) instanceof Vide)) {
			if (((Chutable) N.getCase(x, y)).instable()) {
				N.echangeCases(x, y, x + 1, y + 1);
				N.remplirUpTable(x, y);
				((Chutable) N.getCase(x + 1, y + 1)).setPos(x + 1, y + 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else if ((N.getCase(x - 1, y) instanceof Vide)
				&& (N.getCase(x - 1, y + 1) instanceof Vide)) {
			if (((Chutable) N.getCase(x, y)).instable()) {
				N.echangeCases(x, y, x - 1, y + 1);
				N.remplirUpTable(x, y);
				((Chutable) N.getCase(x - 1, y + 1)).setPos(x - 1, y + 1);
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
