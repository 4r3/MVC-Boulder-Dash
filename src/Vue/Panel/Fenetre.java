package Vue.Panel;

import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Jeu;
import Modele.Niveau;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 3393452907097178193L;

	public final static String MENUPRICIPAL = "Menu Principal";
	public final static String MENUJEU = "Menu Jeu";
	public final static String MENUEDITEUR = "Menu Editeur";
	public final static String TABLEAUJEU = "Jeu Boulder Dash";
	public final static String TABLEAUEDITEUR = "Editeur Boulder Dash";

	private JPanel cards;
	private MenuPrincipal menuPrinc;
	private MenuJeu menuJeu;
	private MenuEditeur menuEdit;
	private PanelJeu panelJeu;
	private PanelEditeur panelEdit;

	public Fenetre(Niveau niveau, Jeu jeu) {
		super("Boulder Dash");
		initAireDejeu(niveau, jeu);

		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initAireDejeu(Niveau niveau, Jeu jeu) {

		menuPrinc = new MenuPrincipal(this);
		menuPrinc.setLayout(new BoxLayout(menuPrinc, BoxLayout.PAGE_AXIS));
		menuJeu = new MenuJeu(this);
		menuJeu.setLayout(new BoxLayout(menuJeu, BoxLayout.PAGE_AXIS));
		menuEdit = new MenuEditeur(this);
		menuEdit.setLayout(new BoxLayout(menuEdit, BoxLayout.PAGE_AXIS));

		panelJeu = new PanelJeu(this, niveau, jeu);
		panelEdit = new PanelEditeur(this, new Niveau());

		cards = new JPanel(new CardLayout());
		cards.add(menuPrinc, MENUPRICIPAL);
		cards.add(menuJeu, MENUJEU);
		cards.add(menuEdit, MENUEDITEUR);
		cards.add(panelJeu, TABLEAUJEU);
		cards.add(panelEdit, TABLEAUEDITEUR);

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

}
