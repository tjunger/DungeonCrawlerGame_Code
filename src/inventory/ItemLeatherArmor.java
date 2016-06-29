// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

import Characters.*;

public class ItemLeatherArmor extends ItemArmor
{
	public ItemLeatherArmor()
	{
		super(1, "Leather Armor", "leatherArmor.jpg", 6, 2);
	}
	
	
	public String performDefense(GoodGuy defender, Enemy attacker, int hitPoints)
	{
		String defend;
		if(this.durability >=1)
		{
			defend = defender.getName() + " is wearing Leather Armor, all attacks will be reduced by a factor of "
								+ this.damageReduction + ".\n";
			int reducedHitpoints = hitPoints/this.damageReduction;
			String characterDefend = this.origional.performDefense(defender, attacker, reducedHitpoints);
			this.subtractDurability();
			return defend + " " + characterDefend;
		}
		defend = this.name + " has been exausted";
		return defend;
	}
}
