// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
	private Tile [][] mapDesign;
	private ArrayList <BufferedImage> tileImages;
	
	public Map() throws IOException {
		MapArrayImporter mapIn = new MapArrayImporter("src/GUI/Map.txt", 48, 27);
		this.mapDesign = mapIn.getMap();
		TileImageImporter tileIn;
	
			tileIn = new TileImageImporter();
			this.tileImages = tileIn.getTileImages();
		
		
	}
	
	public BufferedImage MapImageCreator(int xLoc, int yLoc){
		BufferedImage mapImage = new BufferedImage(1280, 720, 1);
		int topCornerX = xLoc - 8;
		int rCornerX = topCornerX + 16;
		int topCornerY = yLoc - 4;
		int bottomCornerY = topCornerY + 9;
		int tileX = 0;
		int tileY = 0;
		Graphics g = mapImage.getGraphics();
		for(int i = topCornerY; i < (bottomCornerY); i++){
			for(int j = topCornerX; j < (rCornerX); j++){
				if(i < 27 && j < 48 && i >=0 && j >= 0){
					g.drawImage(this.tileImages.get(this.mapDesign[i][j].getTileType()), (tileX * 80), (tileY * 80), null);
					
				}
				
				tileX++;
			}	
			tileY++;
			tileX = 0;
			
		}
		return mapImage;
	}

	public Tile[][] getMapDesign() {
		return mapDesign;
	}
	
}
