package Modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import Modele.Animation.TableAnimation;
import Modele.Cases.Boue;
import Modele.Cases.Case;
import Modele.Cases.Chutable;
import Modele.Cases.Diamant;
import Modele.Cases.ElementDynamique;
import Modele.Cases.MurIndestructible;
import Modele.Cases.MurMagique;
import Modele.Cases.MurNormal;
import Modele.Cases.Papillon;
import Modele.Cases.Personnage;
import Modele.Cases.RefreshAnim;
import Modele.Cases.Rocher;
import Modele.Cases.Sortie;
import Modele.Cases.Vide;

/**
 * Classe de niveau, décrit un niveau complet, le niveau est constitué de
 * tableau bidimentionel de Case, d'une table de rafraichisement
 * 
 * @see Case
 * @author 4r3
 * 
 */
public class Niveau implements RefreshAnim {
	// Variables
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
	 * tableau de mise à jour, contient les ElementDynamique susceptibles d'etre
	 * modifiés au prochain cycle
	 */
	private List<ElementDynamique> UpTable;

	/**
	 * crée un Niveau de 10*10 avec le personage en haut a gauche et la sortie
	 * en bas a droite
	 * 
	 */
	public Niveau() {
		this(60, 40);
	}

	public Niveau(String niveau) {
		UpTable = new ArrayList<>();
		fini = false;
		dscore = 1;

		importer(niveau);
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
	public Niveau(int l, int h) {
		int x, y;

		tableau = new Case[l][h];
		UpTable = new ArrayList<>();
		hauteur = h;
		longueur = l;
		fini = false;
		dscore = 1;

		// remplisage du niveau
		for (y = 0; y < h; y++) {
			if (y == 0 || y == (h - 1)) {
				for (x = 0; x < l; x++) {
					insereMurIndestructible(x, y);
				}
			} else {
				insereMurIndestructible(0, y);
				for (x = 1; x < (l - 1); x++) {
					insereBoue(x, y);
				}
				insereMurIndestructible(l - 1, y);
			}
		}
	}

	/**
	 * insere le personage dans le niveau à la position indiquée en argument
	 * 
	 * @param x
	 *            position en x du personage
	 * @param y
	 *            position en y du personage
	 */
	public void inserePersonage(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1) {
			if (perso == null) {
				perso = new Personnage(x, y);
				// if (sortie != null && tableau[x][y] == sortie) {
				// sortie = null;
				// }
				tableau[x][y] = perso;
			} else {
				echangeCases(perso.getX(), perso.getY(), x, y);
			}

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
	public void insereSortie(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1) {
			if (sortie == null) {
				sortie = new Sortie(x, y);
				if (perso != null && tableau[x][y] == perso) {
					perso = null;
				}
				tableau[x][y] = sortie;
			} else {
				echangeCases(sortie.getX(), sortie.getY(), x, y);
			}
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
	public void insereMurNormal(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new MurNormal(x, y);
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
	public void insereVide(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Vide(x, y);
		}
	}

	public void insereBoue(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Boue(x, y);
		}
	}

	public void insereMurIndestructible(int x, int y) {
		if (x >= 0
				&& x < longueur
				&& y >= 0
				&& y < hauteur
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new MurIndestructible(x, y);
		}
	}

	public void insereRocher(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Rocher(x, y);
			UpTable.add((ElementDynamique) tableau[x][y]);
		}
	}

	public void insereDiamant(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Diamant(x, y);
			UpTable.add((ElementDynamique) tableau[x][y]);
		}
	}

