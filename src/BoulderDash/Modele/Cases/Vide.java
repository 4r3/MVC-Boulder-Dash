package BoulderDash.Modele.Cases;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Animation.Animation;
import BoulderDash.Modele.Animation.TableAnimation;

public class Vide extends Case {

	public Vide(int x, int y) {
		super(x, y, true);
	}

	/**
	 * retourne le sprite du Vide
	 */
	@Override
	public Animation getAnimation() {
		return TableAnimation.getVide();
	}

	@Override
	public String ID() {
		return "V";
	}

	/**
	 * interaction personnage, échange le personnage et le vide
	 */
	@Override
	public boolean PersonageArrive(Niveau N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(), getY());
		N.remplirUpTable(getX(), getY());
		return true;

	}

	/**
	 * interaction chutable, fait tomber l'objet chutable si il est instable, le
	 * met en état instable sinon
	 */
	@Override
	public EtatChutable chutableArrive(Niveau N) {
		if (((Chutable) N.getCase(getX(), getY() - 1)).instable()) {
			N.echangeCases(getX(), getY(), getX(), getY() - 1);
			N.remplirUpTable(getX(), getY());
			return EtatChutable.Chute;
		} else {
			return EtatChutable.Instable;
		}
	}

	/**
	 * autorise l'arrivée d'un ennemi
	 */
	@Override
	public boolean EnemiArrive(Niveau N) {
		return true;
	}
}
