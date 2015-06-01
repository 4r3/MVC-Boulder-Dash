package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

public class Vide extends Case implements InterPersonnage, InterChutable {

	public Vide() {

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
	public void PersonageArrive(Niveau N, int x, int y) {
		N.echangeCases(N.getPerso().getPos_x(), N.getPerso().getPos_y(), x, y);
		N.remplirUpTable(N.getPerso().getPos_x(), N.getPerso().getPos_y());
		N.getPerso().setPos(x, y);

	}

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y) {
		if (((Chutable) N.getCase(x, y)).instable()) {
			N.echangeCases(x, y, x, y + 1);
			N.remplirUpTable(x, y);
			((Chutable) N.getCase(x, y + 1)).setPos_y(y + 1);
			return EtatChutable.Chute;
		} else {
			return EtatChutable.Instable;
		}
	}
}
