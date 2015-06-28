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
	 * création d'un objet chutable à l'état stable par défaut
	 */
	public Chutable(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		etat = EtatChutable.Stable;
	}

	/**
	 * met à jour l'élément chutable, en interagissant avec la case située
	 * en-dessous
	 */
	@Override
	public void refresh(Niveau N) {
		Case C = N.getCase(getX(), getY() + 1);
		etat = C.chutableArrive(N);
	}

	/**
	 * met l'objet en état de chute
	 */
	public void setChute() {
		etat = EtatChutable.Chute;
	}

	/**
	 * vérifie si l'objet est en état de chute
	 * 
	 */
	public boolean chute() {
		return etat == EtatChutable.Chute;
	}

	/**
	 * met l'objet à l'état instable
	 */
	public void setInstable() {
		etat = EtatChutable.Instable;
	}

	/**
	 * vérifie si l'objet est instable ( la chute est considérée comme instable
	 * par nature)
	 */
	public boolean instable() {
		return etat != EtatChutable.Stable;
	}

	/**
	 * met l'objet à l'état stable
	 */
	public void setStable() {
		etat = EtatChutable.Stable;
	}

	/**
	 * vérifie si l'objet est stable
	 */
	public boolean stable() {
		return etat == EtatChutable.Stable;
	}

	/**
	 * fonction d'interaction avec un objet chutable, on vérifie que les cases à
	 * gauche au niveau de l'objet arrivant et l'objet d'arrivée sont vides, si
	 * oui alors l'objet est échangé avec cette dernière ; on effectue la même
	 * chose à droite
	 */
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
}
