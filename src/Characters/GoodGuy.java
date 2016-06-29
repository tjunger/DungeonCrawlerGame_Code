// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

import inventory.Item;

public abstract class GoodGuy extends DungeonCharacter
{
	private int hitPointsGainPerLevel;
	private AttackBehavior specialAttack;
	private boolean hasWeapon;
	private boolean hasArmor;
	private int level;

	public GoodGuy(String name, String type, String portrait, int health, AttackBehavior specialAttack,
					DefendBehavior defend, AttackBehavior attack)
	{
		this.name = name;
		this.characterType = type;
		this.portraitFilename = portrait;
		this.maxHitPoints = health;
		this.hitPoints = health;
		this.attack = attack;
		this.specialAttack = specialAttack;
		this.defend = defend;
		this.hasWeapon = false;
		this.hitPointsGainPerLevel = 25;
		this.level = 1;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public void levelUp()
	{
		this.level++; // increase level
		this.setMaxHitPoints(this.getMaxHitPoints() + this.getHitPointsGainPerLevel()); // increase max hit points
		this.healToFull(); // heal character to new max hit points value
	}
	
	public int getHitPointsGainPerLevel()
	{
		return this.hitPointsGainPerLevel;
	}
	
	public void setHitPointsGainPerLevel(int health)
	{
		this.hitPointsGainPerLevel = health;
	}
	
	public void setWeapon(boolean equiped)
	{
		this.hasWeapon = equiped;
	}
	
	public boolean hasWeapon()
	{
		return this.hasWeapon;
	}
	
	public void setArmor(boolean equiped)
	{
		this.hasArmor = equiped;
	}
	
	public boolean hasArmor()
	{
		return this.hasArmor;
	}

	public void setSpecialAttack(AttackBehavior newAttack)
	{
		this.specialAttack  = newAttack;
	}
	
	public String getSpecialAttackName()
	{
		return this.specialAttack.getName();
	}
	
	public AttackBehavior getSpecialAttack()
	{
		return this.specialAttack;
	}

	public void useItem(Item tool)
	{
		tool.useItem(this);
	}

	public String useAttack(Enemy badGuy)
	{
		return this.attack.performAttack(this, badGuy);
	}
	
	public String useSpecialAttack(Enemy badGuy)
	{
		return this.specialAttack.performAttack(this, badGuy);
	}
	
	public String useDefense(GoodGuy hero, Enemy enemy, int hitPoints)
	{
		return this.defend.performDefense(hero, enemy, hitPoints);
	}

	public void healToFull()
	{
		// used to heal injuries from a previous battle
		this.setHitPoints(this.getMaxHitPoints());
	}
}
