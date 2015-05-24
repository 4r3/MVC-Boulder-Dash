/**
 * 
 */
package Modele.Cases;

/**
 * @author 4r3
 *
 */
public class Diamant extends Chutable
{

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Diamant(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
	}

	@Override
	public String ID()
	{
		return "D";
	}

}
