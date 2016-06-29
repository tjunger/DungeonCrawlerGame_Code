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

public class ItemDamagePotion extends ItemWeapon
{
	public ItemDamagePotion()
	{
		super(1, "Damage Potion", "NullEnemyPortrait.jpg", 1, 20);
	}
	
	
	public String performAttack(GoodGuy hero, Enemy enemy)
	{
		String attack;
		if(this.durability >=1)
		{
			attack = hero.getName() + " will attack " + enemy.getName() + " with the Potion of Death for " + 
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
		return "Potion of Death";
	}
}
