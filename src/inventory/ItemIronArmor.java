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

public class ItemIronArmor extends ItemArmor
{
	public ItemIronArmor()
	{
		super(1, "Iron Armor", "Iron_Armor.jpg", 10, 4);
	}
	
	
	public String performDefense(GoodGuy defender, Enemy attacker, int hitPoints)
	{
		String defend;
		if(this.durability >=1)
		{
			defend = defender.getName() + " is wearing Iron Armor, all attacks will be reduced by a factor of "
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
