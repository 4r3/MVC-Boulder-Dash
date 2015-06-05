package Controlleur;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Panel.Fenetre;

public class GestionSourisJeu implements ActionListener {

	private Fenetre fenetre;

	public GestionSourisJeu(Fenetre fen, JButton b1) {

		this.fenetre = fen;

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CardLayout cl = (CardLayout) (this.fenetre.getCards().getLayout());
		cl.show(this.fenetre.getCards(), Fenetre.MENUJEU);
		this.fenetre.getMenuPrinc().grabFocus();
	}
}