package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlleur.GestionSourisJeu;
import Modele.Variables;

@SuppressWarnings("serial")
public class AireInfoJeu extends JPanel {

	public AireInfoJeu() {
		initAireInformation();
	}

	private void initAireInformation() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JLabel score = new JLabel("Diamant(s) restant(s) : "
		/* + this.jeu.getDscore() */);
		score.setForeground(Color.white);
		JButton retour = new JButton("Menu");
		new GestionSourisJeu(retour);

		add(score);
		add(retour);
	}

}
