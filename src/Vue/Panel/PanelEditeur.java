package Vue.Panel;

import javax.swing.JPanel;

import Modele.Editeur;

@SuppressWarnings("serial")
public class PanelEditeur extends JPanel {
	private AirePlateauEditeur aireEditeur;
	private AireInfoEditeur aireInfo;

	public PanelEditeur(Fenetre fen, Editeur editeur) {
		initPanelEditeur(fen, editeur);
		// setFocusable(true);
	}

	private void initPanelEditeur(Fenetre fen, Editeur editeur) {
		aireEditeur = new AirePlateauEditeur(editeur);
		add(aireEditeur);
		aireInfo = new AireInfoEditeur(fen);
		add(aireInfo);
	}
}
