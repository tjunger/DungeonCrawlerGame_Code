// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartMenuState implements GameState, ActionListener {
	private BufferedImage startMenu[];
	private BufferedImage curFrame;
	private GameStateManager dndGameStateManager;
	private int cycle;
	private JButton next;
	
	public StartMenuState(GameStateManager dndGameStateManager){
		this.dndGameStateManager = dndGameStateManager;
		
	}

	public void init() {
		try {
			cycle = 0;
			startMenu = new BufferedImage[5];
			startMenu[0] = ImageIO.read(new File("MenuDnD.jpg"));
			startMenu[1] = ImageIO.read(new File("MenuDnD_2.jpg"));
			startMenu[2] = ImageIO.read(new File("MenuDnD_3.jpg"));
			startMenu[3] = startMenu[1];
			startMenu[4] = startMenu[0];
			Icon startGame = new ImageIcon("StartMenuButtonIcon.jpg");
			next = new JButton(startGame);
			next.setBounds(560, 370, 160, 30);
			dndGameStateManager.getPanel().add(next);
			next.addActionListener(this);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	public BufferedImage draw() {
		menuAnimation();
		return curFrame;
		
		
	}

	
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}
	private void menuAnimation(){
		if(cycle < 35){
			int slow = cycle/7;
			curFrame = startMenu[slow];
			cycle++;
		}
		else {
			cycle = 0;
			curFrame = startMenu[cycle];
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		dndGameStateManager.getPanel().removeAll();
		dndGameStateManager.setGameState(dndGameStateManager.getCharSelectMenuState());
	}

}
