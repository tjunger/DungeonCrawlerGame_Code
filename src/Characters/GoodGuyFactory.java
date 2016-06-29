// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class GoodGuyFactory {

	public GoodGuy createGoodGuy(String type, String name)
	{
		AttackDefendFactory factory = new AttackDefendFactory();
		GoodGuy newCharacter = null;
		AttackBehavior specialAttack = factory.createAttack(type);
		AttackBehavior standard = new StandardAttack();
		DefendBehavior defend = factory.createDefend(type);
		String portrait = null;
		if(type.equals("ElfArcher"))
		{
			portrait = "ElfArcherPortrait.jpg";
			newCharacter = ElfArcher.createCharacter(name, type, portrait, specialAttack, defend, standard);
		}
		else if(type.equals("Wizard"))
		{
			portrait = "WizardPortrait.jpg";
			newCharacter = Wizard.createCharacter(name, type, portrait, specialAttack, defend, standard);
		}
		else if(type.equals("MightyMan"))
		{
			portrait = "MightyManPortrait.jpg";
			newCharacter = MightyMan.createCharacter(name, type, portrait, specialAttack, defend, standard);
		}
		else if (type.equals("NullGoodGuy"))
		{
			portrait = "NullGoodGuyPortrait.jpg";
			newCharacter = new NullGoodGuy(name, type, portrait, null, null, null);
		}
		return newCharacter;	
	}

}
