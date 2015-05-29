package Vue.Panel;

import javax.swing.JFrame;

public class Fenetre extends JFrame
{
	private static final long serialVersionUID = 3393452907097178193L;

	public Fenetre()
	{
		add(new VueJeu());

		setResizable(false);
		pack();

		setTitle("Boulder Dash");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
