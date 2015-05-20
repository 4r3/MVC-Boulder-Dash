package Modele.Cases;

public class Personage extends ElementDynamique
{
	public Personage(int pos_x, int pos_y)
	{
		super(pos_x, pos_y);
	}

	@Override
	public void refresh()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public String ID()
	{
		return "P";
	}

}
