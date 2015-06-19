package BoulderDash.Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BoulderDash.BoulderDash;
import BoulderDash.Vue.Vues;

public class GestionBoutonsMenu implements ActionListener {

	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;

	public GestionBoutonsMenu(JButton b1, JButton b2, JButton b3) {
		this.bouton1 = b1;
		this.bouton2 = b2;
		this.bouton3 = b3;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) {
			BoulderDash.getFen().changerVue(Vues.MENUCHOIXNIVEAU);
		} else if (arg0.getSource() == this.bouton2) {
			BoulderDash.getEdit().createNiveau();
			BoulderDash.getFen().changerVue(Vues.TABLEAUEDITEUR);
		} else if (arg0.getSource() == this.bouton3) {
			System.exit(0);
		}
	}
}