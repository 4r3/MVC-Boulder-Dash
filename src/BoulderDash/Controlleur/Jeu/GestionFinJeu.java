/**
 * 
 */
package BoulderDash.Controlleur.Jeu;

import javax.swing.JOptionPane;

import BoulderDash.BoulderDash;
import BoulderDash.Modele.EtatApplication;
import BoulderDash.Vue.Vues;

/**
 * @author 4r3
 *
 */
public class GestionFinJeu {
	public static void finJeu() {
		if (BoulderDash.getJeu().getNiveau().getPerso().isVivant()) {
			popVictoire();
		} else {
			popDefaite();
		}

	}

	private static void popVictoire() {
		Object[] options = { "Menu principal", "Recommencer le niveau",
				"Changer de niveau" };
		String message = "Score Niveau:\n"
				+ "\tDiamants : "
				+ BoulderDash.getJeu().getNiveau().getScore()
				+ "\n\t Bonus de temps : "
				+ BoulderDash.getJeu().getNiveau().getTmax()
				+ "\n\tScore total : "
				+ (BoulderDash.getJeu().getScore() + BoulderDash.getJeu()
						.getNiveau().getTmax());
		int n = JOptionPane.showOptionDialog(BoulderDash.getFen(), message,
				"Victoire !!!", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
		switch (n) {
		case 0:
			BoulderDash.getJeu().resetScore();
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
			break;
		case 1:
			BoulderDash.getJeu().restartLevel();
			BoulderDash.getFen().changerVue(Vues.TABLEAUJEU);
			BoulderDash.setState(EtatApplication.Jeu);
			break;
		case 2:
			BoulderDash.getFen().changerVue(Vues.MENUCHOIXNIVEAU);
			break;
		default:
			break;
		}
	}

	private static void popDefaite() {
		Object[] options = { "Menu principal", "Nouveau jeu" };
		String message = "Votre score : " + BoulderDash.getJeu().getScore();
		int n = JOptionPane.showOptionDialog(BoulderDash.getFen(), message,
				"Vous avez perdu", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		switch (n) {
		case 0:
			BoulderDash.getFen().changerVue(Vues.MENUPRINCIPAL);
			break;
		case 1:
			BoulderDash.getFen().changerVue(Vues.MENUCHOIXNIVEAU);
			break;
		default:
			break;
		}
	}
}
