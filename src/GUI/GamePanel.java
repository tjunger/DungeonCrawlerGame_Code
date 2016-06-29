// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

/* Note: Some code in this class is directed inspired by a project on the Internet by neet games. Code was provided as a tutorial on 
 * Java game building, any similarities are based off of using this code as a template. Code was traced line by line for understanding 
 * and updating based on needs, API, and refactoring. 
 *  Tutorial is a neet Games Diamond Hunter. 
*/
package GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener{
	public static final int HEIGHT = 740; 
	public static final int WIDTH = 1280;
	private BufferedImage image;
	
	private GameStateManager dNdGameStateManager;
	private boolean running;
	private final long REFRESH_LOOP = 1000/25;
	private Thread thread;
	
	public GamePanel(){
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();//moves window to center of screen
		
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	public void init(){
		dNdGameStateManager = new GameStateManager(this);
		running = true;
		image = new BufferedImage(WIDTH, HEIGHT, 1);
		
	}
	

	
	public void keyTyped(KeyEvent e) {}

	
	public void keyPressed(KeyEvent e) {
		Keys.keySet(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		Keys.keySet(e.getKeyCode(), false);
		
	}

	
	public void run() {
		init();
		while(running) {	
			update();
			draw();	
			this.repaint();
			try {
				Thread.sleep(REFRESH_LOOP);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void draw() {
		image = dNdGameStateManager.draw();
		
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
	}

	private void update() {
		dNdGameStateManager.update();
		
	}
}
