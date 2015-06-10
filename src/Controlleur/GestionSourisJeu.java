package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BoulderDash.BoulderDash;
import Vue.Panel.Vues;

public class GestionSourisJeu implements ActionListener {

	public GestionSourisJeu(JButton b1) {

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BoulderDash.getFen().changerCardLayout(Vues.MENUJEU);
	}
}
