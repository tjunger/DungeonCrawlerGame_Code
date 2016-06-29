// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class MightyDefense implements DefendBehavior
{

	public String performDefense(GoodGuy defender, Enemy attacker, int hitPoints)
	{
		if(attacker.getCharacterType().equals("Goblin"))
		{
			String defend = defender.getName() + " has Sucessfully defended against " + attacker.getName() + "'s attack.\n";
			return defend;
		}
		String noDefend = defender.getName() + "'s defense has failed.\n";
		defender.subtractHitPoints(hitPoints);
		return noDefend;
	}
}
