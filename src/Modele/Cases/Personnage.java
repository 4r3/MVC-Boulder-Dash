package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.ChoixAnimation;
import Modele.Animation.TableAnimation;

public class Personnage extends ElementDynamique implements Vivant, RefreshAnim {
	Directions Deplace;
	Directions Last;
	private ChoixAnimation animation;
	boolean vivant;
	private int IDLE;

	public Personnage(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		Deplace = Directions.Null;
		Last = Directions.Null;

		IDLE = 0;

		animation = ChoixAnimation.Personnage_Idle;
	}

	public void setDeplace(Directions D) {
		Deplace = D;
	}

	public Directions getDeplace() {
		return Deplace;
	}

	@Override
	public void refresh(Niveau N) {
		int xdest = getPos_x();
		int ydest = getPos_y();
		switch (Deplace) {
		case Bas:
			ydest++;
			TableAnimation.Personnage(animation).stop();
			animation = ChoixAnimation.Personnage_Marche_Bas;
			break;
		case Droite:
			xdest++;
			TableAnimation.Personnage(animation).stop();
			animation = ChoixAnimation.Personnage_Marche_Droite;
			break;
		case Gauche:
			TableAnimation.Personnage(animation).stop();
			animation = ChoixAnimation.Personnage_Marche_Gauche;
			xdest--;
			break;
		case Haut:
			ydest--;
			TableAnimation.Personnage(animation).stop();
			animation = ChoixAnimation.Personnage_Marche_Haut;
			break;
		case Null:
			TableAnimation.Personnage(animation).stop();
			arret();
			Last = Directions.Null;
			return;
		default:
			return;
		}
		Last = Deplace;
		Case C = N.getCase(xdest, ydest);
		if (C instanceof InterPersonnage) {
			((InterPersonnage) C).PersonageArrive(N, xdest, ydest);
		} else if (C instanceof Diamant) {
			N.echangeCases(getPos_x(), getPos_y(), xdest, ydest);
			N.insereVide(getPos_x(), getPos_y());
			N.remplirUpTable(getPos_x(), getPos_y());
			setPos(xdest, ydest);
			N.AddDscore();
			N.remUptable(C);
		} else {
			System.out.println(N.getCase(xdest, ydest).getClass().getName());
		}
	}

	private void arret() {
		switch (Last) {
		case Bas:
			animation = ChoixAnimation.Personnage_Debout_Bas;
			IDLE = 0;
			break;
		case Droite:
			animation = ChoixAnimation.Personnage_Debout_Droite;
			IDLE = 0;
			break;
		case Gauche:
			animation = ChoixAnimation.Personnage_Debout_Gauche;
			IDLE = 0;
			break;
		case Haut:
			animation = ChoixAnimation.Personnage_Debout_Haut;
			IDLE = 0;
			break;
		case Null:
			if (IDLE < Modele.Variables.DELAI_IDLE) {
				IDLE++;
			} else {
				animation = ChoixAnimation.Personnage_Idle;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public String ID() {
		return "P";
	}

	@Override
	public void tuer(Niveau N) {
		animation = ChoixAnimation.Personnage_Mort;
		// N.setFini();
	}

	@Override
	public void refreshAnim() {
		getAnimation().update();
	}

	@Override
	public Animation getAnimation() {
		return TableAnimation.Personnage(animation);
	}
}
