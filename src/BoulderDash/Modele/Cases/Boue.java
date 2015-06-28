package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

public class Boue extends Case {

	public Boue(int x, int y) {
		super(x, y);
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.getBoue();
	}

	@Override
	public String ID() {
		return "B";
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), this.getX(),
				this.getY());
		N.insereVide(getX(), getY());
		N.remplirUpTable(this.getX(), this.getY());
		return true;
	}
}