/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;

/**
 * @author 4r3
 *
 */
public interface Vivant
{
	public boolean estVivant();

	public void tuer(Niveau N);
}
