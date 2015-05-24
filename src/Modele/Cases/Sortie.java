/**
 * 
 */
package Modele.Cases;

import java.awt.image.BufferedImage;

import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

/**
 * @author 4r3
 * 
 */
public class Sortie extends Murs {
	private boolean ouverte;
	private static Animation animation;

	public Sortie() {
		setOuverte(false);

		Sprite spriteSortie = new Sprite("beacon");
		BufferedImage[] sortie = { spriteSortie.getSprite(0, 0),
				spriteSortie.getSprite(1, 0), spriteSortie.getSprite(2, 0),
				spriteSortie.getSprite(3, 0) };
		animation = new Animation(sortie, Variables.VITESSE_ANIM);
	}

	public Animation getAnimation() {
		return animation;
	}

	@Override
	public String ID() {
		return "S";
	}

	public boolean isOuverte() {
		return ouverte;
	}

	public void setOuverte(boolean ouverte) {
		this.ouverte = ouverte;
	}
}
