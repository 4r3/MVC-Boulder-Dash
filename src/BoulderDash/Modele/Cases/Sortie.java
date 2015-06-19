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
			System.out.println("sortie fermée");
			return false;
		}
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
