// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class MightyMan extends GoodGuy
{
	private static MightyMan man = null;
	private static final int STARTING_HEALTH = 225;
			
	private MightyMan(String name, String type, String portrait, AttackBehavior special,
						DefendBehavior defend, AttackBehavior attack)
	{
		super(name, type, portrait, STARTING_HEALTH, special, defend, attack);
	}

	public static GoodGuy createCharacter(String name, String type, String portrait, AttackBehavior special,
											DefendBehavior defend, AttackBehavior attack)
	{
		if(man == null)
		{
			man = new MightyMan(name, type, portrait, special, defend, attack);
		}
		return man;
	}

}
