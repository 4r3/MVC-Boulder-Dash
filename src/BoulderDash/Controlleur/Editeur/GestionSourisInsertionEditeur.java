package BoulderDash.Controlleur.Editeur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.Editeur;
import BoulderDash.Modele.Variables;

public class GestionSourisInsertionEditeur implements MouseListener,
		MouseMotionListener {

	private Editeur editeur;

	public GestionSourisInsertionEditeur() {
		this.editeur = BoulderDash.getEdit();
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.editeur.modifierNiveau(e.getPoint().x / Variables.TAILLE_CASE,
				e.getPoint().y / Variables.TAILLE_CASE);
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.editeur.modifierNiveau(e.getPoint().x / Variables.TAILLE_CASE,
				e.getPoint().y / Variables.TAILLE_CASE);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
