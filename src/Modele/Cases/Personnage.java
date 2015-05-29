package Modele.Cases;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.Animation;
import Modele.Animation.Etats;
import Modele.Animation.Sprite;

public class Personnage extends ElementDynamique implements Vivant
{
	Directions Deplace;
	private static Map<Etats, Animation> animations;
	private Animation animation;
	boolean vivant;

	public Personnage(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
		Deplace = Directions.Null;

		animations = new HashMap<>();

		Sprite spritePersonnage = new Sprite("rockford");
		BufferedImage[] walkingLeft = { spritePersonnage.getSprite(1, 0), spritePersonnage.getSprite(2, 0) };
		animations.put(Etats.MarcheGauche, new Animation(walkingLeft, Variables.VITESSE_ANIM));
		BufferedImage[] walkingRight = { spritePersonnage.getSprite(1, 1), spritePersonnage.getSprite(2, 1) };
		animations.put(Etats.MarcheDroite, new Animation(walkingRight, Variables.VITESSE_ANIM));
		BufferedImage[] walkingUp = { spritePersonnage.getSprite(1, 2), spritePersonnage.getSprite(1, 3) };
		animations.put(Etats.MarcheHaut, new Animation(walkingUp, Variables.VITESSE_ANIM));
		BufferedImage[] walkingDown = { spritePersonnage.getSprite(3, 2), spritePersonnage.getSprite(3, 3) };
		animations.put(Etats.MarcheBas, new Animation(walkingDown, Variables.VITESSE_ANIM));
		BufferedImage[] standingRight = { spritePersonnage.getSprite(0, 1) };
		animations.put(Etats.StopDroite, new Animation(standingRight, Variables.VITESSE_ANIM));
		BufferedImage[] standingLeft = { spritePersonnage.getSprite(0, 0) };
		animations.put(Etats.StopGauche, new Animation(standingLeft, Variables.VITESSE_ANIM));
		BufferedImage[] standingUp = { spritePersonnage.getSprite(0, 2) };
		animations.put(Etats.StopHaut, new Animation(standingUp, Variables.VITESSE_ANIM));
		BufferedImage[] standingDown = { spritePersonnage.getSprite(2, 2) };
		animations.put(Etats.StopBas, new Animation(standingDown, Variables.VITESSE_ANIM));
		BufferedImage[] idling = { spritePersonnage.getSprite(0, 4), spritePersonnage.getSprite(1, 4) };
		animations.put(Etats.StopIdle, new Animation(idling, Variables.VITESSE_ANIM));
		BufferedImage[] mort = { spritePersonnage.getSprite(2, 4) };
		animations.put(Etats.Mort, new Animation(mort, Variables.VITESSE_ANIM));

		this.animation = animations.get(Etats.StopDroite);
	}

	public void setDeplace(Directions D)
	{
		Deplace = D;
	}

	public Directions getDeplace()
	{
		return Deplace;
	}

	@Override
	public void refresh(Niveau N)
	{
		int xdest = getPos_x();
		int ydest = getPos_y();
		switch ( Deplace ) {
			case Bas :
				ydest++;
				break;
			case Droite :
				xdest++;
				break;
			case Gauche :
				xdest--;
				break;
			case Haut :
				ydest--;
				break;
			case Null :
				return;
			default :
				return;
		}
		Case C = N.getCase(xdest, ydest);
		if ( C instanceof InterPersonnage ) {
			((InterPersonnage) C).PersonageArrive(N, xdest, ydest);
		} else {
			System.out.println(N.getCase(xdest, ydest).getClass().getName());
		}
	}

	public static Map<Etats, Animation> getAnimations()
	{
		return animations;
	}

	@Override
	public Animation getAnimation()
	{
		return animation;
	}

	public void setAnimation(Animation animation)
	{
		this.animation = animation;
	}

	@Override
	public String ID()
	{
		return "P";
	}

	@Override
	public void tuer(Niveau N)
	{
		N.setFini();
	}
}
