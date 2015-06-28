/**
 * 
 */
package BoulderDash.Controlleur.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.EtatApplication;
import BoulderDash.Vue.Vues;

/**
 * @author 4r3
 * 
 */
public class GestionMenuChoix implements ActionListener {

	private JButton bouton1;
	private JButton bouton2;
	private JComboBox<String> liste;

	public GestionMenuChoix(JButton b1, JButton b2, JComboBox<String> liste2) {
		this.bouton1 = b1;
		this.bouton2 = b2;
		this.liste = liste2;
	}

	/**
	 * déclenche les actions associées à chaque bouton
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) {
			BoulderDash.getJeu()
					.chargerNiveau((String) liste.getSelectedItem());
			BoulderDash.setState(EtatApplication.Jeu);
			BoulderDash.getFen().changerVue(Vues.TABLEAUJEU);
		} else if (arg0.getSource() == this.bouton2) {
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
		}
	}

}
