package Modele;

import Modele.Cases.Boue;
import Modele.Cases.Case;
import Modele.Cases.MurIndestructible;

public class Niveau
{
	//Variables
	private Case[][] tableau;

	//Constructeurs

	public Niveau()
	{
		this(10, 10);
	}

	public Niveau(int l, int h)
	{
		tableau = new Case[l][h];
		int x, y;
		for ( y = 0; y < h; y++ ) {
			if ( y == 0 || y == (h - 1) ) {
				for ( x = 0; x < l; x++ ) {
					tableau[x][y] = new MurIndestructible();
				}
			} else {
				tableau[0][y] = new MurIndestructible();
				for ( x = 1; x < (l - 1); x++ ) {
					tableau[x][y] = new Boue();
				}
				tableau[l - 1][y] = new MurIndestructible();
			}
		}
	}
}
