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
import java.io.File;

import javax.imageio.ImageIO;

public class GameOverState implements GameState {
	
	private GameStateManager dndGameStateManager;
	private BufferedImage curFrame;
	

	public GameOverState(GameStateManager dndGameStateManager){
		this.dndGameStateManager = dndGameStateManager;
		
	}
	
	public void init() {
		try{
			curFrame = ImageIO.read(new File("EndGameImage.jpg"));
		}
		catch(Exception e){
			
		}

	}

	
	public void update() {
		// TODO Auto-generated method stub

	}

	
	public void handleInput() {
		// TODO Auto-generated method stub

	}
	
	public BufferedImage draw() {
		// TODO Auto-generated method stub
		return curFrame;
	}

}
