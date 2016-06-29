// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

import java.util.Random;

public class RandomItems
{
	private ItemFactory items = new ItemFactory();
	private Random randomGenerator = new Random();
	
	
	public Item generatePotion()
	{
		Item item = null;
		item = items.createPotion("Damage Potion");
		return item;
	}
	
	public Item generateArmor()
	{
		Item item = null;
		int itemNum = randomGenerator.nextInt(3) + 1;
		if(itemNum == 1)
		{
			item = items.createArmor("Leather Armor");
		}
		else if(itemNum == 2)
		{
			item = items.createArmor("Chainmail");
		}
		else if(itemNum == 3)
		{
			item = items.createArmor("Iron Armor");
		}
		return item;
	}
	
	public Item generateWeapon()
	{
		Item item = null;
		int itemNum = randomGenerator.nextInt(4) + 1;
		if(itemNum == 1)
		{
			item = items.createWeapon("Unfair Staff");
		}
		else if(itemNum == 2)
		{
			item = items.createWeapon("Iron Sword");
		}
		else if(itemNum == 3)
		{
			item = items.createWeapon("Crossbow");
		}
		else if(itemNum == 4)
		{
			item = items.createWeapon("Mace");
		}
		return item;
	}
}
