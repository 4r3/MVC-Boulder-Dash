package BoulderDash.Vue.Jeu;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import BoulderDash.Controlleur.Jeu.GestionMenuJeu;
import BoulderDash.Modele.Variables;

/**
 * Vue de la zone d'information du jeu qui indique le temps restant, le nombre
 * de diamants restants et le score
 * 
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class AireInfoJeu extends JPanel {
	/**
	 * Diamants restants
	 */
	private JLabel Drestant;

	/**
	 * Temps restant
	 */
	private JLabel Trestant;

	/**
	 * Score
	 */
	private JLabel score;

	/**
	 * Initialisation du panel
	 */
	public AireInfoJeu() {
		initAireInformation();
	}

	/**
	 * Initialisation du panel
	 */
	private void initAireInformation() {
		setBackground(Variables.COULEUR);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		Drestant = new JLabel("Diamant(s) restant(s) : "
				+ BoulderDash.getJeu().getNiveau().getDscore());
		Drestant.setForeground(Variables.COULEUR_TEXTE);
		Trestant = new JLabel("Temps restant : "
				+ BoulderDash.getJeu().getNiveau().getTmax());
		Trestant.setForeground(Variables.COULEUR_TEXTE);
		score = new JLabel("Score : " + BoulderDash.getJeu().getScore());
		score.setForeground(Variables.COULEUR_TEXTE);

		JButton retour = new JButton("Menu");
		JButton aide = new JButton("Aide");

		Drestant.setAlignmentX(CENTER_ALIGNMENT);
		Trestant.setAlignmentX(CENTER_ALIGNMENT);
		score.setAlignmentX(Component.CENTER_ALIGNMENT);
		retour.setAlignmentX(Component.CENTER_ALIGNMENT);
		aide.setAlignmentX(Component.CENTER_ALIGNMENT);

		GestionMenuJeu ctrl = new GestionMenuJeu(retour, aide);

		retour.addActionListener(ctrl);
		aide.addActionListener(ctrl);

		add(Drestant);
		add(Box.createVerticalStrut(15));
		add(Trestant);
		add(Box.createVerticalStrut(15));
		add(score);
		add(Box.createVerticalStrut(15));
		add(retour);
		add(Box.createVerticalStrut(15));
		add(aide);
	}

	/**
	 * Mise à jour des informations affichées
	 */
	public void majinfos() {
		Drestant.setText("Diamant(s) restant(s) : "
				+ BoulderDash.getJeu().getNiveau().getDscore());
		Trestant.setText("Temps restant : "
				+ BoulderDash.getJeu().getNiveau().getTmax());
		score.setText("Score : " + BoulderDash.getJeu().getScore());
	}
}
