// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {
	public static JPanel gamePanel;
	public static void main(String[] args) {

		JFrame window = new JFrame("DnD");//Makes New Jframe
		gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();//gets preferredSize
		window.setLocationRelativeTo(null);//Centers window
		window.setResizable(false);
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}	
	
}