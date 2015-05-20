import Modele.Niveau;

public class BoulderDash
{

	public static void main(String[] args)
	{
		Niveau level = new Niveau();
		level.inserePersonage(1, 2);
		level.insereSortie(8, 8);
		level.affiche();
	}

}
