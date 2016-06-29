// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class GoblinAttack implements AttackBehavior
{
	private final int DAMAGE = 12;
	
	public String performAttack(GoodGuy defender, Enemy attacker)
	{
		String description = attacker.getName() + " attacks " + defender.getName() + " with a rusty dagger for " +
								DAMAGE + " hit points.\n";
		String defendString = defender.useDefense(defender, attacker, DAMAGE);
		return description + defendString;
	}

	public String getName()
	{
		return "Rusty Dagger";
	}
}
