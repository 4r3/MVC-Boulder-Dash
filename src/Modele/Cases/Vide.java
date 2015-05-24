package Modele.Cases;

import java.awt.image.BufferedImage;

import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

public class Vide extends Case {
	private Animation animation;

	public Vide() {
		Sprite spriteVide = new Sprite("dirt_back");
		BufferedImage[] dirtBack = { spriteVide.getSprite(0, 0) };
		animation = new Animation(dirtBack, Variables.VITESSE_ANIM);
	}

	public Animation getAnimation() {
		return animation;
	}

	@Override
	public String ID() {
		return "V";
	}
}
