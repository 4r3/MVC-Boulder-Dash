import javax.swing.JFrame;

import Modele.Niveau;
import Vue.Panel.Fenetre;

public class BoulderDash
{

	public static void main(String[] args)
	{
		Niveau niveau = new Niveau(20, 15, 5, 5, 18, 18);

		niveau.insereDiamant(1, 1);

		niveau.insereRocher(2, 2);

		JFrame fen = new Fenetre(niveau);
		fen.setVisible(true);
		while ( !niveau.isFini() ) {
			niveau.refresh();
			try {
				Thread.sleep(200);
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
}
