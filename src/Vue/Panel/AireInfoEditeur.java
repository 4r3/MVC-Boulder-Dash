package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.GestionSourisEditeur;
import Modele.Variables;

public class AireInfoEditeur extends JPanel implements Observer {

	public AireInfoEditeur(Fenetre fen) {
		initAireInformation(fen);
	}

	private void initAireInformation(Fenetre fen) {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JButton retour = new JButton("Menu");
		new GestionSourisEditeur(fen, retour);

		// add(score);
		add(retour);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}