package Vue.Panel;

import javax.swing.JPanel;

import Controlleur.GestionClavier;
import Modele.Jeu;
import Modele.Niveau;

public class PanelJeu extends JPanel {
	private AireDeJeu aireJeu;
	private AireInformation aireInfo;

	public PanelJeu(Niveau niveau, Jeu jeu) {
		initPanelJeu(niveau, jeu);
		setFocusable(true);
	}

	private void initPanelJeu(Niveau niveau, Jeu jeu) {
		aireJeu = new AireDeJeu(niveau);
		add(aireJeu);
		aireInfo = new AireInformation(jeu);
		add(aireInfo);

		addKeyListener(new GestionClavier(niveau));
	}
}
