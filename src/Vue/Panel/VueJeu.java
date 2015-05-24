package Vue.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Modele.Niveau;
import Modele.Variables;

public class VueJeu extends JPanel implements Runnable, KeyListener {
	private Thread animator;

	private Niveau niveau;
	private AireDeJeu aireJeu;

	public VueJeu() {

		initBoard();
		System.out.println("Thread");

		addKeyListener(this);
		setFocusable(true);
	}

	private void initBoard() {

		aireJeu = new AireDeJeu();
		add(aireJeu);

		// animation.start();

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
				KeyEvent.VK_RIGHT);
		this.getActionMap().put(KeyEvent.VK_RIGHT, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aireJeu.toucheDroite();
			}
		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
				KeyEvent.VK_LEFT);
		this.getActionMap().put(KeyEvent.VK_LEFT, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aireJeu.toucheGauche();
			}
		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
				KeyEvent.VK_UP);
		this.getActionMap().put(KeyEvent.VK_UP, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aireJeu.toucheHaut();
			}
		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
				KeyEvent.VK_DOWN);
		this.getActionMap().put(KeyEvent.VK_DOWN, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aireJeu.toucheBas();
			}
		});
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	public void keyPressed(KeyEvent evt) {

	}

	public void keyReleased(KeyEvent evt) {
		aireJeu.toucheRelache(evt);
	}

	public void keyTyped(KeyEvent evt) {

	}

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {
			this.aireJeu.refreshJeu();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = Variables.DELAI - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}
	}
}
