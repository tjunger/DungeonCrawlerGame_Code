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

public abstract class ItemWeapon extends Item implements AttackBehavior
{

	private GoodGuy user;
	protected AttackBehavior origional;
	protected int durability;
	protected int damage;
	

	public ItemWeapon(int amount, String itemName, String fileName, int durability, int damage) {
		super(amount, itemName, fileName);
		
		this.damage = damage;
		this.durability = durability;
	}
	


	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public void useItem(GoodGuy user) {
		if(user.hasWeapon())
		{
			System.out.println("You can only have one weapon at a time");
			return;
		}
		if (this.quantity >= 1)
		{
			this.user = user;
			this.origional = user.getSpecialAttack();
			user.setSpecialAttack(this);
			user.setWeapon(true);
			this.quantity--;
		}
	}

	protected void subtractDuriblity() {
		this.durability--;
		if(this.durability <=0)
		{
			this.user.setSpecialAttack(origional);
			this.user.setWeapon(false);
		}
	}

}