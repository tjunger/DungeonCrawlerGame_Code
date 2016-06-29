// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.awt.image.BufferedImage;

public interface GameState {
	
	public abstract void init();
	public abstract void update();
	public abstract BufferedImage draw();
	public abstract void handleInput();
}
