package BoulderDash.Vue.Editeur;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;

@SuppressWarnings("serial")
public class PanelEditeur extends JPanel implements Observer {
	private AirePlateauEditeur aireEditeur;
	private AireInfoEditeur aireInfo;
	private MenuEditeur menuEditeur;

	public PanelEditeur() {
		initPanelEditeur();
	}

	private void initPanelEditeur() {
		setLayout(new BorderLayout());
		menuEditeur = new MenuEditeur();
		add(menuEditeur, BorderLayout.NORTH);
		aireEditeur = new AirePlateauEditeur();
		add(aireEditeur, BorderLayout.WEST);
		aireInfo = new AireInfoEditeur();
		add(aireInfo, BorderLayout.EAST);
		BoulderDash.getEdit().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (BoulderDash.getEdit().getChangedX() < 0
				|| BoulderDash.getEdit().getChangedY() < 0) {
			aireEditeur.repaint();
			aireInfo.repaint();
		} else {
			aireEditeur.repaint_xy(BoulderDash.getEdit().getChangedX(),
					BoulderDash.getEdit().getChangedY());
		}
	}
}