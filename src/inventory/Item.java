// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Characters.GoodGuy;

public abstract class Item
{
	protected int quantity;
	protected String name;
	private Icon itemIcon;
	public Item(int amount, String itemName, String fileName)
	{
		this.quantity = amount;
		this.name = itemName;
		this.itemIcon = new ImageIcon(fileName);
	}
	
	public Icon getItemIcon() {
		return itemIcon;
	}

	public abstract void useItem(GoodGuy user);
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return this.name;
	}
}
