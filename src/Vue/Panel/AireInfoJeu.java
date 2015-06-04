package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlleur.GestionSourisJeu;
import Modele.Jeu;
import Modele.Variables;

public class AireInfoJeu extends JPanel implements Observer {

	private Jeu jeu;

	public AireInfoJeu(Fenetre fen, Jeu jeu) {
		this.jeu = jeu;
		jeu.addObserver(this);
		initAireInformation(fen);

	}

	private void initAireInformation(Fenetre fen) {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JLabel score = new JLabel("Diamant(s) restant(s) : "
		/* + this.jeu.getDscore() */);
		score.setForeground(Color.white);
		JButton retour = new JButton("Menu");
		GestionSourisJeu gsm = new GestionSourisJeu(fen, retour);

		add(score);
		add(retour);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
