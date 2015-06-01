package Vue.Panel;

import javax.swing.JFrame;

import Modele.Jeu;
import Modele.Niveau;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 3393452907097178193L;

	private PanelJeu panelJeu;

	public Fenetre(Niveau niveau, Jeu jeu) {
		super("Boulder Dash");
		initAireDejeu(niveau, jeu);

		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initAireDejeu(Niveau niveau, Jeu jeu) {

		panelJeu = new PanelJeu(niveau, jeu);
		add(panelJeu);

	}

}
