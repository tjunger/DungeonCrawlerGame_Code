// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

public class ChestFactory
{
	private RandomItems randomItem = new RandomItems();
	private Inventory items = new Inventory();
	
	public Chest randomChest()
	{
		Chest theChest;
		items.addItem(randomItem.generateArmor());
		items.addItem(randomItem.generateWeapon());
		items.addItem(randomItem.generateArmor());
		items.addItem(randomItem.generateWeapon());
		theChest = new Chest(items);
		return theChest;
	}
}
