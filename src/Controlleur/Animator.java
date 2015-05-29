package Controlleur;

public class Animator implements Runnable {

	private Thread animator;
	private boolean enMarche;

	public Animator() {
		this.enMarche = true;
		animator = new Thread(this);
		animator.start();
	}

	public boolean isEnMarche() {
		return enMarche;
	}

	public void setEnMarche(boolean enMarche) {
		this.enMarche = enMarche;
	}

	@Override
	public void run() {

		while (this.isEnMarche()) {

		}
	}

}
