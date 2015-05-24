package Modele.Cases;

import java.awt.image.BufferedImage;

import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

public class Boue extends Case {
	private Animation animation;

	public Boue() {
		Sprite spriteBoue = new Sprite("dirt");
		BufferedImage[] dirt = { spriteBoue.getSprite(0, 0) };
		animation = new Animation(dirt, Variables.VITESSE_ANIM);
	}

	public Animation getAnimation() {
		return animation;
	}

	@Override
	public String ID() {
		return "B";
	}
}
