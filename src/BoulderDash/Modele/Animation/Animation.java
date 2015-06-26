package BoulderDash.Modele.Animation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'animation, permet d'animer un tableau de sprites Peut être lancé ou
 * stoppé
 * 
 * @see Sprite, Frame
 */
public class Animation {

	/**
	 * Compteur pour le changement de frame
	 */
	private int compteur;

	/**
	 * Délai avant changement de frame
	 */
	private int delaiFrame;

	/**
	 * Animation actuelle
	 */
	private int frameCourante;

	/**
	 * Nombre total de frame pour l'animation
	 */
	private int totalFrames;

	/**
	 * Indique si l'animation est stoppée
	 */
	private boolean enPause;

	/**
	 * Liste des frames
	 */
	private List<Frame> frames = new ArrayList<>();

	/**
	 * Crée une animation en stockant les frames dans une liste et en
	 * initialisant le délai
	 * 
	 * @param frames
	 *            tableau des images que l'on veut animer
	 * @param delaiFrame
	 *            délai du changement de frame
	 */
	public Animation(BufferedImage[] frames, int delaiFrame) {
		this.delaiFrame = delaiFrame;
		this.enPause = true;

		for (int i = 0; i < frames.length; i++) {
			addFrame(frames[i], delaiFrame);
		}

		this.compteur = 0;
		this.delaiFrame = delaiFrame;
		this.frameCourante = 0;
		this.totalFrames = this.frames.size();

	}

	/**
	 * Lance l'animation
	 */
	public void start() {
		if (!enPause) {
			return;
		}

		if (frames.size() == 0) {
			return;
		}

		enPause = false;
	}

	/**
	 * Arrête l'animation
	 */
	public void stop() {
		if (frames.size() == 0) {
			return;
		}

		enPause = true;
	}

	/**
	 * Transforme une image en frame grâce à sa durée puis la stocke dans une
	 * liste
	 * 
	 * @param frame
	 *            une des images de l'animation
	 * @param duration
	 *            délai du changement de frame
	 */
	private void addFrame(BufferedImage frame, int duration) {
		if (duration <= 0) {
			System.err.println("Invalid duration: " + duration);
			throw new RuntimeException("Invalid duration: " + duration);
		}

		frames.add(new Frame(frame, duration));
		frameCourante = 0;
	}

	/**
	 * Permet de récupérer l'image actuelle
	 * 
	 * @return l'image de la frame courante
	 */
	public BufferedImage getSprite() {
		return frames.get(frameCourante).getFrame();
	}

	/**
	 * Permet de récupérer l'image statique de l'animation
	 * 
	 * @return une image statique
	 */
	public BufferedImage getSpriteImmobile() {
		return frames.get(0).getFrame();
	}

	/**
	 * Met à jour l'animation grâce au compteur qui modifie la frame actuelle
	 * une fois le délai passé
	 */
	public void update() {
		if (!enPause) {
			compteur++;
			if (compteur > delaiFrame) {
				compteur = 0;
				frameCourante += 1;

				if (frameCourante > totalFrames - 1) {
					frameCourante = 0;
				} else if (frameCourante < 0) {
					frameCourante = totalFrames - 1;
				}
			}
		}

	}

}
