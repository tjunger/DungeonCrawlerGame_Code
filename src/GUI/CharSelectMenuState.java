// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class CharSelectMenuState implements GameState, ActionListener {
	private GameStateManager dndGameStateManager;
	private BufferedImage curFrame;
	private int counter;
	private JCheckBox wizard;
	private JCheckBox elf;
	private JCheckBox warrior;
	private JButton next;
	public CharSelectMenuState(GameStateManager dndGameStateManager){
		this.dndGameStateManager = dndGameStateManager;
	}
	
	public void init() {
		try {
			curFrame = ImageIO.read(new File("CharacterSelectMenu.jpg"));
			wizard = new JCheckBox();
			wizard.setBounds(124, 442, 22, 16);
			dndGameStateManager.getPanel().add(wizard);
			elf = new JCheckBox();
			elf.setBounds(626, 442, 22, 16);
			dndGameStateManager.getPanel().add(elf);
			warrior = new JCheckBox();
			warrior.setBounds(1128, 442, 22, 16);
			dndGameStateManager.getPanel().add(warrior);
			Icon startGame = new ImageIcon("StartGameButton.jpg");
			next = new JButton(startGame);
			next.setBounds(1040, 50, 200, 100);
			dndGameStateManager.getPanel().add(next);
			next.addActionListener(this);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}
	
	
	public BufferedImage draw() {
		while (counter < 250){
			counter++;
			return curFrame;
		}
		counter = 0;
		
		
		return curFrame;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (wizard.isSelected()){
			dndGameStateManager.getGroup().addHero("Wizard", "Wizard");
		}
		if (elf.isSelected()){
			dndGameStateManager.getGroup().addHero("ElfArcher", "Elf Archer");
		}
		if (warrior.isSelected()){
			dndGameStateManager.getGroup().addHero("MightyMan", "Warrior");
		}
		if(wizard.isSelected() || elf.isSelected()  || warrior.isSelected()){
			//Clears the frame, and init() the next state
			
			// check party size, add null characters as needed
			
			while (dndGameStateManager.getGroup().getGroupSize() < 3)
			{
				dndGameStateManager.getGroup().addHero("NullGoodGuy", "NullGoodGuy");
			}
			
			dndGameStateManager.getPanel().removeAll();
			dndGameStateManager.setGameState(dndGameStateManager.getPlayGameState());
		}
		else {
			//This stops the User from starting the game without a Hero Party
			JOptionPane.showMessageDialog(dndGameStateManager.getPanel(),
				    "You Didn't Add Any Heros",
				    "Empty Hero Party",
				    JOptionPane.WARNING_MESSAGE);
		}
	
	}

}
