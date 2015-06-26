package BoulderDash.Modele.Animation;

import java.awt.image.BufferedImage;

/**
 * Classe d'animation, permet d'animer un tableau de sprites Peut être lancé ou
 * stoppé
 */
public class Frame {

	/**
	 * Image de la frame
	 */
	private BufferedImage frame;

	/**
	 * Durée de la frame
	 */
	private int duree;

	/**
	 * Création de la frame
	 * 
	 * @param frame
	 *            image de la frame
	 * @param duree
	 *            temps durant lequel la frame reste affichée
	 */
	public Frame(BufferedImage frame, int duree) {
		this.frame = frame;
		this.duree = duree;
	}

	/**
	 * Permet de récupérer l'image de la frame
	 * 
	 * @return l'image de la frame
	 */
	public BufferedImage getFrame() {
		return frame;
	}

	/**
	 * Permet de modifier l'image de la frame
	 * 
	 * @param frame
	 *            la nouvelle image de la frame
	 */
	public void setFrame(BufferedImage frame) {
		this.frame = frame;
	}

	/**
	 * Permet de récupérer la durée de la frame
	 * 
	 * @return la durée de la frame
	 */
	public int getduree() {
		return duree;
	}

	/**
	 * Permet de modifier la durée de la frame
	 * 
	 * @param la
	 *            nouvelle durée de la frame
	 */
	public void setduree(int duree) {
		this.duree = duree;
	}

}
