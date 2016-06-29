// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class Wizard extends GoodGuy
{
	private static Wizard wizard = null;
	private static final int STARTING_HEALTH = 150;
	
	private Wizard(String name, String type, String portrait, AttackBehavior special,
					DefendBehavior defend, AttackBehavior attack)
	{
		super(name, type, portrait, STARTING_HEALTH, special, defend, attack);
	}

	public static GoodGuy createCharacter(String name, String type, String portrait, AttackBehavior special,
											DefendBehavior defend, AttackBehavior attack)
	{
		if(wizard == null)
		{
			wizard = new Wizard(name, type, portrait, special, defend, attack);
		}
		return wizard;
	}

}
