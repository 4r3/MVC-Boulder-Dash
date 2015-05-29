package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;
import Modele.Animation.TableAnimation;

public class Personnage extends ElementDynamique implements Vivant {
	Directions Deplace;
	private Animation animation;
	boolean vivant;

	public Personnage(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		Deplace = Directions.Null;

		this.animation = TableAnimation.getPersonnageDeboutGauche();
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
			break;
		case Droite:
			xdest++;
			break;
		case Gauche:
			xdest--;
			break;
		case Haut:
			ydest--;
			break;
		case Null:
			return;
		default:
			return;
		}
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
		setDeplace(Directions.Null);
	}

	@Override
	public Animation getAnimation() {
		return animation;
	}

	public void marcheDroite() {
		this.animation = TableAnimation.getPersonnageMarcheDroite();
	}

	public void marcheGauche() {
		this.animation = TableAnimation.getPersonnageMarcheGauche();
	}

	public void marcheHaut() {
		this.animation = TableAnimation.getPersonnageMarcheHaut();
	}

	public void marcheBas() {
		this.animation = TableAnimation.getPersonnageMarcheBas();
	}

	public void deboutDroite() {
		this.animation = TableAnimation.getPersonnageDeboutDroite();
	}

	public void deboutGauche() {
		this.animation = TableAnimation.getPersonnageDeboutGauche();
	}

	public void deboutHaut() {
		this.animation = TableAnimation.getPersonnageDeboutHaut();
	}

	public void deboutBas() {
		this.animation = TableAnimation.getPersonnageDeboutBas();
	}

	public void idle() {
		this.animation = TableAnimation.getPersonnageIdle();
	}

	public void mort() {
		this.animation = TableAnimation.getPersonnageMort();
	}

	@Override
	public String ID() {
		return "P";
	}

	@Override
	public void tuer(Niveau N) {
		N.setFini();
	}
}
