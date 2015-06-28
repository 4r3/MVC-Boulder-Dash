package BoulderDash.Modele;

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

import BoulderDash.Modele.Animation.TableAnimation;
import BoulderDash.Modele.Cases.Boue;
import BoulderDash.Modele.Cases.Case;
import BoulderDash.Modele.Cases.Chutable;
import BoulderDash.Modele.Cases.Diamant;
import BoulderDash.Modele.Cases.MurIndestructible;
import BoulderDash.Modele.Cases.MurMagique;
import BoulderDash.Modele.Cases.MurNormal;
import BoulderDash.Modele.Cases.Papillon;
import BoulderDash.Modele.Cases.Personnage;
import BoulderDash.Modele.Cases.Rocher;
import BoulderDash.Modele.Cases.Sortie;
import BoulderDash.Modele.Cases.Vide;

/**
 * Classe de niveau, décrit un niveau complet, le niveau est constitué d'un
 * tableau bidimentionel de Cases, d'une table de rafraîchissement
 * 
 * @see Case
 * 
 */
public class Niveau {
	// Variables
	private int hauteur;
	private int longueur;
	private int dscore;
	private int score;
	private float tmax;
	private boolean fini;
	private Personnage perso;
	private Sortie sortie;

	/**
	 * tableau de Cases du niveau
	 */
	private Case[][] tableau;

	/**
	 * tableau de mise à jour, contient les Cases susceptibles d'être modifiées
	 * au prochain cycle
	 */
	private List<Case> UpTable;

	/**
	 * crée un Niveau de 60*40 avec le personnage en haut à gauche et la sortie
	 * en bas à droite
	 * 
	 */
	public Niveau() {
		this(60, 40);
	}

	/**
	 * crée un nouveau niveau à partir d'un niveau sauvegardé
	 */
	public Niveau(String path) {
		UpTable = new ArrayList<>();
		fini = false;
		score = 0;
		importer(path);
	}

