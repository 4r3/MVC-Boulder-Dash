/**
 * 
 */
package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;

/**
 * @author 4r3
 *
 */
public interface Refresh {
	public void refresh(Niveau N);

	public void refreshAnim();

	public boolean stayInUpTable();
}
