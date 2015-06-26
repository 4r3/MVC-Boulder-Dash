package BoulderDash.Modele;

import java.awt.Color;

public class Variables {

	public static final int HAUTEUR_FRAME = 500;
	public static final int LARGEUR_FRAME = 500;
	public static final int HAUTEUR_PANEL_JEU = 320;
	public static final int LARGEUR_PANEL_JEU = 320;
	public static final int HAUTEUR_PANEL_SCORE = 320;
	public static final int LARGEUR_PANEL_SCORE = 320;
	public static final int HAUTEUR_PANEL_EDITEUR_NIVEAU = 320;
	public static final int LARGEUR_PANEL_EDITEUR_NIVEAU = 320;
	public static final int HAUTEUR_PANEL_MENU_JEU = 400;
	public static final int LARGEUR_PANEL_MENU_JEU = 400;
	public static final int HAUTEUR_PANEL_MENU_EDITEUR = 400;
	public static final int LARGEUR_PANEL_MENU_EDITEUR = 400;

	public static final int TAILLE_CASE = 16;

	public static final int FRAME = 70;
	public static final int CYCLES = 2;
	public static final int DELAI_IDLE = 10;

	public static final int PAS_MVT = TAILLE_CASE / CYCLES;
	public static final int VITESSE_ANIM = 1;
	public static final int VITESSE_PERSO = 1;
	public static final int VITESSE_IDLE = 8;

	public static final Color COULEUR = Color.decode("#03224C");
	public static final Color COULEUR_TEXTE = Color.decode("#FFFFFF");
	public static final String HELP = "Le but du jeu est de ramasser le nombre de diamants spécifié."
			+ "\nVous manipulez Rockford, un mineur. Il peut se déplacer horizontalement et verticalement."
			+ "\nIl peut creuser la terre et ramasser des diamants."
			+ "\nEn creusant, il peut faire tomber des rochers. Si un rocher lui tombe dessus, la partie est perdue."
			+ "\nLes ennemis peuvent aussi le tuer."
			+ "\nFaites tomber un rocher sur un ennemi et vous serez récompensé en points et en diamants."
			+ "\nCertains murs sont spéciaux : ils permettent de transformer les rochers et les diamants."
			+ "\nUne fois tous les diamants récupérés, atteignez la sortie pour terminer le niveau.";

}
