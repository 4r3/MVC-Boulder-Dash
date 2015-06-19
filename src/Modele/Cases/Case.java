package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

public abstract class Case implements InterChutable, InterPersonnage,
		RefreshAnim {

	private int x;
	private int y;

	private TypeCase type;

	public Case(int x, int y) {
		this(x, y, TypeCase.Autre);
	}

	public Case(int x, int y, TypeCase type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	@SuppressWarnings("static-method")
	public String ID() {
		return "C";
	}

	public abstract Animation getAnimation();

	public boolean isVide() {
		return type == TypeCase.Vide;
	}

	public boolean isPersonnage() {
		return type == TypeCase.Personnage;
	}

	public boolean isSortie() {
		return type == TypeCase.Sortie;
	}

	// methodes communes

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y) {
		return EtatChutable.Stable;
	}

	@Override
	public boolean PersonageArrive(Niveau N) {
		return false;
	}

	@Override
	public void refreshAnim() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
