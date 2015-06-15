package Vue.Panel;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import Modele.Editeur;

@SuppressWarnings("serial")
public class PanelEditeur extends JPanel implements Observer {
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

		BoulderDash.getEdit().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
