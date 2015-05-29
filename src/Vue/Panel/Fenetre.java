package Vue.Panel;

import javax.swing.JFrame;

import Controlleur.GestionClavier;
import Modele.Niveau;

public class Fenetre extends JFrame
{
	private static final long serialVersionUID = 3393452907097178193L;

	private AireDeJeu aireJeu;

	public Fenetre(Niveau niveau)
	{
		super("Boulder Dash");
		initAireDejeu(niveau);

		setFocusable(true);
		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initAireDejeu(Niveau niveau)
	{
		aireJeu = new AireDeJeu(niveau);
		add(aireJeu);

		addKeyListener(new GestionClavier(niveau));
	}

}
