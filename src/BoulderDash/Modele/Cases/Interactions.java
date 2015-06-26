/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * @author 4r3
 *
 */
public interface Interactions {
	boolean PersonageArrive(Niveau N);

	EtatChutable chutableArrive(Niveau N);

	boolean EnemiArrive(Niveau N);
}
