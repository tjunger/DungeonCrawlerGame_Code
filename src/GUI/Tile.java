// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import inventory.Chest;
import inventory.ChestFactory;

import java.util.*;

import Group.EnemyGroup;

public class Tile {
	private boolean passable;
	private int tileType;
	private boolean enemyLocation;
	private int xLoc;
	private int yLoc;
	private EnemyGroup enemyGroup;
	private ChestFactory chests;
	private boolean chestLoc;
	private Chest chestTile;
	
	public Tile (int tileType, int xloc, int yloc){
		chests = new ChestFactory();
		this.tileType = tileType;
		if (this.tileType == 0){
			this.passable = true;
			this.xLoc = xloc;
			this.yLoc = yloc;
			this.enemyLocation = randomEnemyLocationGenerator();
		}
		else {
			this.passable = false;
		}
		if (this.xLoc == 3 && this.yLoc == 4){
			this.tileType = 12;
			this.enemyLocation = false;
		}
		if (this.tileType == 9){
			chestLoc = true;
			passable = true;
			this.chestTile = chests.randomChest();
		}
	}

	public boolean isChestLoc() {
		return chestLoc;
	}

	public Chest getChestTile() {
		return chestTile;
	}

	public Group.EnemyGroup getEnemyGroup()
	{
		return this.enemyGroup;
	}
	
	private boolean randomEnemyLocationGenerator() {
		Random rand = new Random();
		int encounter = rand.nextInt(99);
		int enemyLevel = rand.nextInt(5); //to generate a random encounter currently 0 for debug
		if (encounter < 15 && encounter > 9 && (this.xLoc != 44 || this.yLoc != 25)){
			this.enemyGroup = new EnemyGroup(this.xLoc, this.yLoc, enemyLevel);
			return true;
		}
		if(xLoc == 3 && yLoc == 6){
			this.enemyGroup = new EnemyGroup(this.xLoc, this.yLoc, 9);
			return true;
		}

		return false;
	}

	public boolean isPassable() {
		return passable;
	}

	public int getTileType() {
		return tileType;
	}
	
	public void setTileType(int tileType) {
		this.tileType = tileType;
	}
	public boolean isEnemyLocation() {
		return enemyLocation;
	}

	public void setEnemyLocation(boolean b) {
		this.enemyLocation = b;
		
	}
	
}
