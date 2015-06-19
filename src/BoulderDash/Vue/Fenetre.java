package BoulderDash.Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BoulderDash.Vue.Editeur.PanelEditeur;
import BoulderDash.Vue.Jeu.MenuChoixNiveau;
import BoulderDash.Vue.Jeu.MenuJeu;
import BoulderDash.Vue.Jeu.PanelJeu;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 3393452907097178193L;

	private JPanel display;

	public Fenetre() {
		super("Boulder Dash");
		display = new MenuPrincipal();
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
			display = new MenuPrincipal();
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
			display = new PanelJeu();
			break;
		default:
			display = new MenuPrincipal();
			break;
		}
		add(display);
		display.grabFocus();
		pack();
	}

}
