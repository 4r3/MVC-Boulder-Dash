package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.GestionSourisEditeur;
import Modele.Variables;
import Modele.Animation.ChoixAnimation;
import Modele.Animation.TableAnimation;

@SuppressWarnings("serial")
public class AireInfoEditeur extends JPanel {

	public AireInfoEditeur() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initAireInformation();
	}

	private void initAireInformation() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Variables.HAUTEUR_PANEL_SCORE,
				Variables.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		JButton rockford = new JButton(new ImageIcon(TableAnimation.Personnage(
				ChoixAnimation.Personnage_Idle).getSprite()));
		rockford.setBorder(BorderFactory.createEmptyBorder());
		rockford.setContentAreaFilled(false);
		JButton sortie = new JButton(new ImageIcon(TableAnimation.getSortie()
				.getSprite()));
		sortie.setBorder(BorderFactory.createEmptyBorder());
		sortie.setContentAreaFilled(false);
		JButton diamant = new JButton(new ImageIcon(TableAnimation.getDiamant()
				.getSprite()));
		diamant.setBorder(BorderFactory.createEmptyBorder());
		diamant.setContentAreaFilled(false);
		JButton rocher = new JButton(new ImageIcon(TableAnimation.getRocher()
				.getSprite()));
		rocher.setBorder(BorderFactory.createEmptyBorder());
		rocher.setContentAreaFilled(false);
		JButton vide = new JButton(new ImageIcon(TableAnimation.getVide()
				.getSprite()));
		vide.setBorder(BorderFactory.createEmptyBorder());
		vide.setContentAreaFilled(false);
		JButton boue = new JButton(new ImageIcon(TableAnimation.getBoue()
				.getSprite()));
		boue.setBorder(BorderFactory.createEmptyBorder());
		boue.setContentAreaFilled(false);
		JButton mur = new JButton(new ImageIcon(TableAnimation.getMur()
				.getSprite()));
		mur.setBorder(BorderFactory.createEmptyBorder());
		mur.setContentAreaFilled(false);
		JButton murIndest = new JButton(new ImageIcon(TableAnimation.getMur()
				.getSprite()));
		murIndest.setBorder(BorderFactory.createEmptyBorder());
		murIndest.setContentAreaFilled(false);
		JButton murMag = new JButton(new ImageIcon(TableAnimation
				.getMurMagique().getSprite()));
		murMag.setBorder(BorderFactory.createEmptyBorder());
		murMag.setContentAreaFilled(false);
		JButton papillon = new JButton(new ImageIcon(TableAnimation
				.getPapillon().getSprite()));
		papillon.setBorder(BorderFactory.createEmptyBorder());
		papillon.setContentAreaFilled(false);

		JButton retour = new JButton("Menu");
		new GestionSourisEditeur(retour);

		add(rockford);
		add(sortie);
		add(diamant);
		add(rocher);
		add(vide);
		add(boue);
		add(mur);
		add(murIndest);
		add(murMag);
		add(papillon);
		add(retour);
	}
}