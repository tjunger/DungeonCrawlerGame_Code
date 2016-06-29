// Binary Search Team
// Matthew Kerr
// Nick Witmer
// Tim Unger
//
// CSCD 349
// Final Project: Dungeons and Dragons
// Winter 2015

package GUI;

import inventory.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Characters.GoodGuy;

@SuppressWarnings("serial")
public class InventoryPanel extends JLabel{
	private class InventoryItemListener implements ActionListener{
		public int indexSelected;
		public Item itemSelected;
		public boolean isItemSelected;
		public GoodGuy heroSelected;
		public boolean isHeroSelected;
		public InventoryItemListener(){
			isItemSelected = false;
			isHeroSelected = false;
		}
		public void actionPerformed(ActionEvent e) {
			indexSelected = invSlots.indexOf(e.getSource());
			itemSelected = dndgm.getGroup().getHeroInventory().getItem(indexSelected);
			if(isHeroSelected){
				itemSelected.useItem(heroSelected);
				isItemSelected = false;
				isHeroSelected = false;
			}
			else{
				isItemSelected = true;
			}
		}
		
	}
	private class HeroPickListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			invItemListener.heroSelected = heroes[btn_heroImages.indexOf(event.getSource())];
			if(invItemListener.isItemSelected){
				invItemListener.itemSelected.useItem(invItemListener.heroSelected);
				invItemListener.isItemSelected = false;
				invItemListener.isHeroSelected = false;
			}
			else{
				invItemListener.isHeroSelected = true;
			}
		}
		
	}

	private Icon inventoryImage;
	private ArrayList<JButton> invSlots;
	private InventoryItemListener invItemListener;
	private HeroPickListener chooseHero;
	private ArrayList<JButton> btn_heroImages;
	private Icon[] img_heroImages;
	private GoodGuy[] heroes;
	private GameStateManager dndgm;
	
	public InventoryPanel(GameStateManager dndgm){
		//init inventoryPanel
		super();
		invSlots = new ArrayList<JButton>(9);
		invItemListener = new InventoryItemListener();
		chooseHero = new HeroPickListener();
		heroes = new Characters.GoodGuy[3];
		img_heroImages = new Icon[3];
		btn_heroImages = new ArrayList<JButton>(3);
		this.dndgm = dndgm;
		this.inventoryImage = new ImageIcon("Inventory.jpg");
		this.setIcon(inventoryImage);
		this.setBounds(0, 0, 200, 740);
		invSlots.add(new JButton());
		invSlots.get(0).setBounds(20, 120, 40, 40);
		this.add(invSlots.get(0));
		invSlots.add( new JButton() );
		invSlots.get(1).setBounds(80, 120, 40, 40);
		this.add(invSlots.get(1));
		invSlots.add(new JButton());
		invSlots.get(2).setBounds(140, 120, 40, 40);
		this.add(invSlots.get(2));
		invSlots.add(new JButton());
		invSlots.get(3).setBounds(20, 200, 40, 40);
		this.add(invSlots.get(3));
		invSlots.add(new JButton());
		invSlots.get(4).setBounds(80, 200, 40, 40);
		this.add(invSlots.get(4));
		invSlots.add(new JButton());
		invSlots.get(5).setBounds(140, 200, 40, 40);
		this.add(invSlots.get(5));
		invSlots.add(new JButton());
		invSlots.get(6).setBounds(20, 280, 40, 40);
		this.add(invSlots.get(6));
		invSlots.add(new JButton());
		invSlots.get(7).setBounds(80, 280, 40, 40);
		this.add(invSlots.get(7));
		invSlots.add(new JButton());
		invSlots.get(8).setBounds(140, 280, 40, 40);
		this.add(invSlots.get(8));

		for (int i = 0; i < 3; i++)
		{
			// initialize hero into array
			heroes[i] = dndgm.getGroup().getHero(i);
			
			if (!heroes[i].getClass().getSimpleName().equals("NullGoodGuy")) // don't draw the screen elements for a null good guy
			{
				// add hero portrait to screen
				img_heroImages[i] = (new ImageIcon(heroes[i].getPortraitFilename()));
				btn_heroImages.add(new JButton());
				btn_heroImages.get(i).setIcon(img_heroImages[i]);
				this.add(btn_heroImages.get(i));
				btn_heroImages.get(i).addActionListener(chooseHero);
			}
			
		}
		if(btn_heroImages.size() >= 1 && btn_heroImages.get(0) != null){
			btn_heroImages.get(0).setBounds(50, 340, 100, 100);
		}
		if(btn_heroImages.size() >= 2 && btn_heroImages.get(1) != null){
			btn_heroImages.get(1).setBounds(50, 450, 100, 100);
		}
		if(btn_heroImages.size() >= 3 && btn_heroImages.get(2) != null){
			btn_heroImages.get(2).setBounds(50, 560, 100, 100);
		}
		this.setFocusable(false);
	}
	
	public void update(){
		int i;
		int invSize = this.dndgm.getGroup().getHeroInventory().getSlotsUsed();
		if (invSize != 0){
			for(i = 0; i < invSize; i++){	

				invSlots.get(i).setIcon(this.dndgm.getGroup().getHeroInventory().getItem(i).getItemIcon());
				invSlots.get(i).setEnabled(true);
				invSlots.get(i).addActionListener(invItemListener);
			}	
			for(i = this.dndgm.getGroup().getHeroInventory().getSlotsUsed(); i < 9; i++){
			invSlots.get(i).setEnabled(false);
			}
		}
		else {

			for(i = 0; i < 9; i++){
				invSlots.get(i).setEnabled(false);
			}
		}
	}
}
