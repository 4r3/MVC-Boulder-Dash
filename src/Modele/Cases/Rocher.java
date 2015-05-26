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
public class Rocher extends Chutable implements InterPersonnage
{
	private Animation animation;

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Rocher(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		Sprite spriteRocher = new Sprite("boulder");
		BufferedImage[] rocher = { spriteRocher.getSprite(0, 0) };
		setAnimation(new Animation(rocher, Variables.VITESSE_ANIM));
	}

	@Override
	public String ID()
	{
		return "R";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		if ( N.getPerso().getDeplace() == Directions.Gauche ) {
			if ( N.getCase(x - 1, y) instanceof Vide ) {
				N.echangeCases(x, y, x - 1, y);
				N.addUptable(x - 1, y);
				N.remplirUpTable(x, y);
			}
		} else if ( N.getPerso().getDeplace() == Directions.Droite ) {
			if ( N.getCase(x + 1, y) instanceof Vide ) {
				N.echangeCases(x, y, x + 1, y);
				N.addUptable(x + 1, y);
				N.remplirUpTable(x, y);
			}
		}

	}

	public Animation getAnimation()
	{
		return animation;
	}

	private void setAnimation(Animation animation)
	{
		this.animation = animation;
	}
}
