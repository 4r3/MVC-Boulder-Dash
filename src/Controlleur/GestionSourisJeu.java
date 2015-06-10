package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BoulderDash.BoulderDash;
import Vue.Panel.Fenetre;
import Vue.Panel.Vues;

public class GestionSourisJeu implements ActionListener {

	private Fenetre fenetre;

	public GestionSourisJeu(Fenetre fen, JButton b1) {

		this.fenetre = fen;

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BoulderDash.getFen().changerCardLayout(Vues.MENUJEU);
	}
}
