// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class MightyAttack implements AttackBehavior
{
	private final int DAMAGE = 20;
	
	public String performAttack(GoodGuy attacker, Enemy defender)
	{
		String description = attacker.getName() + " causes a Mighty Blow against " + defender.getName() +
								" for " + DAMAGE + " hit points.\n";
		String defendString = defender.useDefense(attacker, defender, DAMAGE);
		return description + defendString;
	}
	
	public String getName()
	{
		return "Mighty Blow";
	}
}
