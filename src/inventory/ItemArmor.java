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

public abstract class ItemArmor extends Item implements DefendBehavior
{

	private GoodGuy user;
	protected DefendBehavior origional;
	protected int durability;
	protected int damageReduction;
	
	public ItemArmor(int amount, String itemName, String filename, int durability, int  reduction)
	{
		super(amount, itemName, filename);
		
		this.durability = durability;
		this.damageReduction = reduction;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public void subtractDurability() {
		this.durability--;
		if(this.durability <=0)
		{
			this.user.setDefence(origional);
			this.user.setWeapon(false);
		}
	}

	public void useItem(GoodGuy user) {
		if(user.hasArmor())
		{
			System.out.println("You can only have one kind of armor at a time");
			return;
		}
		if (this.quantity >= 1)
		{
			this.user = user;
			this.origional = user.getDefense();
			user.setDefence(this);
			user.setArmor(true);
			this.quantity--;
		}
	}

}