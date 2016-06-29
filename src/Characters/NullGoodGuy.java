// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class NullGoodGuy extends GoodGuy
{
	private static final int STARTING_HEALTH = 0;
	
	public NullGoodGuy(String name, String type, String portrait, AttackBehavior special,
			DefendBehavior defend, AttackBehavior attack)
	{
		super(name, type, portrait, STARTING_HEALTH, special, defend, attack);
	}
}
