// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapArrayImporter {
	private Tile [][] mapTiles;
	
	private ArrayList<String> tempMapRead;
	
	public MapArrayImporter (String filename, int width, int height){
		try {
			this.tempMapRead = fileRead(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mapTiles = new Tile [height][width];
		parseInts(this.tempMapRead);
	}
	
	private void parseInts(ArrayList<String> tempMapRead2) {
		
		for (int i = 0; i < tempMapRead2.size(); i++){
			
			String row = tempMapRead.get(i);
			String[] split = row.split(",");
			for (int j = 0; j < split.length; j++){
				mapTiles [i][j] = new Tile (Integer.parseInt(split[j]), j, i);
			}
		}
		
	}
	public Tile[][] getMap() {
		return mapTiles;
	}
	
	public ArrayList<String> fileRead(String name) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String row = null;
        while ((row = bufferedReader.readLine()) != null) {
        	row = row.trim();
        	if(row.length() > 0)
        		lines.add(row); //skip empty lines
        }
        fileReader.close();
		return lines;
	}

}
