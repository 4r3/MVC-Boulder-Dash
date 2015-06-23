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
public class Sortie extends Case {
	private boolean ouverte;

	// private Animation animation;

	public Sortie(int x, int y) {
		super(x, y);
		Fermer();
	}

	@Override
	public String ID() {
		return "S";
	}

	public boolean isOuverte() {
		return ouverte;
	}

	public void Ouvrir() {
		this.ouverte = true;
	}

	public void Fermer() {
		this.ouverte = false;
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		if (ouverte) {
			N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(),
					getY());
			N.setFini();
			return true;
		} else {
			return false;
		}
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
		getAnimation().update();
	}

	@Override
	public Animation getAnimation() {
		if (ouverte) {
			return TableAnimation.getSortie();
		} else {
			return TableAnimation.getMur();
		}
	}
}
