// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class ElfAttack implements AttackBehavior
{
	private final int DAMAGE = 15;
	
	public String performAttack(GoodGuy attacker, Enemy defender)
	{
		String description = attacker.getName() + " shoots " + defender.getName() + " with a magic arrow for " + DAMAGE +
								" hit points.\n";
		String defendString = defender.useDefense(attacker, defender, DAMAGE);
		return description + defendString;
	}
	
	public String getName()
	{
		return "Magic Arrow";
	}
}
