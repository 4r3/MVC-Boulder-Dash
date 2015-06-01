package Modele.Cases;

import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

public class MurIndestructible extends Case {

	public MurIndestructible() {

	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getMur();
	}

	@Override
	public String ID() {
		return "M";
	}
}
