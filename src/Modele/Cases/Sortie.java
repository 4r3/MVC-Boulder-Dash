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
public class Sortie extends Case {
	private boolean ouverte;

	// private Animation animation;

	public Sortie() {
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
		// this.animation = TableAnimation.getSortie();
		// this.animation.start();
	}

	public void Fermer() {
		this.ouverte = false;
		// this.animation = TableAnimation.getMur();
	}

	@Override
	public boolean PersonageArrive(Niveau N, int x, int y) {
		if (ouverte) {
			N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x,
					y);
			N.getPerso().setPos(x, y);
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
				((Chutable) N.getCase(x + 1, y + 1)).setPos(x + 1, y + 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else if ((N.getCase(x - 1, y).isVide())
				&& (N.getCase(x - 1, y + 1).isVide())) {
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
