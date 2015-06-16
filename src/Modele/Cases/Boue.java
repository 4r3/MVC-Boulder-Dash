package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

public class Boue extends Case {

	public Boue() {

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
	public boolean PersonageArrive(Niveau N, int x, int y) {
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.insereVide(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);
		return true;
	}
}
