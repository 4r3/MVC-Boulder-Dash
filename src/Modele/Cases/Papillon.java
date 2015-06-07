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
		return N.getCase(getPos_x(), getPos_y() - 1) instanceof Vide;
	}

	private boolean verifierBas(Niveau N) {
		return N.getCase(getPos_x(), getPos_y() + 1) instanceof Vide;
	}

	private boolean verifierGauche(Niveau N) {
		return N.getCase(getPos_x() - 1, getPos_y()) instanceof Vide;
	}

	private boolean verifierDroite(Niveau N) {
		return N.getCase(getPos_x() + 1, getPos_y()) instanceof Vide;
	}

	private void allerHaut(Niveau N) {
		N.echangeCases(getPos_x(), getPos_y() - 1, getPos_x(), getPos_y());
		setPos_y(getPos_y() - 1);
		dirNav = Directions.Haut;
	}

	private void allerBas(Niveau N) {
		N.echangeCases(getPos_x(), getPos_y() + 1, getPos_x(), getPos_y());
		setPos_y(getPos_y() + 1);
		dirNav = Directions.Bas;
	}

	private void allerGauche(Niveau N) {
		N.echangeCases(getPos_x(), getPos_y(), getPos_x() - 1, getPos_y());
		setPos_x(getPos_x() - 1);
		dirNav = Directions.Gauche;
	}

	private void allerDroite(Niveau N) {
		N.echangeCases(getPos_x(), getPos_y(), getPos_x() + 1, getPos_y());
		setPos_x(getPos_x() + 1);
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
