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
public class Sortie extends Case implements InterPersonnage {
	private boolean ouverte;
	private Animation animation;

	public Sortie() {
		Fermer();
	}

	public Animation getAnimation() {
		return this.animation;
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
		this.animation = TableAnimation.getSortie();
		this.animation.start();
	}

	public void Fermer() {
		this.ouverte = false;
		this.animation = TableAnimation.getMur();
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y) {
		if (ouverte) {
			N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x,
					y);
			N.getPerso().setPos(x, y);
			N.setFini();
		} else {
			System.out.println("sortie fermée");
		}
	}
}
