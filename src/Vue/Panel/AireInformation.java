package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Jeu;
import Modele.Variables;

public class AireInformation extends JPanel implements Observer {

	private Jeu jeu;

	public AireInformation(Jeu jeu) {
		this.jeu = jeu;
		jeu.addObserver(this);
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
		add(score);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
