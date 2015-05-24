import java.util.Scanner;

import Modele.Niveau;
import Modele.Cases.Directions;

public class BoulderDash
{

	public static void main(String[] args)
	{
		Niveau level = new Niveau(20, 15, 5, 5, 5, 10);
		int x, y;
		for ( x = 0; x < 20; x++ ) {
			level.insereMurNormal(x, 5);
		}

		for ( y = 8; y < 12; y++ ) {
			for ( x = 0; x < 20; x++ ) {
				level.insereVide(x, y);
			}
		}
		level.insereRocher(4, 6);
		level.insereDiamant(4, 5);

		System.out.print("\r");
		level.affiche();
		while ( !level.isFini() ) {
			System.out.print("\r");
			try {
				Thread.sleep(1000); //1000 milliseconds is one second.
			} catch ( InterruptedException ex ) {
				Thread.currentThread().interrupt();
			}
			level.getPerso().setDeplace(getDirection());
			level.refresh();
			level.affiche();
		}
		System.out.println("niveau ternine");
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
