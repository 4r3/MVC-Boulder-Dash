package Controlleur;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Panel.Fenetre;

public class GestionSourisMenu implements ActionListener {

	private Fenetre fenetre;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;

	public GestionSourisMenu(Fenetre fen, JButton b1, JButton b2, JButton b3) {

		this.fenetre = fen;
		this.bouton1 = b1;
		this.bouton2 = b2;
		this.bouton3 = b3;

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) {
			CardLayout cl = (CardLayout) (this.fenetre.getCards().getLayout());
			cl.show(this.fenetre.getCards(), Fenetre.TABLEAUJEU);
			this.fenetre.getPanelJeu().grabFocus();
		} else if (arg0.getSource() == this.bouton2) {
			CardLayout cl = (CardLayout) (this.fenetre.getCards().getLayout());
			cl.show(this.fenetre.getCards(), Fenetre.TABLEAUEDITEUR);
			this.fenetre.getPanelEdit().grabFocus();
		} else if (arg0.getSource() == this.bouton3) {
			System.exit(0);
		}
	}
}