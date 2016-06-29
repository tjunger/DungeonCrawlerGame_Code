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

public class ItemIronSword extends ItemWeapon
{
	public ItemIronSword()
	{
		super(1, "Iron Sword", "sword.jpg", 10, 10);
	}
	
	
	public String performAttack(GoodGuy hero, Enemy enemy)
	{
		String attack;
		if(this.durability >=1)
		{
			attack = hero.getName() + " will attack " + enemy.getName() + " with an Iron Sword for " + 
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
		return "Iron Sword";
	}
}
