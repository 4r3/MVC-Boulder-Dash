package Modele.Animation;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import Modele.Variables;

public class TableAnimation {

	private static Map<ChoixAnimation, Animation> tableAnimations = new HashMap<>();

	public static Animation getPapillon() {

		if (tableAnimations.get(ChoixAnimation.Papillon) == null) {
			Sprite spritePapillon = new Sprite("mechants");
			BufferedImage[] papillon = { spritePapillon.getSprite(0, 1),
					spritePapillon.getSprite(1, 1),
					spritePapillon.getSprite(2, 1) };
			tableAnimations.put(ChoixAnimation.Papillon, new Animation(
					papillon, Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Papillon).start();
		return tableAnimations.get(ChoixAnimation.Papillon);
	}

	private static Animation getPersonnageMarcheDroite() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Marche_Droite) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] walkingRight = { spritePersonnage.getSprite(1, 1),
					spritePersonnage.getSprite(2, 1) };
			tableAnimations.put(ChoixAnimation.Personnage_Marche_Droite,
					new Animation(walkingRight, Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Personnage_Marche_Droite).start();
		return tableAnimations.get(ChoixAnimation.Personnage_Marche_Droite);
	}

	private static Animation getPersonnageMarcheGauche() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Marche_Gauche) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] walkingLeft = { spritePersonnage.getSprite(1, 0),
					spritePersonnage.getSprite(2, 0) };
			tableAnimations.put(ChoixAnimation.Personnage_Marche_Gauche,
					new Animation(walkingLeft, Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Personnage_Marche_Gauche).start();
		return tableAnimations.get(ChoixAnimation.Personnage_Marche_Gauche);
	}

	private static Animation getPersonnageMarcheHaut() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Marche_Haut) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] walkingUp = { spritePersonnage.getSprite(1, 2),
					spritePersonnage.getSprite(1, 3) };
			tableAnimations.put(ChoixAnimation.Personnage_Marche_Haut,
					new Animation(walkingUp, Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Personnage_Marche_Haut).start();
		return tableAnimations.get(ChoixAnimation.Personnage_Marche_Haut);
	}

	private static Animation getPersonnageMarcheBas() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Marche_Bas) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] walkingDown = { spritePersonnage.getSprite(3, 2),
					spritePersonnage.getSprite(3, 3) };
			tableAnimations.put(ChoixAnimation.Personnage_Marche_Bas,
					new Animation(walkingDown, Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Personnage_Marche_Bas).start();
		return tableAnimations.get(ChoixAnimation.Personnage_Marche_Bas);
	}

	private static Animation getPersonnageDeboutDroite() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Droite) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingRight = { spritePersonnage.getSprite(0, 1) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Droite,
					new Animation(standingRight, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Droite);
	}

	private static Animation getPersonnageDeboutGauche() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Gauche) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingLeft = { spritePersonnage.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Gauche,
					new Animation(standingLeft, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Gauche);
	}

	private static Animation getPersonnageDeboutHaut() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Haut) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingUp = { spritePersonnage.getSprite(0, 2) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Haut,
					new Animation(standingUp, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Haut);
	}

	private static Animation getPersonnageDeboutBas() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Bas) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingDown = { spritePersonnage.getSprite(2, 2) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Bas,
					new Animation(standingDown, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Bas);
	}

	private static Animation getPersonnageIdle() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Idle) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] idling = { spritePersonnage.getSprite(0, 4),
					spritePersonnage.getSprite(1, 4) };
			tableAnimations.put(ChoixAnimation.Personnage_Idle, new Animation(
					idling, Variables.VITESSE_IDLE));
		}
		tableAnimations.get(ChoixAnimation.Personnage_Idle).start();
		return tableAnimations.get(ChoixAnimation.Personnage_Idle);
	}

	private static Animation getPersonnageMort() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Mort) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] mort = { spritePersonnage.getSprite(2, 4) };
			tableAnimations.put(ChoixAnimation.Personnage_Mort, new Animation(
					mort, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Mort);
	}

	public static Animation getBoue() {
		if (tableAnimations.get(ChoixAnimation.Boue) == null) {
			Sprite spriteBoue = new Sprite("dirt");
			BufferedImage[] dirt = { spriteBoue.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Boue, new Animation(dirt,
					Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Boue);
	}

	public static Animation getDiamant() {
		if (tableAnimations.get(ChoixAnimation.Diamant) == null) {
			Sprite spriteDiamant = new Sprite("diamonds");
			BufferedImage[] diamond = { spriteDiamant.getSprite(0, 0),
					spriteDiamant.getSprite(1, 0),
					spriteDiamant.getSprite(2, 0),
					spriteDiamant.getSprite(3, 0) };
			tableAnimations.put(ChoixAnimation.Diamant, new Animation(diamond,
					Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Diamant).start();
		return tableAnimations.get(ChoixAnimation.Diamant);
	}

	public static Animation getRocher() {
		if (tableAnimations.get(ChoixAnimation.Rocher) == null) {
			Sprite spriteRocher = new Sprite("boulder");
			BufferedImage[] rocher = { spriteRocher.getSprite(0, 0),
					spriteRocher.getSprite(1, 0), spriteRocher.getSprite(0, 0),
					spriteRocher.getSprite(2, 0) };
			tableAnimations.put(ChoixAnimation.Rocher, new Animation(rocher,
					Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Rocher).start();
		return tableAnimations.get(ChoixAnimation.Rocher);
	}

	public static Animation getMur() {
		if (tableAnimations.get(ChoixAnimation.Mur) == null) {
			Sprite spriteMur = new Sprite("wall");
			BufferedImage[] wall = { spriteMur.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Mur, new Animation(wall,
					Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Mur);
	}

	public static Animation getMurMagique() {
		if (tableAnimations.get(ChoixAnimation.Mur_Magique) == null) {
			Sprite spriteMurMagique = new Sprite("magicwall");
			BufferedImage[] wall = { spriteMurMagique.getSprite(0, 0),
					spriteMurMagique.getSprite(1, 0),
					spriteMurMagique.getSprite(2, 0),
					spriteMurMagique.getSprite(3, 0) };
			tableAnimations.put(ChoixAnimation.Mur_Magique, new Animation(wall,
					Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Mur_Magique).start();
		return tableAnimations.get(ChoixAnimation.Mur_Magique);
	}

	public static Animation getSortie() {
		if (tableAnimations.get(ChoixAnimation.Sortie) == null) {
			Sprite spriteSortieO = new Sprite("beacon");
			BufferedImage[] sortieO = { spriteSortieO.getSprite(0, 0),
					spriteSortieO.getSprite(1, 0),
					spriteSortieO.getSprite(2, 0),
					spriteSortieO.getSprite(3, 0) };
			tableAnimations.put(ChoixAnimation.Sortie, new Animation(sortieO,
					Variables.VITESSE_ANIM));
		}
		tableAnimations.get(ChoixAnimation.Sortie).start();
		return tableAnimations.get(ChoixAnimation.Sortie);
	}

	public static Animation getVide() {
		if (tableAnimations.get(ChoixAnimation.Vide) == null) {
			Sprite spriteVide = new Sprite("dirt_back");
			BufferedImage[] dirtBack = { spriteVide.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Vide, new Animation(dirtBack,
					Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Vide);
	}

	/**
	 * @param animation
	 * @return
	 */
	public static Animation Personnage(ChoixAnimation animation) {
		switch (animation) {
		case Personnage_Marche_Haut:
			return getPersonnageMarcheHaut();
		case Personnage_Marche_Bas:
			return getPersonnageMarcheBas();
		case Personnage_Marche_Gauche:
			return getPersonnageMarcheGauche();
		case Personnage_Marche_Droite:
			return getPersonnageMarcheDroite();
		case Personnage_Mort:
			return getPersonnageMort();
		case Personnage_Debout_Bas:
			return getPersonnageDeboutBas();
		case Personnage_Debout_Droite:
			return getPersonnageDeboutDroite();
		case Personnage_Debout_Gauche:
			return getPersonnageDeboutGauche();
		case Personnage_Debout_Haut:
			return getPersonnageDeboutHaut();
			// $CASES-OMITTED$
		default:
			return getPersonnageIdle();
		}
	}

	public static void refreshAnim() {
		for (ChoixAnimation anim : ChoixAnimation.values()) {
			if (tableAnimations.get(anim) != null) {
				tableAnimations.get(anim).update();
			}
		}
	}
}
