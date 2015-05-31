/**
 * 
 */
package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

/**
 * @author 4r3
 * 
 */
public class MurMagique extends Case implements InterChutable
{
	private boolean active;
	private int x;
	private int y;

	public MurMagique(int x, int y)
	{
		this.x = x;
		this.y = y;
		active = false;
	}

	public void activer(Niveau N)
	{
		active = true;
		if ( N.getCase(x - 1, y) instanceof MurMagique && !((MurMagique) N.getCase(x - 1, y)).isActive() ) {
			((MurMagique) N.getCase(x - 1, y)).activer(N);
		}

		if ( N.getCase(x + 1, y) instanceof MurMagique && !((MurMagique) N.getCase(x + 1, y)).isActive() ) {
			((MurMagique) N.getCase(x + 1, y)).activer(N);
		}
	}

	public boolean isActive()
	{
		return active;
	}

	@Override
	public String ID()
	{
		if ( active ) {
			return "T";
		} else {
			return "X";
		}
	}

	@Override
	public Animation getAnimation(Niveau N)
	{
		if ( active ) {
			return N.getTableAnim().getMurMagique();
		} else {
			return N.getTableAnim().getMur();
		}
	}

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y)
	{
		if ( ((Chutable) N.getCase(x, y)).chute() ) {
			if ( !active ) {
				activer(N);
			}
			N.remUptable(N.getCase(x, y));
			if ( N.getCase(x, y + 2) instanceof Vide ) {
				if ( N.getCase(x, y) instanceof Diamant ) {
					N.insereRocher(x, y + 2);
				} else {

					N.insereDiamant(x, y + 2);
				}
				((Chutable) N.getCase(x, y + 2)).setChute();
			}
			N.insereVide(x, y);

			return EtatChutable.Chute;
		} else {
			return modeMur(N, x, y);
		}
	}

	private static EtatChutable modeMur(Niveau N, int x, int y)
	{
		if ( (N.getCase(x + 1, y) instanceof Vide) && (N.getCase(x + 1, y + 1) instanceof Vide) ) {
			if ( ((Chutable) N.getCase(x, y)).instable() ) {
				N.echangeCases(x, y, x + 1, y + 1);
				N.remplirUpTable(x, y);
				((Chutable) N.getCase(x + 1, y + 1)).setPos(x + 1, y + 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else if ( (N.getCase(x - 1, y) instanceof Vide) && (N.getCase(x - 1, y + 1) instanceof Vide) ) {
			if ( ((Chutable) N.getCase(x, y)).instable() ) {
				N.echangeCases(x, y, x - 1, y + 1);
				N.remplirUpTable(x, y);
				((Chutable) N.getCase(x - 1, y + 1)).setPos(x - 1, y + 1);
				return EtatChutable.Chute;
			} else {
				return EtatChutable.Instable;
			}
		} else {
			return EtatChutable.Stable;
		}
	}
}
