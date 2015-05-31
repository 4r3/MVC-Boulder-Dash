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
public class Sortie extends Case implements InterPersonnage, InterChutable
{
	private boolean ouverte;

	//private Animation animation;

	public Sortie()
	{
		Fermer();
	}

	@Override
	public Animation getAnimation(Niveau N)
	{
		if ( ouverte ) {
			return N.getTableAnim().getSortie();
		} else {
			return N.getTableAnim().getMur();
		}

	}

	@Override
	public String ID()
	{
		return "S";
	}

	public boolean isOuverte()
	{
		return ouverte;
	}

	public void Ouvrir()
	{
		this.ouverte = true;
		//this.animation = TableAnimation.getSortie();
		//this.animation.start();
	}

	public void Fermer()
	{
		this.ouverte = false;
		//this.animation = TableAnimation.getMur();
	}

	@Override
	public void PersonageArrive(Niveau N, int x, int y)
	{
		if ( ouverte ) {
			N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
			N.getPerso().setPos(x, y);
			N.setFini();
		} else {
			System.out.println("sortie fermée");
		}
	}

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y)
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
