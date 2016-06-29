// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public class ElfArcher extends GoodGuy
{
	private static ElfArcher elf = null;
	private static final int STARTING_HEALTH = 200;
	
	private ElfArcher(String name, String type, String portrait, AttackBehavior special,
						DefendBehavior defend, AttackBehavior attack)
	{
		super(name, type, portrait, STARTING_HEALTH, special, defend, attack);
	}
	
	public static GoodGuy createCharacter(String name, String type, String portrait, AttackBehavior special,
			DefendBehavior defend, AttackBehavior attack)
	{
		if(elf == null)
		{
			elf = new ElfArcher(name, type, portrait, special, defend, attack);
		}
		return elf;
	}

}
