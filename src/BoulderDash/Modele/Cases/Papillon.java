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
public class Papillon extends Case {
	Directions dirNav;
	boolean tempo;

	/**
	 * 
	 */
	public Papillon(int x, int y) {
		super(x, y);
		dirNav = Directions.Haut;
		tempo = true;
	}

	@Override
	public void refresh(Niveau N) {
		if (!tempo) {
			switch (dirNav) {
			case Haut:
				navHaut(N);
				break;
			case Bas:
				navBas(N);
				break;
			case Gauche:
				navGauche(N);
				break;
			case Droite:
				navDroite(N);
				break;
			// $CASES-OMITTED$
			default:
				break;
			}
			tempo = true;
		} else {
			tempo = false;
		}
	}

	private boolean verifierHaut(Niveau N) {
		return N.getCase(getX(), getY() - 1).EnemiArrive(N);
	}

	private boolean verifierBas(Niveau N) {
		return N.getCase(getX(), getY() + 1).EnemiArrive(N);
	}

	private boolean verifierGauche(Niveau N) {
		return N.getCase(getX() - 1, getY()).EnemiArrive(N);
	}

	private boolean verifierDroite(Niveau N) {
		return N.getCase(getX() + 1, getY()).EnemiArrive(N);
	}

	private void allerHaut(Niveau N) {
		N.echangeCases(getX(), getY() - 1, getX(), getY());
		dirNav = Directions.Haut;
	}

	private void allerBas(Niveau N) {
		N.echangeCases(getX(), getY() + 1, getX(), getY());
		dirNav = Directions.Bas;
	}

	private void allerGauche(Niveau N) {
		N.echangeCases(getX(), getY(), getX() - 1, getY());
		dirNav = Directions.Gauche;
	}

	private void allerDroite(Niveau N) {
		N.echangeCases(getX(), getY(), getX() + 1, getY());
		dirNav = Directions.Droite;
	}

	private void navHaut(Niveau N) {
		if (verifierGauche(N)) {
			allerGauche(N);
		} else if (verifierHaut(N)) {
			allerHaut(N);
		} else if (verifierDroite(N)) {
			allerDroite(N);
		} else {
			dirNav = Directions.Bas;
		}
	}

	private void navBas(Niveau N) {

		if (verifierDroite(N)) {
			allerDroite(N);
		} else if (verifierBas(N)) {
			allerBas(N);
		} else if (verifierGauche(N)) {
			allerGauche(N);
		} else {
			dirNav = Directions.Haut;
		}
	}

	private void navGauche(Niveau N) {

		if (verifierBas(N)) {
			allerBas(N);
		} else if (verifierGauche(N)) {
			allerGauche(N);
		} else if (verifierHaut(N)) {
			allerHaut(N);
		} else {
			dirNav = Directions.Droite;
		}
	}

	private void navDroite(Niveau N) {
		if (verifierHaut(N)) {
			allerHaut(N);
		} else if (verifierDroite(N)) {
			allerDroite(N);
		} else if (verifierBas(N)) {
			allerBas(N);
		} else {
			dirNav = Directions.Gauche;
		}
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getPapillon();
	}

	@Override
	public EtatChutable chutableArrive(Niveau N) {
		if (((Chutable) N.getCase(getX(), getY() - 1)).chute()) {
			N.addToScore(100);
			for (int y = getY() - 1; y <= getY() + 1; y++) {
				for (int x = getX() - 1; x <= getX() + 1; x++) {
					N.remUptable(N.getCase(x, y));
					N.insereDiamant(x, y);
				}
			}
		}
		return EtatChutable.Stable;
	}

	@Override
	public String ID() {
		return "E";
	}

}
