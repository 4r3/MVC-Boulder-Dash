package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

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
		N.insereVide(N.getPerso().getX(), N.getPerso().getY());
		N.remplirUpTable(this.getX(), this.getY());
		return true;
	}
}
