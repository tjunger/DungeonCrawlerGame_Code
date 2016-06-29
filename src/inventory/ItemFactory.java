// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

public class ItemFactory
{
	public Item createPotion(String item_name)
	{
		Item item = null;
		if(item_name.equals("Damage Potion"))
		{
			item = new ItemDamagePotion();
		}
		return item;
	}
	
	public Item createWeapon(String item_name)
	{
		Item item = null;
		if (item_name.equals("Unfair Staff"))
		{
			item = new ItemUnfairStaff();
		}
		else if (item_name.equals("Iron Sword"))
		{
			item = new ItemIronSword();
		}
		else if (item_name.equals("Crossbow"))
		{
			item = new ItemCrossBow();
		}
		else if (item_name.equals("Mace"))
		{
			item = new ItemMace();
		}
		return item;
	}
	
	public Item createArmor(String item_name)
	{
		Item item = null;
		if (item_name.equals("Iron Armor"))
		{
			item = new ItemIronArmor();
		}
		else if (item_name.equals("Chainmail"))
		{
			item = new ItemChainArmor();
		}
		else if (item_name.equals("Leather Armor"))
		{
			item = new ItemLeatherArmor();
		}
		return item;
	}
}
