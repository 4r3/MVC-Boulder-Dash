/**
 * 
 */
package BoulderDash.Vue.Editeur;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import BoulderDash.Controlleur.Editeur.GestionMenuEditeur;

@SuppressWarnings("serial")
public class MenuEditeur extends JMenuBar {

	public MenuEditeur() {
		super();
		JMenuItem nouveau = new JMenuItem("Nouveau niveau");
		JMenuItem charger = new JMenuItem("Charger un niveau");
		JMenuItem sauvgarder = new JMenuItem("Sauvgarder");
		JMenuItem quitter = new JMenuItem("Retourner au menu");

		GestionMenuEditeur ctrl = new GestionMenuEditeur(nouveau, charger,
				sauvgarder, quitter);

		nouveau.addActionListener(ctrl);
		charger.addActionListener(ctrl);
		sauvgarder.addActionListener(ctrl);
		quitter.addActionListener(ctrl);

		add(nouveau);
		add(charger);
		add(sauvgarder);
		add(quitter);
	}
}
