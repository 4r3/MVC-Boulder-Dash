/**
 * 
 */
package Modele.Cases;

import java.awt.image.BufferedImage;

import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

/**
 * @author 4r3
 *
 */
public class Diamant extends Chutable implements InterPersonnage
{
	private Animation animation;

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Diamant(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		Sprite spriteDiamant = new Sprite("diamonds");

		BufferedImage[] diamond = { spriteDiamant.getSprite(0, 0), spriteDiamant.getSprite(1, 0), spriteDiamant.getSprite(2, 0), spriteDiamant.getSprite(3, 0) };

		this.animation = new Animation(diamond, Variables.VITESSE_ANIM);
		this.animation.start();
	}

	@Override
	public String ID()
	{
		return "D";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.insereVide(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);
		N.AddDscore();
		N.remUptable(this);

	}

	public Animation getAnimation()
	{
		return animation;
	}

}
