// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package inventory;

import java.util.*;

import Characters.GoodGuy;

public class Inventory
{
	private int inventory_size;
	private ArrayList<Item> inventory;
	
	public Inventory()
	{
		this.inventory_size = 10;
		inventory = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		boolean duplicate_item = false;
		if (item == null)
		{
			return;
		}
		if (this.inventory.size() < this.inventory_size)
		{
			for (int i = 0; i < inventory.size() && !duplicate_item; i++)
			{
				if (inventory.get(i).getClass().getSimpleName().equals(item.getClass().getSimpleName()))
				{
					inventory.get(i).setQuantity(inventory.get(i).getQuantity() + item.quantity);
					duplicate_item = true;
				}
			}
			if (!duplicate_item)
			{
				inventory.add(item);
			}
		}
		else
		{
			System.out.println("Inventory was full!");
		}
	}
	
	public void useItem(GoodGuy hero, int index)
	{
		// check if item exists
		if (inventory.get(index) != null)
		{
			inventory.get(index).useItem(hero);
		}
		
		// remove item if quantity is now 0
		if (inventory.get(index).getQuantity() == 0)
		{
			inventory.remove(index);
		}
	}
	
	public int getSlotsUsed()
	{
		return inventory.size();
	}
	
	public String toString()
	{
		String result = "";
		for (int i = 0; i < inventory.size(); i++)
		{
			result += (i + 1) + ". " + inventory.get(i).getName() + "(Qty: " + inventory.get(i).getQuantity() + ")\n";
		}
		return result;
	}
	public Item getItem(int index){
		if (index < inventory.size()){
			return inventory.get(index);
		}
		return null;
	}
	

}
