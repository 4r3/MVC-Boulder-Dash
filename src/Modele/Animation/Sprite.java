package Modele.Animation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Modele.Variables;

public class Sprite
{

	private String srcImage;
	private BufferedImage spriteSheet;

	public Sprite(String src)
	{
		this.srcImage = src;
	}

	public static BufferedImage loadSprite(String file)
	{

		BufferedImage sprite = null;

		try {
			sprite = ImageIO.read(new File("sprites/" + file + ".png"));
		} catch ( IOException e ) {
			e.printStackTrace();
		}

		return sprite;
	}

	public BufferedImage getSprite(int xGrid, int yGrid)
	{

		if ( spriteSheet == null ) {
			spriteSheet = loadSprite(this.srcImage);
		}

		return spriteSheet.getSubimage(xGrid * Variables.TAILLE_CASE, yGrid * Variables.TAILLE_CASE, Variables.TAILLE_CASE, Variables.TAILLE_CASE);
	}

}
