package Vue.Panel;

import javax.swing.JPanel;

import Controlleur.GestionClavier;
import Modele.Jeu;
import Modele.Niveau;

@SuppressWarnings("serial")
public class PanelJeu extends JPanel {
	private AirePlateauJeu aireJeu;
	private AireInfoJeu aireInfo;

	public PanelJeu(Fenetre fen, Niveau niveau, Jeu jeu) {
		initPanelJeu(fen, niveau, jeu);
		// setFocusable(true);
	}

	private void initPanelJeu(Fenetre fen, Niveau niveau, Jeu jeu) {
		aireJeu = new AirePlateauJeu(niveau);
		add(aireJeu);
		aireInfo = new AireInfoJeu(fen, jeu);
		add(aireInfo);

		addKeyListener(new GestionClavier(niveau));
	}
}
