/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * interface contenant tous les types d'interaction
 * 
 */
public interface Interactions {
	/**
	 * fonction appelée par le personnage lorsqu'il se déplace vers une case
	 */
	boolean PersonageArrive(Niveau N);

	/**
	 * fonction appelée par un chutable lorsqu'il tombe
	 */
	EtatChutable chutableArrive(Niveau N);

	/**
	 * fonction appelée par un ennemi lorsqu'il se déplace
	 */
	boolean EnemiArrive(Niveau N);
}
