package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

public class MurIndestructible extends Case {

	public MurIndestructible(int x, int y) {
		super(x, y);
	}

	/**
	 * retourne le sprite d'un mur indestructible
	 */
	@Override
	public Animation getAnimation() {
		return TableAnimation.getMur();
	}

	@Override
	public String ID() {
		return "M";
	}

}
