package BoulderDash.Vue.Jeu;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import BoulderDash.Controlleur.Jeu.GestionClavierJeu;
import BoulderDash.Controlleur.Jeu.GestionFinJeu;
import BoulderDash.Modele.Variables;

@SuppressWarnings("serial")
public class PanelJeu extends JPanel implements Observer {
	private AirePlateauJeu aireJeu;
	private AireInfoJeu aireInfo;
	private GestionClavierJeu listen;

	public PanelJeu() {
		setBackground(Variables.COULEUR);
		aireJeu = new AirePlateauJeu(BoulderDash.getJeu().getNiveau());
		add(aireJeu);
		aireInfo = new AireInfoJeu();
		add(aireInfo);

		listen = new GestionClavierJeu(BoulderDash.getJeu().getNiveau());
		addKeyListener(listen);
		BoulderDash.getJeu().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		aireJeu.repaint();
		aireInfo.majinfos();
		if (BoulderDash.getJeu().isFini()) {
			GestionFinJeu.finJeu();
		}
	}
}
