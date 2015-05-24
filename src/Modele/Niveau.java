package Modele;

import java.util.ArrayList;
import java.util.List;

import Modele.Cases.Boue;
import Modele.Cases.Case;
import Modele.Cases.Chutable;
import Modele.Cases.Diamant;
import Modele.Cases.ElementDynamique;
import Modele.Cases.MurIndestructible;
import Modele.Cases.MurNormal;
import Modele.Cases.Personnage;
import Modele.Cases.Rocher;
import Modele.Cases.Sortie;
import Modele.Cases.Vide;

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
	private int dscore;
	private boolean fini;
	private Personnage perso;
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
	 * crée un Niveau de 10*10 avec le personage en haut a gauche et la sortie
	 * en bas a droite
	 * 
	 */
	public Niveau()
	{
		this(10, 10, 1, 1, 8, 8);
	}

	/**
	 * crée un niveau de l*h rempli de boue et avec une bordure de
	 * MurIndestructible, avec une sortie en Sx,Sy et un personage en Px,Py
	 * 
	 * @param l
	 *            longueur du niveau
	 * @param h
	 *            hauteur du niveau
	 * @param Px
	 *            position du personage en x
	 * @param Py
	 *            position du personage en y
	 * @param Sx
	 *            position de la sortie en x
	 * @param Sy
	 *            position de la sortie en y
	 * @see Boue
	 * @see MurIndestructible
	 * 
	 */
	public Niveau(int l, int h, int Px, int Py, int Sx, int Sy)
	{
		int x, y;

		tableau = new Case[l][h];
		UpTable = new ArrayList<>();
		hauteur = h;
		longueur = l;
		fini = false;
		dscore = 2; //TODO gerer a la construction

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
		inserePersonage(Px, Py);
		insereSortie(Sx, Sy);
	}

	/**
	 * insere le personage dans le niveau à la position indiquée en argument
	 * 
	 * @param x
	 *            position en x du personage
	 * @param y
	 *            position en y du personage
	 */
	private void inserePersonage(int x, int y)
	{
		if ( x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1 ) {
			perso = new Personnage(x, y);
			tableau[x][y] = perso;
		} else {
			perso = new Personnage(1, 1);
			tableau[1][1] = perso;
		}

	}

	/**
	 * insere la sortie du niveau a la position indiquée en argument
	 * 
	 * @param x
	 *            position en x de la sortie
	 * @param y
	 *            position en y de la sortie
	 */
	private void insereSortie(int x, int y)
	{
		if ( x >= 0 && x < longueur && y >= 0 && y < hauteur && tableau[x][y] != perso ) {

			sortie = new Sortie();
			tableau[x][y] = sortie;
		} else {
			sortie = new Sortie();
			tableau[longueur - 2][hauteur - 2] = sortie;
		}
	}

	/**
	 * insere un MurNormal a la position indiquée en argument
	 * 
	 * @param x
	 *            position en x de la sortie
	 * @param y
	 *            position en y de la sortie
	 */
	public void insereMurNormal(int x, int y)
	{
		if ( x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1 && tableau[x][y] != perso && tableau[x][y] != sortie ) {
			tableau[x][y] = new MurNormal();
		}
	}

	/**
	 * insere du Vide a la position indiquée en argument
	 * 
	 * @param x
	 *            position en x de la sortie
	 * @param y
	 *            position en y de la sortie
	 */
	public void insereVide(int x, int y)
	{
		if ( x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1 && tableau[x][y] != perso && (tableau[x][y] != sortie || sortie.isOuverte()) ) {
			tableau[x][y] = new Vide();
		}
	}

	public void insereRocher(int x, int y)
	{
		if ( x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1 && tableau[x][y] != perso && (tableau[x][y] != sortie || sortie.isOuverte()) ) {
			tableau[x][y] = new Rocher(x, y);
			UpTable.add((ElementDynamique) tableau[x][y]);
		}
	}

	public void insereDiamant(int x, int y)
	{
		if ( x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1 && tableau[x][y] != perso && (tableau[x][y] != sortie || sortie.isOuverte()) ) {
			tableau[x][y] = new Diamant(x, y);
			UpTable.add((ElementDynamique) tableau[x][y]);
		}
	}

	/**
	 * fonction de mise à jour du niveau, met a jour tout les ElementDynamique
	 * suceptibles d'etre mis a jour dans le niveau
	 */
	public void refresh()
	{
		int i = 0;
		perso.refresh(this);
		trieUpTable();
		while ( i < UpTable.size() ) {
			UpTable.get(i).refresh(this);
			i++;
		}
		cleanUpTable();
		if ( !sortie.isOuverte() && dscore <= 0 ) {
			sortie.setOuverte(true);
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
		System.out.print(UpTable.size());
		System.out.println(UpTable.toString());
		System.out.println("Diamant restant :" + dscore);
		System.out.println("sortie ouverte : " + sortie.isOuverte());
	}

	public Case getCase(int x, int y)
	{
		if ( x >= 0 && x < longueur && y >= 0 && y < hauteur ) {
			return tableau[x][y];
		} else {
			return null;
		}
	}

	public Personnage getPerso()
	{
		return perso;
	}

	public void echangeCases(int x1, int y1, int x2, int y2)
	{
		Case temp = tableau[x1][y1];
		tableau[x1][y1] = tableau[x2][y2];
		tableau[x2][y2] = temp;
	}

	public void addUptable(int x, int y)
	{
		if ( tableau[x][y] instanceof ElementDynamique && !UpTable.contains(tableau[x][y]) && !(tableau[x][y] instanceof Personnage) ) {
			UpTable.add(UpTable.size(), (ElementDynamique) tableau[x][y]);
		}
	}

	public void remplirUpTable(int x, int y)
	{
		addUptable(x, y - 1);
		addUptable(x + 1, y - 1);
		addUptable(x - 1, y - 1);
	}

	public void trieUpTable()
	{
		int i = 0;
		int j, pmin;
		ElementDynamique temp;

		while ( i < UpTable.size() - 1 ) {
			pmin = i;
			j = i + 1;
			while ( j < UpTable.size() ) {
				if ( UpTable.get(j).isSuperior(UpTable.get(pmin)) ) {
					pmin = j;
				}
				j++;
			}
			temp = UpTable.set(i, UpTable.get(pmin));
			UpTable.set(pmin, temp);
			i++;
		}
	}

	public void cleanUpTable()
	{
		int i = 0;
		while ( i < UpTable.size() ) {
			if ( (UpTable.get(i) instanceof Chutable) && !((Chutable) UpTable.get(i)).enChute() ) {
				UpTable.remove(i);
			} else {
				i++;
			}
		}
	}

	public void remUptable(Case C)
	{
		UpTable.remove(C);
	}

	public boolean isFini()
	{
		return fini;
	}

	public void setFini()
	{
		fini = true;
	}

	/**
	 * 
	 */
	public void AddDscore()
	{
		dscore--;
	}

}
