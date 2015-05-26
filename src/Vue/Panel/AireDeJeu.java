package Vue.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import Modele.Niveau;
import Modele.Variables;
import Modele.Animation.Etats;
import Modele.Cases.Boue;
import Modele.Cases.Directions;
import Modele.Cases.MurIndestructible;
import Modele.Cases.MurNormal;
import Modele.Cases.Personnage;
import Modele.Cases.Vide;

public class AireDeJeu extends JPanel
{

	private Niveau niveau;

	private Map<Integer, Boolean> keys;
	private int compteurMvt;
	private int mvtDelay;
	private int compteurIdle;
	private int idleDelay;

	private int lastAnim = KeyEvent.VK_DOWN;

	public AireDeJeu()
	{
		initAireDeJeu();
	}

	private void initAireDeJeu()
	{
		niveau = new Niveau(20, 15, 5, 5, 18, 18);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(this.niveau.getLongueur() * Variables.TAILLE_CASE, this.niveau.getHauteur() * Variables.TAILLE_CASE));
		setDoubleBuffered(true);

		keys = new HashMap<Integer, Boolean>();
		keys.put(KeyEvent.VK_RIGHT, false);
		keys.put(KeyEvent.VK_LEFT, false);
		keys.put(KeyEvent.VK_UP, false);
		keys.put(KeyEvent.VK_DOWN, false);

		this.compteurMvt = 0;
		this.mvtDelay = Variables.DELAI_MARCHE;
		this.compteurIdle = 0;
		this.idleDelay = Variables.DELAI_IDLE;

