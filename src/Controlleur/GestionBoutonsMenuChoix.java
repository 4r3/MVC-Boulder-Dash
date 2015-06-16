/**
 * 
 */
package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;

import BoulderDash.BoulderDash;
import Vue.Panel.Vues;

/**
 * @author 4r3
 *
 */
public class GestionBoutonsMenuChoix implements ActionListener {

	private JButton bouton1;
	private JButton bouton2;
	private JList<String> liste;

	public GestionBoutonsMenuChoix(JButton b1, JButton b2, JList<String> liste) {
		this.bouton1 = b1;
		this.bouton2 = b2;
		this.liste = liste;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) {
			BoulderDash.getJeu().chargerNiveau(liste.getSelectedValue());
			BoulderDash.getFen().changerCardLayout(Vues.TABLEAUJEU);
		} else if (arg0.getSource() == this.bouton2) {
			BoulderDash.getFen().changerCardLayout(Vues.MENUPRINCIPAL);
		}
	}

}