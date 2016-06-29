// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class DungeonCharacter {

	protected String name;
	protected String characterType;
	protected String portraitFilename;
	protected int maxHitPoints;
	protected int hitPoints;
	protected AttackBehavior attack;
	protected DefendBehavior defend;

	public boolean isDead() {
		return this.hitPoints <= 0;
	}

	public String getName() {
		return this.name;
	}

	public String getCharacterType() {
		return this.characterType;
	}

	public String getPortraitFilename()
	{
		return this.portraitFilename;
	}
	
	public int getMaxHitPoints()
	{
		return this.maxHitPoints;
	}
	
	public void setMaxHitPoints(int health)
	{
		this.maxHitPoints = health;
	}
	
	public int getHitPoints() {
		return this.hitPoints;
	}

	public void setHitPoints(int health) {
		this.hitPoints = health;
	}

	public void subtractHitPoints(int lost) {
		this.hitPoints = this.hitPoints - lost;
		if (this.hitPoints < 0)
		{
			this.hitPoints = 0;
		}
	}

	public void addHitPoints(int gained) {
		if ((this.getHitPoints() + gained) > this.getMaxHitPoints())
		{
			// don't set the hero over it's max hit points
			this.setHitPoints(this.getMaxHitPoints());
		}
		else
		{
			this.hitPoints += gained;
		}
	}

	public String toString() {
		return this.name + " the " + this.characterType + " has " + this.getHitPoints() + " hitpoints remaining";
	}
	
	public void setDefence(DefendBehavior newDefence)
	{
		this.defend = newDefence;
	}
	
	public DefendBehavior getDefense()
	{
		return this.defend;
	}
}