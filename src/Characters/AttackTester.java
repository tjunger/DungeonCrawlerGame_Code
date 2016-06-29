// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

import inventory.*;

public class AttackTester
{
	public static void main(String[] args)
	{
		GoodGuyFactory characterCreator = new GoodGuyFactory();
		EnemyFactory enemies = new EnemyFactory();
		
		GoodGuy elf = characterCreator.createGoodGuy("ElfArcher", "Ben");
		Enemy goblin = enemies.createEnemy("Goblin", "Fang");
		Item sword = new ItemIronSword();
		Item staff = new ItemUnfairStaff();
		System.out.println(elf);
		System.out.println(goblin);
		elf.useItem(sword);
		elf.useItem(staff);
		elf.useSpecialAttack(goblin);
		System.out.println(goblin);
		elf.useSpecialAttack(goblin);
		System.out.println(goblin);
		elf.useSpecialAttack(goblin);
		System.out.println(goblin);
		elf.useSpecialAttack(goblin);
		System.out.println(goblin);
		Item armor = new ItemIronArmor();
		armor.useItem(elf);
		goblin.useAttack(elf);
		System.out.println(elf);
		goblin.useAttack(elf);
		System.out.println(elf);
		goblin.useAttack(elf);
		System.out.println(elf);
		
//		System.out.println();
//		
//		GoodGuy wizard = characterCreator.createGoodGuy("Wizard", "Gandalf");
//		Enemy ogre = enemies.createEnemy("Ogre", "Shrek");
//		System.out.println(wizard);
//		System.out.println(ogre);
//		wizard.useAttack(ogre);
//		System.out.println(ogre);
//		wizard.useSpecialAttack(ogre);
//		System.out.println(ogre);
//		ogre.useAttack(wizard);
//		System.out.println(wizard);
//		
//		System.out.println();
//		
//		GoodGuy man = characterCreator.createGoodGuy("MightyMan", "Henry");
//		Enemy skeleton = enemies.createEnemy("Skeleton", "Rattles");
//		System.out.println(man);
//		System.out.println(skeleton);
//		man.useAttack(skeleton);
//		System.out.println(skeleton);
//		man.useSpecialAttack(skeleton);
//		System.out.println(skeleton);
//		System.out.println(man);
//		goblin.useAttack(man);
//		System.out.println(man);
	}
}
