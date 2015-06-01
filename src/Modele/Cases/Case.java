package Modele.Cases;

import Modele.Animation.Animation;

public abstract class Case {

	@SuppressWarnings("static-method")
	public String ID() {
		// TODO Auto-generated method stub
		return "C";
	}

	/**
	 * @return
	 */
	public abstract Animation getAnimation();

}
