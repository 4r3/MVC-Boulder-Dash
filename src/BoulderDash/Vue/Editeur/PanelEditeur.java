package BoulderDash.Vue.Editeur;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import BoulderDash.BoulderDash;

/**
 * Panel de l'éditeur, englobe les vues de l'éditeur
 * 
 * @see AireInfoEditeur, AirePlateauEditeur, MenuEditeur
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class PanelEditeur extends JPanel implements Observer {
	/**
	 * Terrain de l'éditeur
	 */
	private AirePlateauEditeur aireEditeur;

	/**
	 * Zone de sélection des éléments
	 */
	private AireInfoEditeur aireInfo;

	/**
	 * Menu de l'éditeur
	 */
	private MenuEditeur menuEditeur;

	/**
	 * Initialisation du panel
	 */
	public PanelEditeur() {
		initPanelEditeur();
	}

	/**
	 * Initialisation du panel
	 */
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

	/**
	 * Mise à jour de la vue
	 */
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
