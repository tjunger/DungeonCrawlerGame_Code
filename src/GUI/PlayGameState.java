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

import java.awt.image.BufferedImage;

public class PlayGameState implements GameState {
	private GameStateManager dndGameStateManager;
	private Map gameMap;
	private BufferedImage curFrame;
	private int locX;
	private int locY;
	private InventoryPanel invPanel;
	private boolean returned;
	
	public PlayGameState(GameStateManager dndGameStateManager){
		this.dndGameStateManager = dndGameStateManager;
		try{
			this.gameMap = new Map();
			this.dndGameStateManager.setGameMap(this.gameMap);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void init() {
		locX = 44;
		locY = 25;
		gameMap.getMapDesign()[locY][locX].setTileType(10);
		invPanel = new InventoryPanel(this.dndGameStateManager);
		invPanel.setFocusable(false);
		this.dndGameStateManager.getPanel().add(invPanel);
		returned = false;
		
	}

	public void update() {
		if (locX == 3 && locY == 4){
			this.dndGameStateManager.getPanel().removeAll();
			this.dndGameStateManager.setGameState(this.dndGameStateManager.getGameOverState());
		}
		if (returned){
			this.dndGameStateManager.getPanel().add(invPanel);
			returned = false;
		}
		try {
			this.curFrame = gameMap.MapImageCreator(locX, locY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Keys.isDown(Keys.LEFT) && gameMap.getMapDesign()[locY][locX - 1].isPassable()){
			gameMap.getMapDesign()[locY][locX - 1].setTileType(10);
			gameMap.getMapDesign()[locY][locX].setTileType(0);
			locX--;
		}
		if (Keys.isDown(Keys.RIGHT) && gameMap.getMapDesign()[locY][locX + 1].isPassable()){
			gameMap.getMapDesign()[locY][locX + 1].setTileType(10);
			gameMap.getMapDesign()[locY][locX].setTileType(0);
			locX++;
		}
		if (Keys.isDown(Keys.UP) && gameMap.getMapDesign()[locY - 1][locX].isPassable()){
			gameMap.getMapDesign()[locY - 1][locX].setTileType(10);
			gameMap.getMapDesign()[locY][locX].setTileType(0);
			locY--;
		}
		if (Keys.isDown(Keys.DOWN) && gameMap.getMapDesign()[locY + 1][locX].isPassable()){
			gameMap.getMapDesign()[locY + 1][locX].setTileType(10);
			gameMap.getMapDesign()[locY][locX].setTileType(0);
			locY++;
		}
		
		if (gameMap.getMapDesign()[locY][locX].isEnemyLocation()){
			gameMap.getMapDesign()[locY][locX].setEnemyLocation(false);
			this.dndGameStateManager.getPanel().removeAll();
			//////////////////
			// debug: set the current enemy group to the one at this tile
			/////////////////
			dndGameStateManager.setEnemyGroup(gameMap.getMapDesign()[locY][locX].getEnemyGroup());
			returned = true;
			dndGameStateManager.setGameState(dndGameStateManager.getAttackState());
		}
		
		this.dndGameStateManager.getGroup().setGoodGuyLocation(locX, locY);
		if (gameMap.getMapDesign()[locY][locX].isChestLoc()){
			Chest temp = gameMap.getMapDesign()[locY][locX].getChestTile();
			for (int i = 0; i < temp.getChestContents().getSlotsUsed(); i ++){
				if(temp.getChestContents().getItem(i) != null){
					this.dndGameStateManager.getGroup().getHeroInventory().addItem(temp.getChestContents().getItem(i));
				}
			}
		}
		if(invPanel != null){
			this.invPanel.update();
			invPanel.setBounds(0, 0, 200, 740);
		}
		this.dndGameStateManager.getPanel().requestFocusInWindow();
	}


	
	public void handleInput() {
	
		
	}
	
	public BufferedImage draw() {
			
			
			return curFrame;
		
	}

}
