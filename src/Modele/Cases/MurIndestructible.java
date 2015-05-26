package Modele.Cases;
import java.awt.image.BufferedImage;

import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

public class MurIndestructible extends Case
{
	private Animation animation;

	public MurIndestructible() {
		Sprite spriteMur = new Sprite("wall");
		BufferedImage[] wall = { spriteMur.getSprite(0, 0) };
		animation = new Animation(wall, Variables.VITESSE_ANIM);
	}

	public Animation getAnimation() {
		return animation;
	}

	@Override
	public String ID() {
		return "M";
	}
}
