package BoulderDash.Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.Jeu;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 3393452907097178193L;

	private JPanel display;

	public Fenetre(Jeu jeu) {
		super("Boulder Dash");
		display = new MenuPrincipal(this);
		add(display);
		display.grabFocus();
		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void changerVue(Vues vue) {
		remove(display);
		switch (vue) {
		case MENUPRINCIPAL:
			display = new MenuPrincipal(this);
			break;
		case MENUCHOIXNIVEAU:
			display = new MenuChoixNiveau();
			break;
		case MENUJEU:
			display = new MenuJeu();
			break;
		case TABLEAUEDITEUR:
			display = new PanelEditeur();
			break;
		case TABLEAUJEU:
			display = new PanelJeu(BoulderDash.getJeu());
			break;
		default:
			display = new MenuPrincipal(this);
			break;
		}
		add(display);
		display.grabFocus();
		pack();
	}

}
