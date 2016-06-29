// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Characters;

public interface AttackBehavior
{
	String performAttack(GoodGuy hero, Enemy enemy);
	String getName();
}
