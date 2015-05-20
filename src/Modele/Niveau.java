package Modele;

import java.util.ArrayList;
import java.util.List;

import Modele.Cases.Boue;
import Modele.Cases.Case;
import Modele.Cases.Mobile;
import Modele.Cases.MurIndestructible;

public class Niveau
{
	//Variables
	private Case[][] tableau;
	private List<Mobile> UpTable;

	//Constructeurs

	/**
	 * cree un @see Niveau de 10*10
	 * 
	 */
	public Niveau()
	{
		this(10, 10);
	}

	/**
	 * crée un niveau de l*h rempli de @see boue et avec une bordure de @see
	 * MurIndestructible
	 * 
	 * @param l
	 *            : longueur du niveau
	 * @param h
	 *            : hauteur du niveau
	 * 
	 * 
	 */
	public Niveau(int l, int h)
	{
		tableau = new Case[l][h];
		int x, y;

		UpTable = new ArrayList<>();

		//remplisage du niveau
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

	public void refresh()
	{
		for ( Mobile mob : UpTable ) {
			mob.refresh();
		}
	}
}
