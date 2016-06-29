// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Font;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class AttackState implements GameState {
	private GameStateManager dndGameStateManager;
	private BufferedImage curFrame;
	private boolean debug_mode = false;
	private int turn;
	private int target;
	private int counter;
	private String move;
	
	// events
	private AttackClickEvent attackClickEvent;
	private SpecialAttackClickEvent specialAttackClickEvent;
	private UsePotionClickEvent usePotionClickEvent;
	private EnemyPortrait0ClickEvent enemyPortrait0ClickEvent;
	private EnemyPortrait1ClickEvent enemyPortrait1ClickEvent;
	private EnemyPortrait2ClickEvent enemyPortrait2ClickEvent;
	private ContinueButtonClickEvent continueButtonClickEvent;
	
	// where the elements should draw
	private final int COL_0_LEFT = 90;
	private final int COL_1_LEFT = 220;
	private final int COL_2_LEFT = 350;
	private final int ROW_0_LEFT = 120;
	private final int ROW_1_LEFT = 240;
	private final int ROW_2_LEFT = 360;
	
	private final int COL_0_RIGHT = 730;
	private final int COL_1_RIGHT = 910;
	private final int COL_2_RIGHT = 1040;
	private final int ROW_0_RIGHT = 120;
	private final int ROW_1_RIGHT = 240;
	private final int ROW_2_RIGHT = 360;
	
	private final int heroNameCoordinates[][] = {{COL_0_LEFT, ROW_0_LEFT}, {COL_0_LEFT, ROW_1_LEFT}, {COL_0_LEFT, ROW_2_LEFT}};
	private final int heroHitPointsCoordinates[][] = {{COL_0_LEFT, ROW_0_LEFT + 30}, {COL_0_LEFT, ROW_1_LEFT + 30}, {COL_0_LEFT, ROW_2_LEFT + 30}};
	private final int heroLevelCoordinates[][] = {{COL_0_LEFT, ROW_0_LEFT + 60}, {COL_0_LEFT, ROW_1_LEFT + 60}, {COL_0_LEFT, ROW_2_LEFT + 60}};
	private final int heroImageCoordinates[][] = {{COL_1_LEFT, ROW_0_LEFT}, {COL_1_LEFT, ROW_1_LEFT}, {COL_1_LEFT, ROW_2_LEFT}};
	private final int heroAttackCoordinates[][] = {{COL_2_LEFT, ROW_0_LEFT}, {COL_2_LEFT, ROW_1_LEFT}, {COL_2_LEFT, ROW_2_LEFT}};
	private final int heroSpecialAttackCoordinates[][] = {{COL_2_LEFT, ROW_0_LEFT + 30}, {COL_2_LEFT, ROW_1_LEFT + 30}, {COL_2_LEFT, ROW_2_LEFT + 30}};
	private final int heroUsePotionCoordinates[][] = {{COL_2_LEFT, ROW_0_LEFT + 60}, {COL_2_LEFT, ROW_1_LEFT + 60}, {COL_2_LEFT, ROW_2_LEFT + 60}};
		
	private final int enemyContinueCoordinates[][] = {{COL_0_RIGHT, ROW_0_RIGHT + 30}, {COL_0_RIGHT, ROW_1_RIGHT + 30}, {COL_0_RIGHT, ROW_2_RIGHT + 30}};
	private final int enemyImageCoordinates[][] = {{COL_1_RIGHT, ROW_0_RIGHT}, {COL_1_RIGHT, ROW_1_RIGHT}, {COL_1_RIGHT, ROW_2_RIGHT}};
	private final int enemyNameCoordinates[][] = {{COL_2_RIGHT, ROW_0_RIGHT}, {COL_2_RIGHT, ROW_1_RIGHT}, {COL_2_RIGHT, ROW_2_RIGHT}};
	private final int enemyHitPointsCoordinates[][] = {{COL_2_RIGHT, ROW_0_RIGHT + 30}, {COL_2_RIGHT, ROW_1_RIGHT + 30}, {COL_2_RIGHT, ROW_2_RIGHT + 30}};
	
	private final int combatInfoCoordinates[] = {450, 0, 600, 100};
	private final int combatLogLabelCoordinates[] = {560, 500, 300, 50};
	private final int combatLogCoordinates[] = {270, 550, 800, 175};
	
	// combat elements to draw
	private JLabel lbl_combatInfo;
	private JLabel lbl_combatLog;
	private String str_latest_combat_details;
	private JTextArea textArea_combatLog;
	private JScrollPane scrollPane_combatLog;
	
	// hero elements to draw
	private Characters.GoodGuy heroes[];
	private Characters.Enemy enemies[];
	private boolean potion_used[];
	
	private Icon img_heroImages[];
	private Icon img_enemyImages[];
	private JButton btn_heroImages[];
	private JButton btn_enemyImages[];
	
	private JLabel lbl_heroNames[];
	private JLabel lbl_heroLevels[];
	private JLabel lbl_heroHitPoints[];
	private JButton btn_heroAttacks[];
	private JButton btn_heroSpecialAttacks[];
	private JButton btn_usePotion[];
	
	// enemy elements to draw
	private JLabel lbl_enemyNames[];
	private JLabel lbl_enemyHitPoints[];
	private JButton btn_continue[]; // use after each enemy turn
	private JButton btn_cheat;
	
	// misc elements
	private JButton btn_endFight; // appears at the end of the fight, returns you to the main map
	
	public AttackState(GameStateManager dndGameStateManager){
		this.dndGameStateManager = dndGameStateManager;	
	}

	public class AttackClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			move = "Attack";
			btn_heroAttacks[turn].setEnabled(false);
			btn_heroSpecialAttacks[turn].setEnabled(false);
			btn_usePotion[turn].setEnabled(false);
			setClickableEnemyPortraits(true);
			dndGameStateManager.getPanel().remove(lbl_combatInfo);
			lbl_combatInfo = new JLabel("Click an enemy portrait!");
			lbl_combatInfo.setForeground(Color.WHITE);
			lbl_combatInfo.setBackground(Color.BLACK);
			lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
			lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
			dndGameStateManager.getPanel().add(lbl_combatInfo);
		}
	}
	
	public class SpecialAttackClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			move = "SpecialAttack";
			btn_heroAttacks[turn].setEnabled(false);
			btn_heroSpecialAttacks[turn].setEnabled(false);
			btn_usePotion[turn].setEnabled(false);
			setClickableEnemyPortraits(true);
			dndGameStateManager.getPanel().remove(lbl_combatInfo);
			lbl_combatInfo = new JLabel("Click an enemy portrait!");
			lbl_combatInfo.setForeground(Color.WHITE);
			lbl_combatInfo.setBackground(Color.BLACK);
			lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
			lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
			dndGameStateManager.getPanel().add(lbl_combatInfo);
		}
	}
	
	public class UsePotionClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			move = "UsePotion";
			btn_heroAttacks[turn].setEnabled(false);
			btn_heroSpecialAttacks[turn].setEnabled(false);
			btn_usePotion[turn].setEnabled(false);
			heroAttack();
		}
	}
	
	public class EnemyPortrait0ClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (move.equals("Attack") || move.equals("SpecialAttack"))
			{
				target = 0;
				heroAttack();
			}
			else
			{
				target = -1; // clicking on an enemy portrait when its not player's turn to attack
			}
		}
	}
	
	public class EnemyPortrait1ClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (move.equals("Attack") || move.equals("SpecialAttack"))
			{
				target = 1;
				heroAttack();
			}
			else
			{
				target = -1; // clicking on an enemy portrait when its not player's turn to attack
			}
		}
	}
	
	public class EnemyPortrait2ClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (move.equals("Attack") || move.equals("SpecialAttack"))
			{
				target = 2;
				heroAttack();
			}
			else
			{
				target = -1; // clicking on an enemy portrait when its not player's turn to attack
			}
		}
	}
	
	public class ContinueButtonClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			endTurn();
		}
	}
	
	public class ReturnToMapClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			endCombat();
		}
	}
	
	public class CheatClickEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!(enemies[0].isDead() && enemies[1].isDead() && enemies[2].isDead()))
			{
				enemies[0].setHitPoints(0);
				enemies[1].setHitPoints(0);
				enemies[2].setHitPoints(0);
				endTurn();
			}
		}
	}
	
	public void init()
	{		
				attackClickEvent = new AttackClickEvent();
				specialAttackClickEvent = new SpecialAttackClickEvent();
				usePotionClickEvent = new UsePotionClickEvent();
				enemyPortrait0ClickEvent = new EnemyPortrait0ClickEvent();
				enemyPortrait1ClickEvent = new EnemyPortrait1ClickEvent();
				enemyPortrait2ClickEvent = new EnemyPortrait2ClickEvent();
				continueButtonClickEvent = new ContinueButtonClickEvent();
				
				///////////////////////////////
				// initialize arrays
				///////////////////////////////
				
				heroes = new Characters.GoodGuy[3];
				enemies = new Characters.Enemy[3];
				potion_used = new boolean[3];
				
				img_heroImages = new Icon[3];
				img_enemyImages = new Icon[3];
				btn_heroImages = new JButton[3];
				btn_enemyImages = new JButton[3];
				lbl_heroNames = new JLabel[3];
				lbl_heroLevels = new JLabel[3];
				lbl_heroHitPoints = new JLabel[3];
				btn_heroAttacks = new JButton[3];
				btn_heroSpecialAttacks = new JButton[3];
				btn_usePotion = new JButton[3];
				
				lbl_enemyNames = new JLabel[3];
				lbl_enemyHitPoints = new JLabel[3];
				btn_continue = new JButton[3];
				btn_endFight = new JButton();
				
				///////////////////////////////
				// initialize hero elements
				///////////////////////////////
				for (int i = 0; i < 3; i++)
				{
					// initialize hero into array
					heroes[i] = dndGameStateManager.getGroup().getHero(i);
					potion_used[i] = false;
					
					if (!heroes[i].getClass().getSimpleName().equals("NullGoodGuy")) // don't draw the screen elements for a null good guy
					{
						// add hero portrait to screen
						img_heroImages[i] = new ImageIcon(heroes[i].getPortraitFilename());
						btn_heroImages[i] = new JButton();
						btn_heroImages[i].setIcon(img_heroImages[i]);
						btn_heroImages[i].setBounds(heroImageCoordinates[i][0], heroImageCoordinates[i][1], 100, 100);
						btn_heroImages[i].setBorderPainted(false);
						dndGameStateManager.getPanel().add(btn_heroImages[i]);
						
						// set label with the hero name
						lbl_heroNames[i] = new JLabel(heroes[i].getName(), SwingConstants.RIGHT);
						lbl_heroNames[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
						lbl_heroNames[i].setOpaque(true);
						lbl_heroNames[i].setForeground(Color.WHITE);
						lbl_heroNames[i].setBackground(Color.BLACK);
						lbl_heroNames[i].setBounds(heroNameCoordinates[i][0], heroNameCoordinates[i][1], 100, 30);
						dndGameStateManager.getPanel().add(lbl_heroNames[i]);
												
						// set the label with the hero hit points
						lbl_heroHitPoints[i] = new JLabel("HP: " + heroes[i].getHitPoints() + "", SwingConstants.RIGHT);
						lbl_heroHitPoints[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
						lbl_heroHitPoints[i].setOpaque(true);
						lbl_heroHitPoints[i].setForeground(Color.WHITE);
						lbl_heroHitPoints[i].setBackground(Color.BLACK);
						lbl_heroHitPoints[i].setBounds(heroHitPointsCoordinates[i][0], heroHitPointsCoordinates[i][1], 100, 30);
						dndGameStateManager.getPanel().add(lbl_heroHitPoints[i]);
												
						// set the label with the hero level
						lbl_heroLevels[i] = new JLabel("Level: " + heroes[i].getLevel() + "", SwingConstants.RIGHT);
						lbl_heroLevels[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
						lbl_heroLevels[i].setOpaque(true);
						lbl_heroLevels[i].setForeground(Color.WHITE);
						lbl_heroLevels[i].setBackground(Color.BLACK);
						lbl_heroLevels[i].setBounds(heroLevelCoordinates[i][0], heroLevelCoordinates[i][1], 100, 30);
						dndGameStateManager.getPanel().add(lbl_heroLevels[i]);
					}
				}
						
				///////////////////////////////
				// initialize enemy elements
				///////////////////////////////
				for (int i = 0; i < 3; i++)
				{
					// initialize enemy into array
					enemies[i] = dndGameStateManager.getEnemyGroup().getEnemy(i);
					
					if (!enemies[i].getClass().getSimpleName().equals("NullEnemy")) // don't draw the screen elements for a null enemy
					{
						// add enemy portrait to screen
						img_enemyImages[i] = new ImageIcon(enemies[i].getPortraitFilename());
						btn_enemyImages[i] = new JButton();
						btn_enemyImages[i].setIcon(img_enemyImages[i]);
						btn_enemyImages[i].setBounds(enemyImageCoordinates[i][0], enemyImageCoordinates[i][1], 100, 100);
						//btn_enemyImages[i].setEnabled(false);
						//btn_enemyImages[i].setBorderPainted(false);
						dndGameStateManager.getPanel().add(btn_enemyImages[i]);
						
						// set label with the enemy name
						lbl_enemyNames[i] = new JLabel(enemies[i].getName());
						lbl_enemyNames[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
						lbl_enemyNames[i].setOpaque(true);
						lbl_enemyNames[i].setForeground(Color.WHITE);
						lbl_enemyNames[i].setBackground(Color.BLACK);
						lbl_enemyNames[i].setBounds(enemyNameCoordinates[i][0], enemyNameCoordinates[i][1], 100, 30);
						dndGameStateManager.getPanel().add(lbl_enemyNames[i]);						
						
						// set label with enemy hit points
						lbl_enemyHitPoints[i] = new JLabel("HP: " + enemies[i].getHitPoints() + "");
						lbl_enemyHitPoints[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
						lbl_enemyHitPoints[i].setOpaque(true);
						lbl_enemyHitPoints[i].setForeground(Color.WHITE);
						lbl_enemyHitPoints[i].setBackground(Color.BLACK);
						lbl_enemyHitPoints[i].setBounds(enemyHitPointsCoordinates[i][0], enemyHitPointsCoordinates[i][1], 100, 30);
						dndGameStateManager.getPanel().add(lbl_enemyHitPoints[i]);
					}
				}
				
				if (!enemies[0].getClass().getSimpleName().equals("NullEnemy"))
				{
					btn_enemyImages[0].addActionListener(enemyPortrait0ClickEvent);
				}
				if (!enemies[1].getClass().getSimpleName().equals("NullEnemy"))
				{
					btn_enemyImages[1].addActionListener(enemyPortrait1ClickEvent);
				}
				if (!enemies[2].getClass().getSimpleName().equals("NullEnemy"))
				{
					btn_enemyImages[2].addActionListener(enemyPortrait2ClickEvent);
				}
		
				///////////////////////////////
				// initialize misc elements
				///////////////////////////////	
		
				lbl_combatInfo = new JLabel("Combat Info Here");
				lbl_combatInfo.setForeground(Color.WHITE);
				lbl_combatInfo.setBackground(Color.BLACK);
				lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
				lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
				dndGameStateManager.getPanel().add(lbl_combatInfo);

				lbl_combatLog = new JLabel("Combat Log");
				lbl_combatLog.setForeground(Color.WHITE);
				lbl_combatLog.setBackground(Color.BLACK);
				lbl_combatLog.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
				lbl_combatLog.setBounds(combatLogLabelCoordinates[0], combatLogLabelCoordinates[1], combatLogLabelCoordinates[2], combatLogLabelCoordinates[3]);
				dndGameStateManager.getPanel().add(lbl_combatLog);
								
				textArea_combatLog = new JTextArea();
				textArea_combatLog.setBounds(combatLogCoordinates[0], combatLogCoordinates[1], combatLogCoordinates[2], combatLogCoordinates[3]);
				textArea_combatLog.setForeground(Color.WHITE);
				textArea_combatLog.setBackground(Color.BLACK);
				textArea_combatLog.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
				textArea_combatLog.setEditable(false);
				
				scrollPane_combatLog = new JScrollPane(textArea_combatLog);
				scrollPane_combatLog.setBounds(combatLogCoordinates[0], combatLogCoordinates[1], combatLogCoordinates[2], combatLogCoordinates[3]);
				dndGameStateManager.getPanel().add(scrollPane_combatLog);
				
				if (debug_mode)
				{
					CheatClickEvent cheatClickEvent = new CheatClickEvent();
					btn_cheat = new JButton("Cheat");
					btn_cheat.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
					btn_cheat.setForeground(Color.WHITE);
					btn_cheat.setBackground(Color.BLACK);
					btn_cheat.setBounds(40, 695, 100, 30);
					btn_cheat.addActionListener(cheatClickEvent);
					btn_cheat.setEnabled(true);
					dndGameStateManager.getPanel().add(btn_cheat);
				}
		try {
			curFrame = ImageIO.read(new File("BattleRoomWizElfWar.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startFight();
	}

	public void startFight()
	{
		turn = 0;
		target = -1;
		move = "None";

		String str_heroes = null;
		String str_enemies = null;
		
		if (heroes[1].getName().equals("NullGoodGuy"))
		{
			str_heroes = heroes[0].getName();
		}
		else if (heroes[2].getName().equals("NullGoodGuy"))
		{
			str_heroes = heroes[0].getName() + " and " + heroes[1].getName();
		}
		else
		{
			str_heroes = heroes[0].getName() + ", " + heroes[1].getName() + ", and " + heroes[2].getName();
		}

		if (enemies[1].getName().equals("NullEnemy"))
		{
			str_enemies = enemies[0].getName();
		}
		else if (enemies[2].getName().equals("NullEnemy"))
		{
			str_enemies = enemies[0].getName() + " and " + enemies[1].getName();
		}
		else
		{
			str_enemies = enemies[0].getName() + ", " + enemies[1].getName() + ", and " + enemies[2].getName();
		}
		
		textArea_combatLog.append(str_heroes + "\n\n");
		textArea_combatLog.append("Will battle\n\n");
		textArea_combatLog.append(str_enemies + "\n\n");
		textArea_combatLog.setCaretPosition(textArea_combatLog.getDocument().getLength());
		
		takeTurn();
	}
	
	public void setClickableEnemyPortraits(boolean value)
	{
		if (value)
		{
			for (int i = 0; i < 3; i++)
			{
				if (!enemies[i].isDead())
				{
					btn_enemyImages[i].setEnabled(true);
				}
			}
		}
		else
		{
			for (int i = 0; i < 3; i++)
			{
				btn_enemyImages[i].setEnabled(false);
			}
		}
	}
	
	public void heroAttack()
	{
		if (move.equals("Attack"))
		{
			str_latest_combat_details = heroes[turn].useAttack(enemies[target]);
			updateCombatLog();
		}
		else if (move.equals("SpecialAttack"))
		{
			str_latest_combat_details = heroes[turn].useSpecialAttack(enemies[target]);
			updateCombatLog();
		}
		else if (move.equals("UsePotion"))
		{
			heroes[turn].addHitPoints(50);
			potion_used[turn] = true;
			str_latest_combat_details = heroes[turn].getName() + " used a health potion.\n";
			updateCombatLog();
		}
		
		if (!move.equals("UsePotion") && enemies[target].isDead())
		{
			str_latest_combat_details = enemies[target].getName() + " was slain!\n";
			updateCombatLog();
			// this enemy can no longer be clicked if it is dead
			btn_enemyImages[target].setEnabled(false);
			// this enemy has its continue button disappear
			//dndGameStateManager.getPanel().remove(btn_continue[target]);
		}
		
		endTurn();
	}
	
	public void enemyAttack()
	{
		// attack a random hero that isn't dead
		Random rand = new Random();
	    int random_num = rand.nextInt(3);
	    while (heroes[random_num].isDead())
	    {
	    	random_num = rand.nextInt(3);
	    }
	    
	    str_latest_combat_details = enemies[turn - 3].useAttack(heroes[random_num]);
	    updateCombatLog();
	    btn_continue[turn - 3] = new JButton("Continue");
	    btn_continue[turn - 3].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	    btn_continue[turn - 3].setForeground(Color.WHITE);
	    btn_continue[turn - 3].setBackground(Color.BLACK);
	    btn_continue[turn - 3].setBounds(enemyContinueCoordinates[turn - 3][0], enemyContinueCoordinates[turn - 3][1], 150, 30);
	    btn_continue[turn - 3].addActionListener(continueButtonClickEvent);
	    dndGameStateManager.getPanel().add(btn_continue[turn - 3]);
	}
	
	public void updateCombatLog()
	{
		textArea_combatLog.append(str_latest_combat_details + "\n");
		textArea_combatLog.setCaretPosition(textArea_combatLog.getDocument().getLength());
	}
	
	public void takeTurn()
	{
		if (turn >= 0 && turn <= 2) // hero turn
		{
			// skip this hero because it is dead or a NullGoodGuy
			if (heroes[turn].isDead())
			{
				endTurn();
			}
			else
			{
				dndGameStateManager.getPanel().remove(lbl_combatInfo);
				lbl_combatInfo = new JLabel(heroes[turn].getName() + "'s turn");
				lbl_combatInfo.setForeground(Color.WHITE);
				lbl_combatInfo.setBackground(Color.BLACK);
				lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
				lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
				dndGameStateManager.getPanel().add(lbl_combatInfo);
				
				// set the button with hero attack
				btn_heroAttacks[turn] = new JButton("Attack");
				btn_heroAttacks[turn].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
				btn_heroAttacks[turn].setForeground(Color.WHITE);
				btn_heroAttacks[turn].setBackground(Color.BLACK);
				btn_heroAttacks[turn].setBounds(heroAttackCoordinates[turn][0], heroAttackCoordinates[turn][1], 150, 30);
				btn_heroAttacks[turn].addActionListener(attackClickEvent);
				//btn_heroAttacks[turn].setEnabled(false);
				dndGameStateManager.getPanel().add(btn_heroAttacks[turn]);
				
				// set the buttons with hero special attack
				btn_heroSpecialAttacks[turn] = new JButton(heroes[turn].getSpecialAttackName());
				btn_heroSpecialAttacks[turn].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
				btn_heroSpecialAttacks[turn].setForeground(Color.WHITE);
				btn_heroSpecialAttacks[turn].setBackground(Color.BLACK);
				btn_heroSpecialAttacks[turn].setBounds(heroSpecialAttackCoordinates[turn][0], heroSpecialAttackCoordinates[turn][1], 150, 30);
				btn_heroSpecialAttacks[turn].addActionListener(specialAttackClickEvent);
				//btn_heroSpecialAttacks[turn].setEnabled(false);
				dndGameStateManager.getPanel().add(btn_heroSpecialAttacks[turn]);
				
				if (!potion_used[turn])
				{
					// set the buttons for items
					btn_usePotion[turn] = new JButton("Use Potion");
					btn_usePotion[turn].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
					btn_usePotion[turn].setForeground(Color.WHITE);
					btn_usePotion[turn].setBackground(Color.BLACK);
					btn_usePotion[turn].setBounds(heroUsePotionCoordinates[turn][0], heroUsePotionCoordinates[turn][1], 150, 30);
					btn_usePotion[turn].addActionListener(usePotionClickEvent);
					//btn_usePotion[turn].setEnabled(false);
					dndGameStateManager.getPanel().add(btn_usePotion[turn]);
				}
			}
		}
		else // enemy turn
		{
			// skip this enemy because it is dead or a NullEnemy
			if (enemies[turn - 3].isDead())
			{
				endTurn();
			}
			else
			{
				dndGameStateManager.getPanel().remove(lbl_combatInfo);
				lbl_combatInfo = new JLabel(enemies[turn - 3].getName() + "'s turn");
				lbl_combatInfo.setForeground(Color.WHITE);
				lbl_combatInfo.setBackground(Color.BLACK);
				lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
				lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
				dndGameStateManager.getPanel().add(lbl_combatInfo);
				enemyAttack();
			}
		}
		
	}
	
	public void endTurn()
	{
		updateAllHitPoints();
		move = "None";
		target = -1;
		int game_status = isGameOver();
		if (game_status == 1 || game_status == 2) // game is over
		{
			endScreen(game_status);	
		}
		else // game is still going
		{
			if (turn >= 0 && turn <= 2) // end a hero turn
			{
				if (!heroes[turn].getClass().getSimpleName().equals("NullGoodGuy"))
				{
					dndGameStateManager.getPanel().remove(btn_heroAttacks[turn]);
					dndGameStateManager.getPanel().remove(btn_heroSpecialAttacks[turn]);
					dndGameStateManager.getPanel().remove(btn_usePotion[turn]);
				}
			}
			else
			{
				if (!enemies[turn - 3].getClass().getSimpleName().equals("NullEnemy") && !enemies[turn - 3].isDead())
				{
					dndGameStateManager.getPanel().remove(btn_continue[turn - 3]);
				}
			}
			turn = (turn + 1) % 6;
			takeTurn();
		}
	}
	
	public void endScreen(int game_result)
	{
		// in case the user cheated and they weren't dead
		// fade out the enemy portraits
		for (int i = 0; i < 3; i++)
		{
			if (!enemies[i].getName().equals("NullEnemy"))
			{
				btn_enemyImages[i].setEnabled(false);
			}
		}
		
		if (game_result == 1)
		{
			textArea_combatLog.append("Heroes win!\n");
			textArea_combatLog.append(heroes[0].getName() + " leveled up!\n");
			if (!heroes[1].getName().equals("NullGoodGuy"))
			{
				textArea_combatLog.append(heroes[1].getName() + " leveled up!\n");
			}
			if (!heroes[2].getName().equals("NullGoodGuy"))
			{
				textArea_combatLog.append(heroes[2].getName() + " leveled up!");
			}
			dndGameStateManager.getPanel().remove(lbl_combatInfo);
			lbl_combatInfo = new JLabel("Heroes Win!");
			lbl_combatInfo.setForeground(Color.WHITE);
			lbl_combatInfo.setBackground(Color.BLACK);
			lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
			lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
			dndGameStateManager.getPanel().add(lbl_combatInfo);
			
			if (enemies[0].isDead() && enemies[1].isDead() && enemies[2].isDead())
			{
				levelUpAllHeroes(); // heroes won, levels up all heroes and heals them to full for the next battle
				// redraw the label to display their new levels
				for (int i = 0; i < 3; i++)
				{
					if (!heroes[i].getName().equals("NullGoodGuy"))
					{
						dndGameStateManager.getPanel().remove(lbl_heroLevels[i]);
						lbl_heroLevels[i] = new JLabel("Level: " + heroes[i].getLevel() + "", SwingConstants.RIGHT);
						lbl_heroLevels[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
						lbl_heroLevels[i].setOpaque(true);
						lbl_heroLevels[i].setForeground(Color.WHITE);
						lbl_heroLevels[i].setBackground(Color.BLACK);
						lbl_heroLevels[i].setBounds(heroLevelCoordinates[i][0], heroLevelCoordinates[i][1], 100, 30);
						dndGameStateManager.getPanel().add(lbl_heroLevels[i]);
					}
				}
			}
		}
		else
		{
			healAllHeroes(); // enemies won, heals all heroes but does not grant levels
			textArea_combatLog.append("Enemies win!");
			dndGameStateManager.getPanel().remove(lbl_combatInfo);
			lbl_combatInfo = new JLabel("Enemies Win!");
			lbl_combatInfo.setForeground(Color.WHITE);
			lbl_combatInfo.setBackground(Color.BLACK);
			lbl_combatInfo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
			lbl_combatInfo.setBounds(combatInfoCoordinates[0], combatInfoCoordinates[1], combatInfoCoordinates[2], combatInfoCoordinates[3]);
			dndGameStateManager.getPanel().add(lbl_combatInfo);
		}
		
		if (turn >= 0 && turn <= 2)
		{
			// remove buttons for the last hero to make an attack
			dndGameStateManager.getPanel().remove(btn_heroAttacks[turn]);
			dndGameStateManager.getPanel().remove(btn_heroSpecialAttacks[turn]);
			if (!potion_used[turn])
			{
				dndGameStateManager.getPanel().remove(btn_usePotion[turn]);
			}
		}
		else
		{
			// used cheat to win, remove the current continue button
			dndGameStateManager.getPanel().remove(btn_continue[turn - 3]);
		}
		
		ReturnToMapClickEvent returnToMapClickEvent = new ReturnToMapClickEvent();
		btn_endFight = new JButton("Return to Map");
		btn_endFight.setForeground(Color.WHITE);
		btn_endFight.setBackground(Color.BLACK);
		btn_endFight.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
		btn_endFight.setBounds(heroSpecialAttackCoordinates[1][0] + 120, heroSpecialAttackCoordinates[1][1] - 25, 300, 100);
		btn_endFight.addActionListener(returnToMapClickEvent);
		dndGameStateManager.getPanel().add(btn_endFight);
	}
	
	
	public void updateAllHitPoints()
	{
		for (int i = 0; i < 3; i++)
		{
			if (!heroes[i].getClass().getSimpleName().equals("NullGoodGuy")) // don't draw the hit points for a null good guy
			{
				dndGameStateManager.getPanel().remove(lbl_heroHitPoints[i]);
				if (heroes[i].isDead())
				{
					lbl_heroHitPoints[i] = new JLabel("KNOCKED OUT", SwingConstants.RIGHT);
				}
				else
				{
					lbl_heroHitPoints[i] = new JLabel("HP: " + heroes[i].getHitPoints(), SwingConstants.RIGHT);
				}
				lbl_heroHitPoints[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
				lbl_heroHitPoints[i].setOpaque(true);
				lbl_heroHitPoints[i].setForeground(Color.WHITE);
				lbl_heroHitPoints[i].setBackground(Color.BLACK);
				lbl_heroHitPoints[i].setBounds(heroHitPointsCoordinates[i][0], heroHitPointsCoordinates[i][1], 100, 30);
				dndGameStateManager.getPanel().add(lbl_heroHitPoints[i]);
			}
		}
		for (int i = 0; i < 3; i++)
		{
			if (!enemies[i].getClass().getSimpleName().equals("NullEnemy")) // don't draw the hit points for a null enemy
			{
				dndGameStateManager.getPanel().remove(lbl_enemyHitPoints[i]);
				if (enemies[i].isDead())
				{
					lbl_enemyHitPoints[i] = new JLabel("DEAD");
				}
				else
				{
					lbl_enemyHitPoints[i] = new JLabel("HP: " + enemies[i].getHitPoints());
				}
				lbl_enemyHitPoints[i].setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
				lbl_enemyHitPoints[i].setOpaque(true);
				lbl_enemyHitPoints[i].setForeground(Color.WHITE);
				lbl_enemyHitPoints[i].setBackground(Color.BLACK);
				lbl_enemyHitPoints[i].setBounds(enemyHitPointsCoordinates[i][0], enemyHitPointsCoordinates[i][1], 100, 30);
				dndGameStateManager.getPanel().add(lbl_enemyHitPoints[i]);
			}
		}
	}
	
	public int isGameOver()
	{
		// 0 -> game not over
		// 1 -> heroes wins
		// 2 -> enemies win
		int result;
		if (enemies[0].isDead() && enemies[1].isDead() && enemies[2].isDead())
		{
			result = 1;
		}
		else if (heroes[0].isDead() && heroes[1].isDead() && heroes[2].isDead())
		{
			result = 2;
		}
		else
		{
			result = 0;
		}
		return result;
	}
	
	public void levelUpAllHeroes()
	{
		for (int i = 0; i < 3; i++)
		{
			if (!heroes[i].getClass().getSimpleName().equals("NullGoodGuy"))
			{
				heroes[i].levelUp();
			}
		}
	}
	
	public void healAllHeroes()
	{
		for (int i = 0; i < 3; i++)
		{
			if (!heroes[i].getClass().getSimpleName().equals("NullGoodGuy"))
			{
				heroes[i].healToFull();
			}
		}
	}
	
	public void update() {
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

	
	public void handleInput() {
		// TODO Auto-generated method stub	
	}
	
	public void endCombat()
	{
		dndGameStateManager.getPanel().removeAll();
		this.dndGameStateManager.getReturnState();
	}
}
