package Vue.Panel;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import Controlleur.GestionClavier;
import Modele.Jeu;

@SuppressWarnings("serial")
public class PanelJeu extends JPanel implements Observer {
	private AirePlateauJeu aireJeu;
	private AireInfoJeu aireInfo;
	private GestionClavier listen;

	public PanelJeu(Fenetre fen, Jeu jeu) {
		initPanelJeu(fen, jeu);
		// setFocusable(true);
	}

	private void initPanelJeu(Fenetre fen, Jeu jeu) {
		aireJeu = new AirePlateauJeu(jeu.getNiveau());
		add(aireJeu);
		aireInfo = new AireInfoJeu(fen, jeu);
		add(aireInfo);

		listen = new GestionClavier(jeu.getNiveau());
		addKeyListener(listen);
		jeu.addObserver(this);
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
		removeKeyListener(listen);
		listen = new GestionClavier(BoulderDash.getJeu().getNiveau());
		addKeyListener(listen);
	}

}
