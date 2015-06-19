package BoulderDash.Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import BoulderDash.Controlleur.GestionClavier;

@SuppressWarnings("serial")
public class PanelJeu extends JPanel implements Observer {
	private AirePlateauJeu aireJeu;
	private AireInfoJeu aireInfo;
	private GestionClavier listen;

	public PanelJeu() {
		aireJeu = new AirePlateauJeu(BoulderDash.getJeu().getNiveau());
		add(aireJeu);
		aireInfo = new AireInfoJeu();
		add(aireInfo);

		listen = new GestionClavier(BoulderDash.getJeu().getNiveau());
		addKeyListener(listen);
		BoulderDash.getJeu().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if ((Integer) arg == 1) {
			repaint();
		} else {
			changeNiveau();
			System.out.println("releveling");
		}
	}

	public void changeNiveau() {
		remove(aireJeu);
		aireJeu = new AirePlateauJeu(BoulderDash.getJeu().getNiveau());
		add(aireJeu);
		remove(aireInfo);
		aireInfo = new AireInfoJeu();
		add(aireInfo);
		removeKeyListener(listen);
		listen = new GestionClavier(BoulderDash.getJeu().getNiveau());
		addKeyListener(listen);
	}

}
