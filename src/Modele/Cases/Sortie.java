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
public class Sortie extends Case implements InterPersonnage
{
	private boolean ouverte;
	private Animation animation;

	public Sortie()
	{
		Fermer();
	}

	public Animation getAnimation()
	{
		return animation;
	}

	@Override
	public String ID()
	{
		return "S";
	}

	public boolean isOuverte()
	{
		return ouverte;
	}

	public void Ouvrir()
	{
		this.ouverte = true;
		Sprite spriteSortieO = new Sprite("beacon");

		BufferedImage[] sortieO = { spriteSortieO.getSprite(0, 0), spriteSortieO.getSprite(1, 0), spriteSortieO.getSprite(2, 0), spriteSortieO.getSprite(3, 0) };

		this.animation = new Animation(sortieO, Variables.VITESSE_ANIM);
		this.animation.start();
	}

	public void Fermer()
	{
		this.ouverte = false;
		Sprite spriteSortieF = new Sprite("wall");

		BufferedImage[] sortieF = { spriteSortieF.getSprite(0, 0) };

		this.animation = new Animation(sortieF, Variables.VITESSE_ANIM);
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		if ( ouverte ) {
			N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
			N.getPerso().setPos(x, y);
			N.setFini();
		} else {
			System.out.println("sortie fermée");
		}
	}
}
