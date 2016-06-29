// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class NullEnemy extends Enemy
{
	private static final int STARTING_HEALTH = 0;
	
	public NullEnemy(String name, String type, String portrait, AttackBehavior attack, DefendBehavior defend)
	{
		super(name, type, portrait, STARTING_HEALTH, attack, defend);
	}

}
