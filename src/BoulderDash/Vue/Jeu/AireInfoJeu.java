package BoulderDash.Vue.Jeu;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import BoulderDash.Controlleur.Jeu.GestionMenuJeu;
import BoulderDash.Modele.Variables;

@SuppressWarnings("serial")
public class AireInfoJeu extends JPanel {
	private JLabel Drestant;
	private JLabel Trestant;
	private JLabel score;

	public AireInfoJeu() {
		initAireInformation();
	}

	private void initAireInformation() {
		setLayout(new GridLayout(5, 1));
		// setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		Drestant = new JLabel("Diamant(s) restant(s) : "
				+ BoulderDash.getJeu().getNiveau().getDscore());
		Trestant = new JLabel("Temps restant : "
				+ BoulderDash.getJeu().getNiveau().getTmax());
		score = new JLabel("Scrore : " + BoulderDash.getJeu().getScore());

		JButton retour = new JButton("Menu");
		new GestionMenuJeu(retour);

		add(Drestant);
		add(Trestant);
		add(score);
		add(retour);
	}

	public void majinfos() {
		Drestant.setText("Diamant(s) restant(s) : "
				+ BoulderDash.getJeu().getNiveau().getDscore());
		Trestant.setText("Temps restant : "
				+ BoulderDash.getJeu().getNiveau().getTmax());
		score.setText("Scrore : " + BoulderDash.getJeu().getScore());
	}
}
