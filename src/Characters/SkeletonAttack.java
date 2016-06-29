// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class SkeletonAttack implements AttackBehavior
{
	private final int DAMAGE = 15;
	
	public String performAttack(GoodGuy defender, Enemy attacker) 
	{
		String description = attacker.getName() + " shoots " + defender.getName() + " with a blood stained arrow for " +
								DAMAGE + " hit points.\n";
		String defendString = defender.useDefense(defender, attacker, DAMAGE);
		return description + defendString;
	}

	public String getName()
	{
		return "Bloody Bow";
	}
}
