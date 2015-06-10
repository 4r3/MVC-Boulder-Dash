package Vue.Panel;

import javax.swing.JPanel;

import Modele.Editeur;

@SuppressWarnings("serial")
public class PanelEditeur extends JPanel {
	private AirePlateauEditeur aireEditeur;
	private AireInfoEditeur aireInfo;

	public PanelEditeur(Editeur editeur) {
		initPanelEditeur(editeur);
	}

	private void initPanelEditeur(Editeur editeur) {
		aireEditeur = new AirePlateauEditeur(editeur);
		add(aireEditeur);
		aireInfo = new AireInfoEditeur();
		add(aireInfo);
	}
}
