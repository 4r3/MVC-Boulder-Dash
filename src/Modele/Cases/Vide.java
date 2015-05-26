package Modele.Cases;

import Modele.Niveau;
import java.awt.image.BufferedImage;

import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

public class Vide extends Case implements InterPersonnage
{
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
	public String ID()
	{
		return "V";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);

	}
}
