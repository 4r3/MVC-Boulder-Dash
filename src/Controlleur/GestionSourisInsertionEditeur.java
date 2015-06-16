package Controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Modele.Editeur;
import Modele.Variables;
import Vue.Panel.AirePlateauEditeur;

public class GestionSourisInsertionEditeur implements MouseListener,
		MouseMotionListener {

	private Editeur editeur;

	public GestionSourisInsertionEditeur(AirePlateauEditeur panel,
			Editeur editeur) {
		this.editeur = editeur;
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.editeur.modifierNiveau(e.getPoint().x / Variables.TAILLE_CASE,
				e.getPoint().y / Variables.TAILLE_CASE);
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.editeur.modifierNiveau(e.getPoint().x / Variables.TAILLE_CASE,
				e.getPoint().y / Variables.TAILLE_CASE);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
