// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

import java.util.ArrayList;

public class EncounterFactory
{
	public ArrayList<Enemy> createEncounter(int level)
	{
		EnemyFactory factory = new EnemyFactory();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		if (level == 0)
		{
			enemies.add(factory.createEnemy("Goblin", "Clunny"));
			enemies.add(factory.createEnemy("Goblin", "Gnarltooth"));
			enemies.add(factory.createEnemy("Skeleton", "Orgeye"));
		}
		else if (level == 1)
		{
			enemies.add(factory.createEnemy("Skeleton", "Orgeye"));
			enemies.add(factory.createEnemy("Skeleton", "Sargath"));
			enemies.add(factory.createEnemy("Goblin", "Clunny"));
		}
		else if (level == 2)
		{
			enemies.add(factory.createEnemy("Ogre", "Slagar"));
			enemies.add(factory.createEnemy("Skeleton", "Orgeye"));
			enemies.add(factory.createEnemy("Ogre", "Shrek"));
		}
		else if (level == 9){
			enemies.add(factory.createEnemy("Dragon", "King of the Cave"));
			enemies.add(factory.createEnemy("NullEnemy", "NullEnemy"));
			enemies.add(factory.createEnemy("NullEnemy", "NullEnemy"));
		}
		else
		{
			enemies.add(factory.createEnemy("Goblin", "Clunny"));
			enemies.add(factory.createEnemy("Skeleton", "Orgeye"));
			enemies.add(factory.createEnemy("Ogre", "Slagar"));
		}
		return enemies;
	}
}
