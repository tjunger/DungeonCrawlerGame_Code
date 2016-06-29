// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class DragonAttack implements AttackBehavior
{
	private final int DAMAGE = 40;

	public String performAttack(GoodGuy defender, Enemy attacker)
	{
		String description =  attacker.getName() + " unleashes his fire breath on " + defender.getName() + " for "
								+ DAMAGE + " hit points\n";
		String defendString = defender.useDefense(defender, attacker, DAMAGE);
		return description + defendString;
	}
	
	public String getName()
	{
		return "Fire Breath";
	}
}
