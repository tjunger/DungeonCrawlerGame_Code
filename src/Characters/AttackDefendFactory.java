// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class AttackDefendFactory
{
	public DefendBehavior createDefend(String type)
	{
		DefendBehavior defend = null;
		//For goodguys
		if (type.equals("ElfArcher"))
		{
			defend = new ElfDefense();
		}
		else if(type.equals("Wizard"))
		{
			defend = new WizardDefense();
		}
		else if(type.equals("MightyMan"))
		{
			defend = new MightyDefense();
		}
		//for enemies
		else if(type.equals("Goblin"))
		{
			defend = new GoblinDefense();
		}
		else if(type.equals("Ogre"))
		{
			defend = new OgreDefense();
		}
		else if(type.equals("Skeleton"))
		{
			defend = new SkeletonDefense();
		}
		else if(type.equals("Dragon"))
		{
			defend = new DragonDefense();
		}
		return defend;
	}

	public AttackBehavior createAttack(String type)
	{
		AttackBehavior attack = null;
		if (type.equals("ElfArcher"))
		{
			attack = new ElfAttack();
		}
		else if(type.equals("Wizard"))
		{
			attack = new WizardAttack();
		}
		else if(type.equals("MightyMan"))
		{
			attack = new MightyAttack();
		}
		//for enemies
		else if(type.equals("Goblin"))
		{
			attack = new GoblinAttack();
		}
		else if(type.equals("Ogre"))
		{
			attack = new OgreAttack();
		}
		else if(type.equals("Skeleton"))
		{
			attack = new SkeletonAttack();
		}
		else if(type.equals("Dragon"))
		{
			attack = new DragonAttack();
		}
		return attack;
	}
}
