// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class DragonDefense implements DefendBehavior {

	public String performDefense(GoodGuy attacker, Enemy defender, int hitPoints)
	{
		String defend = defender.getName() + " the " + defender.getCharacterType() +
						" posses scales that rival the strongest armor.\n" + 
						"All attacks against him will be reduced by a factor of 2.\n";
		defender.subtractHitPoints(hitPoints/2);
		return defend;
	}

}
