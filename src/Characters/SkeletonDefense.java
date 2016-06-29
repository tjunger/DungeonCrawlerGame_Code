// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class SkeletonDefense implements DefendBehavior
{
	public String performDefense(GoodGuy attacker, Enemy defender, int hitPoints)
	{
		String defend;
		if(attacker.getCharacterType().equals("Wizard"))
		{
			defend = defender.getName() + " has Sucessfully defended against " + attacker.getName() + "'s attack.\n";
			return defend;
		}
		defend = defender.getName() + "'s defense has failed.\n";
		defender.subtractHitPoints(hitPoints);
		return defend;
	}
}
