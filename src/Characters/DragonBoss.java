// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class DragonBoss extends Enemy
{
	private static final int STARTING_HEALTH = 350;
	private static DragonBoss dragon = null;
	
	private DragonBoss(String name, String type, String portraitFilename,
			AttackBehavior attack, DefendBehavior defend)
	{
		super(name, type, portraitFilename, STARTING_HEALTH, attack, defend);
	}
	
	public static Enemy createCharacter(AttackBehavior special, DefendBehavior defend, String name, String type, String filename)
	{
		if(dragon == null)
		{
			dragon = new DragonBoss(name, type, filename, special, defend);
		}
		return dragon;
	}
}
