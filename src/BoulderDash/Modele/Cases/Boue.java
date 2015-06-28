package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

public class Boue extends Case {

	public Boue(int x, int y) {
		super(x, y);
	}

	/**
	 * retourne le sprite de la boue
	 */
	@Override
	public Animation getAnimation() {
		return TableAnimation.getBoue();
	}

	@Override
	public String ID() {
		return "B";
	}

	/**
	 * lorsque le personnage arrive, on échange les cases du personage et de la
	 * boue, on insère du vide sur l'ancienne position du personnage (écrasement
	 * de la boue), on déclenche l'insertion en uptable de cases potentielement
	 * affectées par le changement
	 */
	@Override
	public boolean PersonageArrive(Niveau N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), this.getX(),
				this.getY());
		N.insereVide(getX(), getY());
		N.remplirUpTable(this.getX(), this.getY());
		return true;
	}
}
