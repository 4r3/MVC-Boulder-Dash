package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BoulderDash.BoulderDash;
import Vue.Panel.Vues;

public class GestionSourisEditeur implements ActionListener {

	public GestionSourisEditeur(JButton b1) {

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BoulderDash.getFen().changerCardLayout(Vues.MENUEDITEUR);
	}
}
