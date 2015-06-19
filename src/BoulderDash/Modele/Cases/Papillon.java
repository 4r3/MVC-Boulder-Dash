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
public class Papillon extends ElementDynamique {
	Directions dirNav;

	/**
	 * 
	 */
	public Papillon(int x, int y) {
		super(x, y);
		dirNav = Directions.Haut;
	}

	@Override
	public void refresh(Niveau N) {
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
	}

	private boolean verifierHaut(Niveau N) {
		return N.getCase(getX(), getY() - 1).isVide();
	}

	private boolean verifierBas(Niveau N) {
		return N.getCase(getX(), getY() + 1).isVide();
	}

	private boolean verifierGauche(Niveau N) {
		return N.getCase(getX() - 1, getY()).isVide();
	}

	private boolean verifierDroite(Niveau N) {
		return N.getCase(getX() + 1, getY()).isVide();
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
	public String ID() {
		return "E";
	}

}