	/**
	 * crée un niveau de l*h rempli de boue et avec une bordure de
	 * MurIndestructible
	 * 
	 * 
	 * @param l
	 *            longueur du niveau
	 * @param h
	 *            hauteur du niveau
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
	 * insère le personnage dans le niveau à la position indiquée en argument ;
	 * si un personnage est déja present alors il est échangé avec sa nouvelle
	 * position
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
				tableau[x][y] = perso;
			} else {
				echangeCases(perso.getX(), perso.getY(), x, y);
			}

		}
	}

	/**
	 * insère la sortie du niveau à la position indiquée en argument ; si elle
	 * existe déja, elle est transférée à la nouvelle position
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
	 * insère un MurNormal à la position indiquée en argument
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
	 * insère du Vide à la position indiquée en argument
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
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

	/**
	 * insère de la Boue à la position indiquée en argument
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public void insereBoue(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Boue(x, y);
		}
	}

	/**
	 * insère un MurIndestructible à la position indiquée en argument
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public void insereMurIndestructible(int x, int y) {
		if (x >= 0
				&& x < longueur
				&& y >= 0
				&& y < hauteur
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new MurIndestructible(x, y);
		}
	}

	/**
	 * insère un Rocher à la position indiquée en argument et le rajoute dans la
	 * UpTable
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public void insereRocher(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Rocher(x, y);
			UpTable.add(tableau[x][y]);
		}
	}

	/**
	 * insère un diamant à la position indiquée en argument et le rajoute dans
	 * la UpTable
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public void insereDiamant(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Diamant(x, y);
			UpTable.add(tableau[x][y]);
		}
	}

	/**
	 * insère un MurMagique à la position indiquée en argument
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public void insereMurMagique(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new MurMagique(x, y);
		}
	}

	/**
	 * insère un Papillon à la position indiquée en argument et le rajoute dans
	 * la UpTable
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public void inserePapillon(int x, int y) {
		if (x > 0
				&& x < longueur - 1
				&& y > 0
				&& y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso && tableau[x][y] != sortie))) {
			tableau[x][y] = new Papillon(x, y);
			UpTable.add(tableau[x][y]);
		}
	}

	/**
	 * fonction de mise à jour du niveau, met a jour toutes les Cases
	 * susceptibles d'être mises à jour dans le niveau, ouvre la sortie si les
	 * conditions sont remplies
	 */
	public void refresh() {
		tmax = tmax - Variables.CYCLES * Variables.FRAME / (float) 1000;
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
	 * affiche le niveau en mode texte, à utiliser pour le débuggage
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

	/**
	 * récupère le personnage
	 */
	public Personnage getPerso() {
		return perso;
	}

	/**
	 * récupère la sortie
	 */
	public Sortie getSortie() {
		return sortie;
	}

	/**
	 * échange les deux cases aux positions qui sont transmises en paramètres
	 */
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

	/**
	 * ajoute dans la table de mise à jour la case dont la position est
	 * transmise
	 * 
	 * @param x
	 * @param y
	 */
	public void addUptable(int x, int y) {
		if (!UpTable.contains(tableau[x][y]) && tableau[x][y] != perso
				&& tableau[x][y] != sortie) {
			UpTable.add(UpTable.size(), tableau[x][y]);
		}
	}

	/**
	 * 
	 * ajoute dans la table de mise à jour les cases dans le rectangle de 2*3 au
	 * dessus de la position transmise
	 */
	public void remplirUpTable(int x, int y) {
		addUptable(x, y - 1);
		addUptable(x + 1, y - 1);
		addUptable(x - 1, y - 1);
		addUptable(x + 1, y);
		addUptable(x - 1, y);
	}

	/**
	 * trie la table de mise à jour, les cases les plus basses sont prioritaires
	 * par rapport aux plus élevées
	 */
	public void trieUpTable() {
		int i = 0;
		int j, pmin;
		Case temp;

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

	/**
	 * vide la table de mise à jour des éléments qui ne bougent pas ou qui ne
	 * risquent pas de bouger
	 */
	public void cleanUpTable() {
		int i = 0;
		while (i < UpTable.size()) {
			if ((UpTable.get(i).stayInUpTable())
					&& !((Chutable) UpTable.get(i)).instable()) {
				UpTable.remove(i);
			} else {
				i++;
			}
		}
	}

	/**
	 * supprime de la table de mise à jour la case passée en paramètre
	 */
	public void remUptable(Case C) {
		UpTable.remove(C);
	}

	/**
	 * récupère la table de mise à jour dans un tableau
	 */
	public Case[] getUpTable() {
		return (Case[]) UpTable.toArray();
	}

	//
	//
	//
	//
	//
	//
	//

	/**
	 * récupère si le niveau est fini
	 */
	public boolean isFini() {
		return fini;
	}

	/**
	 * met le niveau à l'état fini
	 */
	public void setFini() {
		fini = true;
	}

	/**
	 * décrémente le nombre de diamants à trouver
	 */
	public void AddDscore() {
		dscore--;
	}

	/**
	 * 
	 * récupère la hauteur du niveau
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * défini la hauteur du niveau
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * récupère la longueur du niveau
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * définit la longueur du niveau
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/**
	 * définit le nombre de diamants nécessaires pour finir le niveau
	 */
	public void setDscore(int dscore) {
		this.dscore = dscore;
	}

	/**
	 * récupère le nombre de diamants nécessaires pour finir le niveau, retourne
	 * 0 si négatif
	 */
	public int getDscore() {
		if (dscore < 0) {
			return 0;
		}
		return dscore;
	}

	/**
	 * 
	 * exporte le niveau sous la forme d'un fichier csv, le nom du niveau est
	 * transmis en paramètre
	 */
	@SuppressWarnings("resource")
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
			writer.write("DIAMOND," + dscore + "\n");
			writer.write("TIME," + (int) tmax + "\n");
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * importe le niveau en csv qui se situe au chemin indiqué
	 */
	@SuppressWarnings("resource")
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
				try {
					ligne = br.readLine();
					propriete = ligne.split(separateur);
					dscore = Integer.parseInt(propriete[1]);
				} catch (NullPointerException e) {
					dscore = 0;
				}
				try {
					ligne = br.readLine();
					propriete = ligne.split(separateur);
					tmax = Float.parseFloat(propriete[1]);
				} catch (NullPointerException e) {
					tmax = 120;
				}
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
	}

	/**
	 * met jour la table d'animation ainsi que le type d'animation du personnage
	 */
	public void refreshAnim() {
		perso.refreshAnim();
		TableAnimation.refreshAnim();
	}

	/**
	 * récupère le temps bonus restant du joueur, retourne 0 si négatif
	 */
	public int getTmax() {
		if (tmax < 0) {
			return 0;
		}
		return (int) tmax;
	}

	/**
	 * défini le temps bonus du niveau
	 */
	public void setTmax(int tmax) {
		this.tmax = tmax;
	}

	/**
	 * ajoute la valeur transmise en paramètre au score
	 */
	public void addToScore(int value) {
		score += value;
	}

	/**
	 * récupère le score du niveau
	 */
	public int getScore() {
		return score;
	}

}
