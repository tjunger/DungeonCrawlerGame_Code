// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

public class Chest
{
	private Inventory chestContents;
	
	public Chest(Inventory items)
	{
		this.chestContents = items;
	}
	
	public void printContents()
	{
		System.out.println(chestContents);
	}
	
	public Inventory getChestContents(){
		return this.chestContents;
	}
}

