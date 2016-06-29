// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TileImageImporter {
	private ArrayList <BufferedImage> tileImages;
	
	public TileImageImporter() throws IOException{
		this.tileImages = new ArrayList <BufferedImage>();
		
			this.tileImages.add(0, ImageIO.read(new File("UnblockedTile.jpg")));
			this.tileImages.add(1, ImageIO.read(new File("TWall.jpg")));
			this.tileImages.add(2, ImageIO.read(new File("RWall.jpg")));
			this.tileImages.add(3, ImageIO.read(new File("BWall.jpg")));
			this.tileImages.add(4, ImageIO.read(new File("LWall.jpg")));
			this.tileImages.add(5, ImageIO.read(new File("TLCorner.jpg")));
			this.tileImages.add(6, ImageIO.read(new File("TRCorner.jpg")));
			this.tileImages.add(7, ImageIO.read(new File("BRCorner.jpg")));
			this.tileImages.add(8, ImageIO.read(new File("BLCorner.jpg")));
			this.tileImages.add(9, ImageIO.read(new File("ChestTile.jpg")));
			this.tileImages.add(10, ImageIO.read(new File("HeroTile.jpg")));
			this.tileImages.add(11, ImageIO.read(new File("EnemyTile.jpg")));
			this.tileImages.add(12, ImageIO.read(new File("ExitTile.jpg")));
	}

	public ArrayList<BufferedImage> getTileImages() {
		return tileImages;
	}
	
	
}
