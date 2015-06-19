/**
 * 
 */
package Vue.Panel;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuEditeur extends JMenuBar {

	public MenuEditeur() {
		super();
		JMenuItem nouveau = new JMenuItem("Nouveau niveau");
		JMenuItem charger = new JMenuItem("Charger un niveau");
		JMenuItem sauvgarder = new JMenuItem("Sauvgarder");
		JMenuItem quitter = new JMenuItem("Retourner au menu");
		add(nouveau);
		add(charger);
		add(sauvgarder);
		add(quitter);
	}
}
