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

public class ItemUnfairStaff extends ItemWeapon
{
	public ItemUnfairStaff()
	{
		super(1, "Unfair Staff", "staff.jpg", 1, 100);
	}
	
	public String performAttack(GoodGuy hero, Enemy enemy)
	{
		String attack;
		if(this.durability >=1)
		{
			attack = hero.getName() + " will attack " + enemy.getName() + " with the Staff of Death for " + 
					this.damage + " hit points.\n";
			enemy.subtractHitPoints(this.damage);
			String characterAttack = this.origional.performAttack(hero, enemy);
			this.subtractDuriblity();
			return attack + " " + characterAttack;
		}
		attack = this.name + " has been exausted";
		return attack;
	}
	
	public String getName()
	{
		return "Staff of Death";
	}
}
