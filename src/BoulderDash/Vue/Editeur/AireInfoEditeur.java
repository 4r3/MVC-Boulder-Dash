package BoulderDash.Vue.Editeur;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BoulderDash.Controlleur.Editeur.GestionBoutonEditeur;
import BoulderDash.Modele.Variables;
import BoulderDash.Modele.Animation.ChoixAnimation;
import BoulderDash.Modele.Animation.TableAnimation;

/**
 * Vue de la zone d'information de l'éditeur qui permet de sélectionner
 * l'élément à placer
 * 
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class AireInfoEditeur extends JPanel {

	/**
	 * Initialisation du panel
	 */
	public AireInfoEditeur() {
		setLayout(new GridLayout(11, 2));
		initAireInformation();
	}

	/**
	 * Initialisation du panel
	 */
	private void initAireInformation() {
		setPreferredSize(new Dimension(Variables.LARGEUR_PANEL_SCORE,
				Variables.HAUTEUR_PANEL_SCORE));
		setBackground(Variables.COULEUR);
		setDoubleBuffered(true);

		JLabel labelRockford = new JLabel("Rockford");
		labelRockford.setForeground(Variables.COULEUR_TEXTE);
		JButton rockford = new JButton(new ImageIcon(TableAnimation
				.Personnage(ChoixAnimation.Personnage_Idle).getSprite()
				.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		rockford.setBorder(BorderFactory.createEmptyBorder());
		rockford.setContentAreaFilled(false);

		JLabel labelSortie = new JLabel("Sortie");
		labelSortie.setForeground(Variables.COULEUR_TEXTE);
		JButton sortie = new JButton(new ImageIcon(TableAnimation.getSortie()
				.getSprite().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		sortie.setBorder(BorderFactory.createEmptyBorder());
		sortie.setContentAreaFilled(false);

		JLabel labelDiamant = new JLabel("Diamant");
		labelDiamant.setForeground(Variables.COULEUR_TEXTE);
		JButton diamant = new JButton(new ImageIcon(TableAnimation.getDiamant()
				.getSprite().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		diamant.setBorder(BorderFactory.createEmptyBorder());
		diamant.setContentAreaFilled(false);

		JLabel labelRocher = new JLabel("Rocher");
		labelRocher.setForeground(Variables.COULEUR_TEXTE);
		JButton rocher = new JButton(new ImageIcon(TableAnimation.getRocher()
				.getSprite().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		rocher.setBorder(BorderFactory.createEmptyBorder());
		rocher.setContentAreaFilled(false);

		JLabel labelVide = new JLabel("Vide");
		labelVide.setForeground(Variables.COULEUR_TEXTE);
		JButton vide = new JButton(new ImageIcon(TableAnimation.getVide()
				.getSprite().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		vide.setBorder(BorderFactory.createEmptyBorder());
		vide.setContentAreaFilled(false);

		JLabel labelBoue = new JLabel("Boue");
		labelBoue.setForeground(Variables.COULEUR_TEXTE);
		JButton boue = new JButton(new ImageIcon(TableAnimation.getBoue()
				.getSprite().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		boue.setBorder(BorderFactory.createEmptyBorder());
		boue.setContentAreaFilled(false);

		JLabel labelMur = new JLabel("Mur");
		labelMur.setForeground(Variables.COULEUR_TEXTE);
		JButton mur = new JButton(new ImageIcon(TableAnimation.getMur()
				.getSprite().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		mur.setBorder(BorderFactory.createEmptyBorder());
		mur.setContentAreaFilled(false);

		JLabel labelMurMag = new JLabel("Mur Magique");
		labelMurMag.setForeground(Variables.COULEUR_TEXTE);
		JButton murMag = new JButton(new ImageIcon(TableAnimation
				.getMurMagique().getSprite()
				.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		murMag.setBorder(BorderFactory.createEmptyBorder());
		murMag.setContentAreaFilled(false);

		JLabel labelPapillon = new JLabel("Papillon");
		labelPapillon.setForeground(Variables.COULEUR_TEXTE);
		JButton papillon = new JButton(new ImageIcon(TableAnimation
				.getPapillon().getSprite()
				.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		papillon.setBorder(BorderFactory.createEmptyBorder());
		papillon.setContentAreaFilled(false);

		// ajout des boutons dans le controlleur
		GestionBoutonEditeur ctrl = new GestionBoutonEditeur(rockford, sortie,
				diamant, rocher, vide, boue, mur, murMag, papillon);

		rockford.addActionListener(ctrl);
		sortie.addActionListener(ctrl);
		diamant.addActionListener(ctrl);
		rocher.addActionListener(ctrl);
		vide.addActionListener(ctrl);
		boue.addActionListener(ctrl);
		mur.addActionListener(ctrl);
		murMag.addActionListener(ctrl);
		papillon.addActionListener(ctrl);

		add(rockford);
		add(labelRockford);
		add(sortie);
		add(labelSortie);
		add(diamant);
		add(labelDiamant);
		add(rocher);
		add(labelRocher);
		add(vide);
		add(labelVide);
		add(boue);
		add(labelBoue);
		add(mur);
		add(labelMur);
		add(murMag);
		add(labelMurMag);
		add(papillon);
		add(labelPapillon);
	}
}
