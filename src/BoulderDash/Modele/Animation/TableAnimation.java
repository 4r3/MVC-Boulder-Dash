package BoulderDash.Modele.Animation;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import BoulderDash.Modele.Variables;

/**
 * Classe d'animation, permet d'animer un tableau de sprites Peut être lancé ou
 * stoppé
 * 
 * @see Animation, Sprite
 * @author Yiserot
 */
public class TableAnimation {

	/**
	 * Liste de toutes les animations du jeu
	 */
	private static Map<ChoixAnimation, Animation> tableAnimations = new HashMap<>();

	/**
	 * Permet de récupérer l'animation du papillon
	 * 
	 * @return l'animation du papillon
	 */
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

	/**
	 * Permet de récupérer l'animation du personnage marchant vers la droite
	 * 
	 * @return l'animation du personnage marchant vers la droite
	 */
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

	/**
	 * Permet de récupérer l'animation du personnage marchant vers la gauche
	 * 
	 * @return l'animation du personnage marchant vers la gauche
	 */
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

	/**
	 * Permet de récupérer l'animation du personnage marchant vers le haut
	 * 
	 * @return l'animation du personnage marchant vers le haut
	 */
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

	/**
	 * Permet de récupérer l'animation du personnage marchant vers le bas
	 * 
	 * @return l'animation du personnage marchant vers le bas
	 */
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

	/**
	 * Permet de récupérer l'animation du personnage debout vers la droite
	 * 
	 * @return l'animation du personnage debout vers la droite
	 */
	private static Animation getPersonnageDeboutDroite() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Droite) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingRight = { spritePersonnage.getSprite(0, 1) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Droite,
					new Animation(standingRight, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Droite);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers la gauche
	 * 
	 * @return l'animation du personnage debout vers la gauche
	 */
	private static Animation getPersonnageDeboutGauche() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Gauche) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingLeft = { spritePersonnage.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Gauche,
					new Animation(standingLeft, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Gauche);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers le haut
	 * 
	 * @return l'animation du personnage debout vers le haut
	 */
	private static Animation getPersonnageDeboutHaut() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Haut) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingUp = { spritePersonnage.getSprite(0, 2) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Haut,
					new Animation(standingUp, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Haut);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers le bas
	 * 
	 * @return l'animation du personnage debout vers le bas
	 */
	private static Animation getPersonnageDeboutBas() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Debout_Bas) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] standingDown = { spritePersonnage.getSprite(2, 2) };
			tableAnimations.put(ChoixAnimation.Personnage_Debout_Bas,
					new Animation(standingDown, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Debout_Bas);
	}

	/**
	 * Permet de récupérer l'animation du personnage patientant
	 * 
	 * @return l'animation du personnage patientant
	 */
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

	/**
	 * Permet de récupérer l'animation du personnage mort
	 * 
	 * @return l'animation du personnage mort
	 */
	private static Animation getPersonnageMort() {
		if (tableAnimations.get(ChoixAnimation.Personnage_Mort) == null) {
			Sprite spritePersonnage = new Sprite("rockford");
			BufferedImage[] mort = { spritePersonnage.getSprite(2, 4) };
			tableAnimations.put(ChoixAnimation.Personnage_Mort, new Animation(
					mort, Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Personnage_Mort);
	}

	/**
	 * Permet de récupérer l'animation de la boue
	 * 
	 * @return l'animation de la boue
	 */
	public static Animation getBoue() {
		if (tableAnimations.get(ChoixAnimation.Boue) == null) {
			Sprite spriteBoue = new Sprite("dirt");
			BufferedImage[] dirt = { spriteBoue.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Boue, new Animation(dirt,
					Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Boue);
	}

	/**
	 * Permet de récupérer l'animation du diamant
	 * 
	 * @return l'animation du diamant
	 */
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

	/**
	 * Permet de récupérer l'animation du rocher
	 * 
	 * @return l'animation du rocher
	 */
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

	/**
	 * Permet de récupérer l'animation du mur
	 * 
	 * @return l'animation du mur
	 */
	public static Animation getMur() {
		if (tableAnimations.get(ChoixAnimation.Mur) == null) {
			Sprite spriteMur = new Sprite("wall");
			BufferedImage[] wall = { spriteMur.getSprite(0, 0) };
			tableAnimations.put(ChoixAnimation.Mur, new Animation(wall,
					Variables.VITESSE_ANIM));
		}
		return tableAnimations.get(ChoixAnimation.Mur);
	}

	/**
	 * Permet de récupérer l'animation du mur magique
	 * 
	 * @return l'animation du mur magique
	 */
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

	/**
	 * Permet de récupérer l'animation de la sortie
	 * 
	 * @return l'animation de la sortie
	 */
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

	/**
	 * Permet de récupérer l'animation du vide
	 * 
	 * @return l'animation du vide
	 */
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
	 * Permet de récupérer l'animation du personnage
	 * 
	 * @param animation
	 *            choix de l'animation
	 * @return l'animation voulue du personnage
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

	/**
	 * Met à jour toutes les animations du jeu
	 */
	public static void refreshAnim() {
		for (ChoixAnimation anim : ChoixAnimation.values()) {
			if (tableAnimations.get(anim) != null) {
				tableAnimations.get(anim).update();
			}
		}
	}
}
