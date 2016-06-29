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

import Group.HeroGroup;

public class GameStateManager {
	private GameState startMenuState;
	private GameState charSelectMenuState;
	private GameState playGameState;
	private GameState attackState;
	private GameState gameOverState;
	private GameState currentState;
	private GamePanel panel;
	private HeroGroup group;
	private Group.EnemyGroup enemyGroup;
	private Map gameMap;
	
	public GameStateManager (GamePanel panel){
		this.panel = panel;
		this.startMenuState = new StartMenuState(this);
		this.charSelectMenuState = new CharSelectMenuState(this);
		this.playGameState = new PlayGameState(this);
		this.attackState = new AttackState(this);
		this.gameOverState = new GameOverState(this);
		this.currentState = startMenuState;
		this.enemyGroup = null;
		group = new HeroGroup(0,0);
		this.currentState.init();
	}
	
	public HeroGroup getGroup() {
		return group;
	}

	public void setEnemyGroup(Group.EnemyGroup enemyGroup)
	{
		this.enemyGroup = enemyGroup;
	}
	
	public Group.EnemyGroup getEnemyGroup()
	{
		return this.enemyGroup;
	}
	public GamePanel getPanel() {
		return panel;
	}
	
	public GameState getStartMenuState() {
		return startMenuState;
	}
	
	public GameState getCharSelectMenuState() {
		return charSelectMenuState;
	}
	
	public GameState getPlayGameState() {
		return playGameState;
	}
	
	public GameState getAttackState() {
		return attackState;
	}
	
	public GameState getGameOverState() {
		return gameOverState;
	}
	
	public GameState getCurrentState() {
		return currentState;
	}
	
	public void setGameState(GameState state){
		currentState = state;
		this.currentState.init();
	}
	
	public BufferedImage draw() {
		return currentState.draw();
	}

	public void update() {
		currentState.update();
		
	}

	public void getReturnState() {
		currentState = playGameState;
	}

	public Map getGameMap() {
		return gameMap;
	}

	public void setGameMap(Map gameMap) {
		this.gameMap = gameMap;
	}
	
}
