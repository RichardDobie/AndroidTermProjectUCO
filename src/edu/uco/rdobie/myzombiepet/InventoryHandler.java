package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;

public class InventoryHandler {
	private ArrayList<Item> mItems;
	
	public InventoryHandler() {
		mItems = new ArrayList<Item>();
	}
	
	public void addToInventory(Item item){
		mItems.add(item);
	}
	
	public ArrayList<Item> getInventoryItems(){
		return mItems;
	}
}
