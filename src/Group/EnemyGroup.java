// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Group;

import java.util.ArrayList;

public class EnemyGroup {
	private GroupLocation location;
	private Characters.EncounterFactory encounterFactory;
	//private Characters.Enemy [] enemyGroup;
	private  ArrayList<Characters.Enemy> enemyGroup;
	
	public EnemyGroup(int xloc, int yloc, int level)
	{
		
		//System.out.println("Debug: entered EnemyGroup()");
		this.location = new GroupLocation(xloc, yloc);
		//this.location.setX(xloc);
		//this.location.setY(yloc);
		//System.out.println("Debug: Set coordinates");
		this.encounterFactory = new Characters.EncounterFactory();
		//System.out.println("Debug: Set encounterfactory");
		this.enemyGroup = this.encounterFactory.createEncounter(level);
		//System.out.println("Debug: Set enemygroup");
	}
	
	public void generateEnemyGroup(int i)
	{
		// generates the enemy group using the encounter factory
		this.enemyGroup = this.encounterFactory.createEncounter(i);
	}
	
	public Characters.Enemy getEnemy(int i)
	{
		return enemyGroup.get(i);
	}
	
	public int getEnemyCount()
	{
		return this.enemyGroup.size();
	}
	
}
