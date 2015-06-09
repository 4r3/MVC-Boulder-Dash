package Vue.Panel;

import javax.swing.JPanel;

import Controlleur.GestionClavier;
import Modele.Jeu;

@SuppressWarnings("serial")
public class PanelJeu extends JPanel {
	private AirePlateauJeu aireJeu;
	private AireInfoJeu aireInfo;

	public PanelJeu(Fenetre fen, Jeu jeu) {
		initPanelJeu(fen, jeu);
		// setFocusable(true);
	}

	private void initPanelJeu(Fenetre fen, Jeu jeu) {
		aireJeu = new AirePlateauJeu(jeu.getNiveau());
		add(aireJeu);
		aireInfo = new AireInfoJeu(fen, jeu);
		add(aireInfo);

		addKeyListener(new GestionClavier(jeu.getNiveau()));
	}
}
