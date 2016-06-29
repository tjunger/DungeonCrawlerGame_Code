// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public abstract class Enemy extends DungeonCharacter
{
	public Enemy(String name, String type, String portrait, int health, AttackBehavior attack, DefendBehavior defend)
	{
		this.name = name;
		this.characterType = type;
		this.portraitFilename = portrait;
		this.hitPoints = health;
		this.attack = attack;
		this.defend = defend;
	}

	public void setAttack(AttackBehavior newAttack)
	{
		this.attack = newAttack;
	}

	public void setDefense(DefendBehavior newDefense)
	{
		this.defend = newDefense;
	}

	public String useAttack(GoodGuy toAttack)
	{
		return this.attack.performAttack(toAttack, this);
	}

	public String useDefense(GoodGuy hero, Enemy enemy, int hitPoints)
	{
		return this.defend.performDefense(hero, enemy, hitPoints);
	}

	public String toString()
	{
		if (this.isDead())
		{
			return "[" + this.name + "] (DEAD)";
		}
		return "[" + this.name + "] the " + this.characterType + " (" + this.hitPoints + " hit points)";
	}

}