	public void insereMurMagique(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new MurMagique(x, y);
		}
	}

	public void inserePapillon(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Papillon(x, y);
			UpTable.add((ElementDynamique) tableau[x][y]);
		}
	}

	/**
	 * fonction de mise à jour du niveau, met a jour tout les ElementDynamique
	 * suceptibles d'etre mis a jour dans le niveau
	 */
	public void refresh() {
		int i = 0;
		perso.refresh(this);
		trieUpTable();
		while (i < UpTable.size()) {
			UpTable.get(i).refresh(this);
			i++;
		}
		cleanUpTable();
		if (!sortie.isOuverte() && dscore <= 0) {
			sortie.Ouvrir();
		}
	}

	/**
	 * affiche le niveau en mode texte, a utiliser pour le débuggage
	 */
	public void afficheDebug() {
		int x, y;
		for (y = 0; y < hauteur; y++) {
			for (x = 0; x < longueur; x++) {
				System.out.print(tableau[x][y].ID() + " ");
			}
			System.out.print("\n");
		}
		System.out.print(UpTable.size());
		System.out.println(UpTable.toString());
		System.out.println("Diamant restant :" + dscore);
	}

	public Case getCase(int x, int y) {
		if (x >= 0 && x < longueur && y >= 0 && y < hauteur) {
			return tableau[x][y];
		} else {
			return null;
		}
	}

	public Personnage getPerso() {
		return perso;
	}

	public Sortie getSortie() {
		return sortie;
	}

	public void echangeCases(int x1, int y1, int x2, int y2) {
		Case temp = tableau[x1][y1];
		tableau[x1][y1] = tableau[x2][y2];
		tableau[x2][y2] = temp;
		tableau[x1][y1].setXY(x1, y1);
		tableau[x2][y2].setXY(x2, y2);
	}

	//
	//
	//
	//
	//
	//
	//
	//

	public void addUptable(int x, int y) {
		if (tableau[x][y] instanceof ElementDynamique
				&& !UpTable.contains(tableau[x][y])
				&& !(tableau[x][y] instanceof Personnage)) {
			UpTable.add(UpTable.size(), (ElementDynamique) tableau[x][y]);
		}
	}

	public void remplirUpTable(int x, int y) {
		addUptable(x, y - 1);
		addUptable(x + 1, y - 1);
		addUptable(x - 1, y - 1);
		addUptable(x + 1, y);
		addUptable(x - 1, y);
	}

	public void trieUpTable() {
		int i = 0;
		int j, pmin;
		ElementDynamique temp;

		while (i < UpTable.size() - 1) {
			pmin = i;
			j = i + 1;
			while (j < UpTable.size()) {
				if (UpTable.get(j).isSuperior(UpTable.get(pmin))) {
					pmin = j;
				}
				j++;
			}
			temp = UpTable.set(i, UpTable.get(pmin));
			UpTable.set(pmin, temp);
			i++;
		}
	}

	public void cleanUpTable() {
		int i = 0;
		while (i < UpTable.size()) {
			if ((UpTable.get(i) instanceof Chutable)
					&& !((Chutable) UpTable.get(i)).instable()) {
				UpTable.remove(i);
			} else {
				i++;
			}
		}
	}

	public void remUptable(Case C) {
		UpTable.remove(C);
	}

	public ElementDynamique[] getUpTable() {
		return (ElementDynamique[]) UpTable.toArray();
	}

	//
	//
	//
	//
	//
	//
	//

	public boolean isFini() {
		return fini;
	}

	public void setFini() {
		fini = true;
	}

	/**
	 * 
	 */
	public void AddDscore() {
		dscore--;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getDscore() {
		return dscore;
	}

	/**
	 * @param string
	 */
	public void exporter(String niveau) {
		Writer writer = null;
		try {
			int x, y;

			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("niveaux/"
							+ niveau + ".csv"), "utf-8"));

			writer.write("LEVEL," + longueur + "," + hauteur + "\n");

			for (y = 0; y < hauteur; y++) {
				for (x = 0; x < longueur; x++) {
					writer.write(getCase(x, y).ID() + ",");
				}
				writer.write("\n");
			}
			writer.write("DIAMOND," + dscore);
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importer(String niveau) {
		String ligne = "";
		String separateur = ",";
		BufferedReader br = null;

		try {
			int x, y;
			br = new BufferedReader(new FileReader(niveau));

			if ((ligne = br.readLine()) != null) {
				String[] propriete = ligne.split(separateur);

				longueur = Integer.parseInt(propriete[1]);
				hauteur = Integer.parseInt(propriete[2]);

				tableau = new Case[longueur][hauteur];

				for (y = 0; y < hauteur; y++) {
					ligne = br.readLine();
					String[] cases = ligne.split(separateur);

					for (x = 0; x < longueur; x++) {
						switch (cases[x]) {
						case "M":
							insereMurIndestructible(x, y);
							break;
						case "N":
							insereMurNormal(x, y);
							break;
						case "P":
							inserePersonage(x, y);
							break;
						case "S":
							insereSortie(x, y);
							break;
						case "B":
							insereBoue(x, y);
							break;
						case "D":
							insereDiamant(x, y);
							break;
						case "R":
							insereRocher(x, y);
							break;
						case "X":
							insereMurMagique(x, y);
							break;
						case "E":
							inserePapillon(x, y);
							break;
						default:
							insereVide(x, y);
							break;
						}
					}
				}

				ligne = br.readLine();
				propriete = ligne.split(separateur);
				dscore = Integer.parseInt(propriete[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("niveau importé");
	}

	@Override
	public void refreshAnim() {
		perso.refreshAnim();
		TableAnimation.refreshAnim();
	}

}