		this.niveau.getSortie().getAnimation().start();
	}

	private void drawNiveau(Graphics g)
	{
		int a, b;
		Vide vide = new Vide();
		Boue boue = new Boue();
		MurIndestructible murInd = new MurIndestructible();
		MurNormal murNorm = new MurNormal();
		for ( a = 0; a < this.niveau.getLongueur(); a++ ) {
			for ( b = 0; b < this.niveau.getHauteur(); b++ ) {
				g.drawImage(vide.getAnimation().getSprite(), a * Variables.TAILLE_CASE, b * Variables.TAILLE_CASE, null);
				switch ( this.niveau.getCase(a, b).getClass().getName() ) {
					case "Modele.Cases.Boue" :
						g.drawImage(boue.getAnimation().getSprite(), a * Variables.TAILLE_CASE, b * Variables.TAILLE_CASE, null);
						break;
					case "Modele.Cases.MurNormal" :
						g.drawImage(murNorm.getAnimation().getSprite(), a * Variables.TAILLE_CASE, b * Variables.TAILLE_CASE, null);
						break;
					case "Modele.Cases.MurIndestructible" :
						g.drawImage(murInd.getAnimation().getSprite(), a * Variables.TAILLE_CASE, b * Variables.TAILLE_CASE, null);
						break;
					case "Modele.Cases.Sortie" :
						g.drawImage(this.niveau.getSortie().getAnimation().getSprite(), a * Variables.TAILLE_CASE, b * Variables.TAILLE_CASE, null);
						break;
					case "Modele.Cases.Personnage" :
						g.drawImage(this.niveau.getPerso().getAnimation().getSprite(), a * Variables.TAILLE_CASE, b * Variables.TAILLE_CASE, null);
						break;
				}
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public void toucheDroite()
	{
		keys.put(KeyEvent.VK_RIGHT, true);
		lastAnim = KeyEvent.VK_RIGHT;
		niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheDroite));
		niveau.getPerso().getAnimation().start();
		repaint();
	}

	public void toucheGauche()
	{
		keys.put(KeyEvent.VK_LEFT, true);
		if ( !keys.get(KeyEvent.VK_RIGHT) ) {
			lastAnim = KeyEvent.VK_LEFT;
			niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheGauche));
			niveau.getPerso().getAnimation().start();
			repaint();
		}
	}

	public void toucheHaut()
	{
		keys.put(KeyEvent.VK_UP, true);
		if ( !keys.get(KeyEvent.VK_RIGHT) && !keys.get(KeyEvent.VK_LEFT) ) {
			lastAnim = KeyEvent.VK_UP;
			niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheHaut));
			niveau.getPerso().getAnimation().start();
			repaint();
		}
	}

	public void toucheBas()
	{
		keys.put(KeyEvent.VK_DOWN, true);
		if ( !keys.get(KeyEvent.VK_RIGHT) && !keys.get(KeyEvent.VK_LEFT) && !keys.get(KeyEvent.VK_UP) ) {
			lastAnim = KeyEvent.VK_DOWN;
			niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheBas));
			niveau.getPerso().getAnimation().start();
			repaint();
		}
	}

	public void toucheRelache(KeyEvent evt)
	{
		keys.put(evt.getKeyCode(), false);
		if ( !keys.containsValue(true) ) {
			switch ( lastAnim ) {
				case KeyEvent.VK_RIGHT :
					if ( keys.get(KeyEvent.VK_LEFT) ) {
						lastAnim = KeyEvent.VK_LEFT;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheGauche));
					} else if ( keys.get(KeyEvent.VK_UP) ) {
						lastAnim = KeyEvent.VK_UP;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheHaut));
					} else if ( keys.get(KeyEvent.VK_DOWN) ) {
						lastAnim = KeyEvent.VK_DOWN;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheBas));
					} else {
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.StopDroite));
						niveau.getPerso().getAnimation().stop();
						niveau.getPerso().getAnimation().reset();
					}
					repaint();
					break;
				case KeyEvent.VK_LEFT :
					if ( keys.get(KeyEvent.VK_RIGHT) ) {
						lastAnim = KeyEvent.VK_RIGHT;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheDroite));
					} else if ( keys.get(KeyEvent.VK_UP) ) {
						lastAnim = KeyEvent.VK_UP;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheHaut));
					} else if ( keys.get(KeyEvent.VK_DOWN) ) {
						lastAnim = KeyEvent.VK_DOWN;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheBas));
					} else {
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.StopGauche));
						niveau.getPerso().getAnimation().stop();
						niveau.getPerso().getAnimation().reset();
					}
					repaint();
					break;
				case KeyEvent.VK_UP :
					if ( keys.get(KeyEvent.VK_RIGHT) ) {
						lastAnim = KeyEvent.VK_RIGHT;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheDroite));
					} else if ( keys.get(KeyEvent.VK_LEFT) ) {
						lastAnim = KeyEvent.VK_LEFT;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheGauche));
					} else if ( keys.get(KeyEvent.VK_DOWN) ) {
						lastAnim = KeyEvent.VK_DOWN;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheBas));
					} else {
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.StopHaut));
						niveau.getPerso().getAnimation().stop();
						niveau.getPerso().getAnimation().reset();
					}
					repaint();
					break;
				case KeyEvent.VK_DOWN :
					if ( keys.get(KeyEvent.VK_RIGHT) ) {
						lastAnim = KeyEvent.VK_RIGHT;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheDroite));
					} else if ( keys.get(KeyEvent.VK_LEFT) ) {
						lastAnim = KeyEvent.VK_LEFT;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheGauche));
					} else if ( keys.get(KeyEvent.VK_UP) ) {
						lastAnim = KeyEvent.VK_UP;
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheHaut));
					} else {
						niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.StopBas));
						niveau.getPerso().getAnimation().stop();
						niveau.getPerso().getAnimation().reset();
					}
					repaint();
					break;
			}
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		drawNiveau(g);
		// drawPerso(g);
	}

	private void drawPerso(Graphics g)
	{
		g.drawImage(niveau.getPerso().getAnimation().getSprite(), this.niveau.getPerso().getPos_x(), this.niveau.getPerso().getPos_y(), null);
		Toolkit.getDefaultToolkit().sync();
	}

	private void cycle()
	{
		niveau.getPerso().getAnimation().update();
		this.niveau.getSortie().getAnimation().update();
	}

	private void mouvement(int dir)
	{
		switch ( dir ) {
			case KeyEvent.VK_RIGHT :
				if ( !(this.niveau.getPerso().getPos_x() * Variables.TAILLE_CASE >= (this.niveau.getLongueur() * Variables.TAILLE_CASE) - (Variables.PAS_MVT)) ) {
					this.niveau.getPerso().setDeplace(Directions.Droite);
				}
				break;
			case KeyEvent.VK_LEFT :
				if ( !(this.niveau.getPerso().getPos_x() * Variables.TAILLE_CASE <= 0) ) this.niveau.getPerso().setDeplace(Directions.Gauche);
				break;
			case KeyEvent.VK_UP :
				if ( !(this.niveau.getPerso().getPos_y() * Variables.TAILLE_CASE <= 0) ) this.niveau.getPerso().setDeplace(Directions.Haut);
				break;
			case KeyEvent.VK_DOWN :
				if ( !(this.niveau.getPerso().getPos_y() * Variables.TAILLE_CASE >= (this.niveau.getHauteur() * Variables.TAILLE_CASE) - (Variables.PAS_MVT)) ) this.niveau.getPerso().setDeplace(Directions.Bas);
				break;
		}
	}

	public void update()
	{
		if ( (boolean) keys.get(KeyEvent.VK_RIGHT) ) {
			compteurMvt++;
			compteurIdle = 0;
			if ( compteurMvt > mvtDelay ) {
				compteurMvt = 0;
				mouvement(KeyEvent.VK_RIGHT);
			}
		} else if ( (boolean) keys.get(KeyEvent.VK_LEFT) ) {
			compteurMvt++;
			compteurIdle = 0;
			if ( compteurMvt > mvtDelay ) {
				compteurMvt = 0;
				mouvement(KeyEvent.VK_LEFT);
				lastAnim = KeyEvent.VK_LEFT;
				niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheGauche));
			}
		} else if ( (boolean) keys.get(KeyEvent.VK_UP) ) {
			compteurMvt++;
			compteurIdle = 0;
			if ( compteurMvt > mvtDelay ) {
				compteurMvt = 0;
				mouvement(KeyEvent.VK_UP);
				lastAnim = KeyEvent.VK_UP;
				niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheHaut));
			}
		} else if ( (boolean) keys.get(KeyEvent.VK_DOWN) ) {
			compteurMvt++;
			compteurIdle = 0;
			if ( compteurMvt > mvtDelay ) {
				compteurMvt = 0;
				mouvement(KeyEvent.VK_DOWN);
				lastAnim = KeyEvent.VK_DOWN;
				niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.MarcheBas));
			}
		} else {
			compteurIdle++;
			if ( compteurIdle > idleDelay ) {
				compteurIdle = (compteurIdle + idleDelay) % idleDelay;
				niveau.getPerso().setAnimation(Personnage.getAnimations().get(Etats.StopIdle));
				niveau.getPerso().getAnimation().start();
			}
		}
		repaint();
	}

	public void refreshJeu()
	{
		cycle();
		update();
		this.niveau.refresh();
		repaint();
	}

}
