import javax.swing.JFrame;

import Vue.Panel.VueJeu;

public class ThreadBoulderDash extends JFrame {

	public ThreadBoulderDash() {

		initUI();
	}

	private void initUI() {

		add(new VueJeu());

		setResizable(false);
		pack();

		setTitle("Boulder Dash");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
