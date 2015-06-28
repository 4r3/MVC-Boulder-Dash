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
	 * lorsque le personnage arrive, on echange les case du personage et de la
	 * boue on insere du vide sur l'anciene position du personnage (ecrasement
	 * de la boue) declenche l'insertion en uptable de case potentielement
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
