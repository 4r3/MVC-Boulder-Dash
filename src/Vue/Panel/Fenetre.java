package Vue.Panel;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BoulderDash.BoulderDash;
import Modele.Jeu;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 3393452907097178193L;

	private JPanel cards;
	private MenuPrincipal menuPrinc;
	private MenuJeu menuJeu;
	private MenuEditeur menuEdit;
	private PanelJeu panelJeu;
	private PanelEditeur panelEdit;
	private MenuChoixNiveau menuChoix;

	public Fenetre(Jeu jeu) {
		super("Boulder Dash");
		initAireDejeu(jeu);

		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initAireDejeu(Jeu jeu) {

		menuPrinc = new MenuPrincipal(this);
		menuJeu = new MenuJeu();
		menuEdit = new MenuEditeur();
		menuChoix = new MenuChoixNiveau();

		panelJeu = new PanelJeu(jeu);
		panelEdit = new PanelEditeur(BoulderDash.getEdit());

		cards = new JPanel(new CardLayout());
		cards.add(menuPrinc, Vues.MENUPRINCIPAL.toString());
		cards.add(menuJeu, Vues.MENUJEU.toString());
		cards.add(menuEdit, Vues.MENUEDITEUR.toString());
		cards.add(panelJeu, Vues.TABLEAUJEU.toString());
		cards.add(menuChoix, Vues.MENUCHOIXNIVEAU.toString());
		cards.add(panelEdit, Vues.TABLEAUEDITEUR.toString());

		add(cards);
	}

	public JPanel getCards() {
		return this.cards;
	}

	public MenuPrincipal getMenuPrinc() {
		return menuPrinc;
	}

	public MenuJeu getMenuJeu() {
		return menuJeu;
	}

	public MenuEditeur getMenuEdit() {
		return menuEdit;
	}

	public PanelJeu getPanelJeu() {
		return panelJeu;
	}

	public PanelEditeur getPanelEdit() {
		return panelEdit;
	}

	public void changerCardLayout(Vues vue) {

		((CardLayout) cards.getLayout()).show(cards, vue.toString());
		getPanelJeu().grabFocus();
	}

}
