/**
 * 
 */
package BoulderDash.Controlleur.Jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import BoulderDash.Modele.Niveau;
import BoulderDash.Modele.Cases.Directions;

/**
 * @author 4r3
 *
 */
public class GestionClavierJeu implements KeyListener
{
	private Map<Integer, Boolean> keys;
	private Niveau niveau;

	public GestionClavierJeu(Niveau niveau)
	{
		this.niveau = niveau;
		keys = new HashMap<>();
		keys.put(KeyEvent.VK_RIGHT, false);
		keys.put(KeyEvent.VK_LEFT, false);
		keys.put(KeyEvent.VK_UP, false);
		keys.put(KeyEvent.VK_DOWN, false);

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch ( e.getKeyCode() ) {
			case KeyEvent.VK_UP :
				keys.put(KeyEvent.VK_UP, false);
				break;
			case KeyEvent.VK_LEFT :
				keys.put(KeyEvent.VK_LEFT, false);
				break;
			case KeyEvent.VK_DOWN :
				keys.put(KeyEvent.VK_DOWN, false);
				break;
			case KeyEvent.VK_RIGHT :
				keys.put(KeyEvent.VK_RIGHT, false);
				break;
			default :
				break;
		}
		if ( keys.get(KeyEvent.VK_RIGHT) ) {
			droite();
		} else if ( keys.get(KeyEvent.VK_LEFT) ) {
			gauche();
		} else if ( keys.get(KeyEvent.VK_UP) ) {
			haut();
		} else if ( keys.get(KeyEvent.VK_DOWN) ) {
			bas();
		} else {
			niveau.getPerso().setDeplace(Directions.Null);
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch ( e.getKeyCode() ) {
			case KeyEvent.VK_UP :
				haut();
				break;
			case KeyEvent.VK_LEFT :
				gauche();
				break;
			case KeyEvent.VK_DOWN :
				bas();
				break;
			case KeyEvent.VK_RIGHT :
				droite();
				break;
			default :
				break;
		}
	}

	private void droite()
	{
		keys.put(KeyEvent.VK_RIGHT, true);
		niveau.getPerso().setDeplace(Directions.Droite);
	}

	private void bas()
	{
		keys.put(KeyEvent.VK_DOWN, true);
		niveau.getPerso().setDeplace(Directions.Bas);
	}

	private void gauche()
	{
		keys.put(KeyEvent.VK_LEFT, true);
		niveau.getPerso().setDeplace(Directions.Gauche);
	}

	private void haut()
	{
		keys.put(KeyEvent.VK_UP, true);
		niveau.getPerso().setDeplace(Directions.Haut);
	}

}
