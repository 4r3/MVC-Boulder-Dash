package Modele.Cases;

import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

public class MurNormal extends Case {

	public MurNormal() {

	}

	public Animation getAnimation() {
		return TableAnimation.getMur();
	}

	@Override
	public String ID() {
		return "N";
	}
}
