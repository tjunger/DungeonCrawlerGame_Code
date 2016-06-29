// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class StandardAttack implements AttackBehavior
{
	private static final int DAMAGE = 8;
	public String performAttack(GoodGuy attacker, Enemy defender)
	{
		String attack = attacker.getName() + " punches " + defender.getName() + " for " + DAMAGE +
							" hit points.\n";
		defender.subtractHitPoints(DAMAGE);
		return attack;
	}

	public String getName()
	{
		return "Punch";
	}
}
