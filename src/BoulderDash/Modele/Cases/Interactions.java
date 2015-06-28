/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * interface contenant out les types d'interactions
 *
 */
public interface Interactions {
	/**
	 * fonction appelé par le personage lorsqu'il se déplace vers une case
	 */
	boolean PersonageArrive(Niveau N);

	/**
	 * fonction appelée par un chutable lorsqu'il tombe
	 */
	EtatChutable chutableArrive(Niveau N);

	/**
	 * fonction appelé par un enemi lorsqu'il se déplace
	 */
	boolean EnemiArrive(Niveau N);
}
