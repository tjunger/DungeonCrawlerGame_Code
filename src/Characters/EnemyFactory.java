// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class EnemyFactory {

	public Enemy createEnemy(String type, String name)
	{
		AttackDefendFactory factory  = new AttackDefendFactory();
		Enemy newEnemy = null;
		AttackBehavior attack = factory.createAttack(type);
		DefendBehavior defend = factory.createDefend(type);
		String portrait = "GoblinPortrait.jpg"; // change to null when everything else is implemented
		if(type.equals("Goblin"))
		{
			portrait = "GoblinPortrait.jpg";
			newEnemy = new Goblin(name, type, portrait, attack, defend);
			
		}
		else if(type.equals("Ogre"))
		{
			portrait = "OgrePortrait.jpg";
			newEnemy = new Ogre(name, type, portrait, attack, defend);
			
		}
		else if(type.equals("Skeleton"))
		{
			portrait = "SkeletonPortrait.jpg";
			newEnemy = new Skeleton(name, type, portrait, attack, defend);
			
		}
		else if(type.equals("Dragon"))
		{
			portrait = "DragonPortrait.jpg";
			newEnemy = DragonBoss.createCharacter(attack, defend, name, type, portrait);
		}
		else if(type.equals("NullEnemy"))
		{
			portrait = "NullEnemyPortrait.jpg";
			attack = null;
			defend = null;
			newEnemy = new NullEnemy(name, type, portrait, attack, defend);
		}
		return newEnemy;
	}
}
