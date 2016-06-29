// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package Group;

import inventory.Inventory;

import java.util.ArrayList;

import Characters.GoodGuy;
import Characters.GoodGuyFactory;

public class HeroGroup {
	private  ArrayList<Characters.GoodGuy> group;
	private GroupLocation curLoc;
	private GoodGuyFactory createGG;
	private Inventory heroInventory;
	public HeroGroup(int x, int y){
		this.curLoc = new GroupLocation(x, y);
		this.createGG = new GoodGuyFactory();
		this.group = new ArrayList<GoodGuy>();
		this.heroInventory = new Inventory();
	}
	public Inventory getHeroInventory() {
		return heroInventory;
	}
	public GoodGuy getHero(int i)
	{
		return group.get(i);
	}
	public void addHero(String type, String name){
		group.add(createGG.createGoodGuy(type, name));
	}
	public int [] getGoodGuyLocation(){
		return (new int[]{curLoc.getX(), curLoc.getY()});
	}
	public void setGoodGuyLocation(int xLoc, int yLoc){
		curLoc.setX(xLoc);
		curLoc.setY(yLoc);
	}
	public int getGroupSize()
	{
		return group.size();
	}
}
