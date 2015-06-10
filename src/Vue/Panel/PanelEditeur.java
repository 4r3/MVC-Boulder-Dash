package Vue.Panel;

import javax.swing.JPanel;

import Controlleur.GestionClavier;
import Modele.Niveau;

@SuppressWarnings("serial")
public class PanelEditeur extends JPanel {
	private AirePlateauEditeur aireEditeur;
	private AireInfoEditeur aireInfo;

	public PanelEditeur(Fenetre fen, Niveau niveau) {
		initPanelEditeur(fen, niveau);
		// setFocusable(true);
	}

	private void initPanelEditeur(Fenetre fen, Niveau niveau) {
		aireEditeur = new AirePlateauEditeur(niveau);
		add(aireEditeur);
		aireInfo = new AireInfoEditeur(fen);
		add(aireInfo);

		addKeyListener(new GestionClavier(niveau));
	}

}
