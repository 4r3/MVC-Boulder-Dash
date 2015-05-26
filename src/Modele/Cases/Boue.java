package Modele.Cases;

import java.awt.image.BufferedImage;

import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Sprite;

public class Boue extends Case implements InterPersonnage
{
	private Animation animation;

	public Boue()
	{
		Sprite spriteBoue = new Sprite("dirt");
		BufferedImage[] dirt = { spriteBoue.getSprite(0, 0) };
		animation = new Animation(dirt, Variables.VITESSE_ANIM);
	}

	public Animation getAnimation()
	{
		return animation;
	}

	@Override
	public String ID()
	{
		return "B";
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.insereVide(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);
	}
}
