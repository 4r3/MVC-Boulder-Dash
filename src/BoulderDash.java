import Modele.Niveau;

public class BoulderDash
{

	public static void main(String[] args)
	{
		Niveau level = new Niveau(20, 20, 5, 5, 18, 18);
		int x, y;
		for ( x = 0; x < 20; x++ ) {
			level.insereMurNormal(x, 5);
		}
		for ( y = 8; y < 12; y++ ) {
			for ( x = 0; x < 20; x++ ) {
				level.insereVide(x, y);
			}
		}
		level.affiche();
	}
}
