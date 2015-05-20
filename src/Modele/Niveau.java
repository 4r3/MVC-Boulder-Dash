package Modele;

import java.util.ArrayList;
import java.util.List;

import Modele.Cases.Boue;
import Modele.Cases.Case;
import Modele.Cases.ElementDynamique;
import Modele.Cases.MurIndestructible;
import Modele.Cases.Personage;
import Modele.Cases.Sortie;

/**
 * Classe de niveau, décrit un niveau complet, le niveau est constitué de
 * tableau bidimentionel de Case
 * 
 * @see Case
 * @author 4r3
 *
 */
public class Niveau
{
	//Variables
	private int hauteur;
	private int longueur;
	private Personage perso;
	private Sortie sortie;
	/**
	 * tableau de Case du niveau
	 */
	private Case[][] tableau;

	/**
	 * tableau de mise à jour, contient les ElementDynamique suceptibles d'etre
	 * modifiés au prochain cycle
	 */
	private List<ElementDynamique> UpTable;

	/**
	 * crée un Niveau de 10*10
	 * 
	 */
	public Niveau()
	{
		this(10, 10);
	}

	/**
	 * crée un niveau de l*h rempli de boue et avec une bordure de
	 * MurIndestructible
	 * 
	 * @param l
	 *            : longueur du niveau
	 * @param h
	 *            : hauteur du niveau
	 * @see Boue
	 * @see MurIndestructible
	 * 
	 */
	public Niveau(int l, int h)
	{
		int x, y;

		tableau = new Case[l][h];
		UpTable = new ArrayList<>();
		hauteur = h;
		longueur = l;

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

	/**
	 * insere le personage dans le niveau à la position indiquée en argument
	 * 
	 * @param x
	 *            : position en x du personage
	 * @param y
	 *            : position en y du personage
	 */
	public void inserePersonage(int x, int y)
	{
		if ( x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1 ) {
			perso = new Personage(x, y);
			tableau[x][y] = perso;
			UpTable.add(perso);
		}
	}

	/**
	 * insere la sortie du niveau a la position indiquée en argument
	 * 
	 * @param x
	 *            : position en x de la sortie
	 * @param y
	 *            : position en y de la sortie
	 */
	public void insereSortie(int x, int y)
	{
		if ( x >= 0 && x < longueur && y >= 0 && y < hauteur ) {
			sortie = new Sortie();
			tableau[x][y] = sortie;
		}
	}

	/**
	 * fonction de mise à jour du niveau, met a jour tout les ElementDynamique
	 * suceptibles d'etre mis a jour dans le niveau
	 */
	public void refresh()
	{
		for ( ElementDynamique mob : UpTable ) {
			mob.refresh();
		}
	}

	/**
	 * affiche le niveau en mode texte, a utiliser pour le débuggage
	 */
	public void affiche()
	{
		int x, y;
		for ( y = 0; y < hauteur; y++ ) {
			for ( x = 0; x < longueur; x++ ) {
				System.out.print(tableau[x][y].ID() + " ");
			}
			System.out.print("\n");
		}
	}
}
