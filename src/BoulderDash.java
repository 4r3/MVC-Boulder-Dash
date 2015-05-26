import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;

import Modele.Cases.Directions;

public class BoulderDash
{

	public static void main(String[] args)
	{
		/*
		 * Niveau level = new Niveau(20, 12, 5, 5, 5, 10); int x, y;
		 * 
		 * for ( y = 1; y < 19; y++ ) { for ( x = 0; x < 20; x++ ) {
		 * level.insereVide(x, y); } }
		 * 
		 * for ( y = 1; y < 2; y++ ) { for ( x = 1; x < 5; x++ ) {
		 * level.insereDiamant(x, y); } }
		 * 
		 * //level.insereRocher(4, 6); //level.insereRocher(4, 7);
		 * level.insereMurNormal(4, 8);
		 * 
		 * System.out.print("\r"); level.afficheDebug(); while ( !level.isFini()
		 * ) { System.out.print("\r");
		 * level.getPerso().setDeplace(getDirection()); long time =
		 * System.nanoTime(); level.refresh(); level.afficheDebug();
		 * System.out.println("refresh : " + (System.nanoTime() - time) / 1000 +
		 * " µs"); } System.out.println("niveau terminé");
		 */

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run()
			{
				JFrame ex = new ThreadBoulderDash();
				ex.setVisible(true);
			}
		});
	}

	@SuppressWarnings("resource")
	public static Directions getDirection()
	{
		Directions dir;
		Scanner scanner = new Scanner(System.in);
		int in = scanner.nextInt();
		switch ( in ) {
			case 8 :
				dir = Directions.Haut;
				break;
			case 6 :
				dir = Directions.Droite;
				break;
			case 4 :
				dir = Directions.Gauche;
				break;
			case 2 :
				dir = Directions.Bas;
				break;
			default :
				dir = Directions.Null;
				break;
		}
		return dir;
	}
}
