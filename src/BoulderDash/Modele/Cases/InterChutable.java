/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * @author 4r3
 *
 */
public interface InterChutable
{
	EtatChutable chutableArrive(Niveau N, int x, int y);
}
