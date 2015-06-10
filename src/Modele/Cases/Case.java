package Modele.Cases;

import Modele.Niveau;
import Modele.Animation.Animation;

public abstract class Case implements InterChutable, InterPersonnage,
		RefreshAnim {

	private boolean vide;
	private boolean personnage;

	public Case() {
		this(false, false);
	}

	public Case(boolean vide, boolean personage) {
		this.vide = vide;
		this.personnage = personage;
	}

	@SuppressWarnings("static-method")
	public String ID() {
		return "C";
	}

	public abstract Animation getAnimation();

	public boolean isVide() {
		return vide;
	}

	public boolean isPersonnage() {
		return personnage;
	}

	// methodes communes

	@Override
	public EtatChutable chutableArrive(Niveau N, int x, int y) {
		return EtatChutable.Stable;
	}

	@Override
	public boolean PersonageArrive(Niveau N, int x, int y) {
		return false;
	}

	@Override
	public void refreshAnim() {
	}

}
