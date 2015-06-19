package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

public class Vide extends Case {

	public Vide(int x, int y) {
		super(x, y, true);
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getVide();
	}

	@Override
	public String ID() {
		return "V";
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(), getY());
		N.remplirUpTable(getX(), getY());
		return true;

	}

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y) {
		if (((Chutable) N.getCase(x, y)).instable()) {
			N.echangeCases(x, y, x, y + 1);
			N.remplirUpTable(x, y);
			((Chutable) N.getCase(x, y + 1)).setY(y + 1);
			return EtatChutable.Chute;
		} else {
			return EtatChutable.Instable;
		}
	}
}
