/**
 * 
 */
package BoulderDash.Vue.Editeur;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import BoulderDash.Controlleur.Editeur.GestionMenuEditeur;

/**
 * Vue du menu de l'éditeur
 * 
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class MenuEditeur extends JMenuBar {

	/**
	 * Initialisation du menu
	 */
	public MenuEditeur() {
		super();
		JMenuItem nouveau = new JMenuItem("Nouveau niveau");
		JMenuItem charger = new JMenuItem("Charger un niveau");
		JMenuItem sauvgarder = new JMenuItem("Sauvegarder");
		JMenuItem configurer = new JMenuItem("Configurer le niveau");
		JMenuItem quitter = new JMenuItem("Retourner au menu");

		GestionMenuEditeur ctrl = new GestionMenuEditeur(nouveau, charger,
				sauvgarder, configurer, quitter);

		nouveau.addActionListener(ctrl);
		charger.addActionListener(ctrl);
		sauvgarder.addActionListener(ctrl);
		configurer.addActionListener(ctrl);
		quitter.addActionListener(ctrl);

		add(nouveau);
		add(charger);
		add(sauvgarder);
		add(configurer);
		add(quitter);
	}
}
