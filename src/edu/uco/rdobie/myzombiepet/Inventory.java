package edu.uco.rdobie.myzombiepet;

import android.util.Log;

public class Inventory {
	private Item mSlot1;
	private Item mSlot2;
	private Item mSlot3;
	private Item mSlot4;
	
	public Inventory(){
		mSlot1 = getEmptyItem();
		mSlot2 = getEmptyItem();
		mSlot3 = getEmptyItem();
		mSlot4 = getEmptyItem();
	}
	
	public void setSlot1(Item i){
		mSlot1 = i;
		Log.e("Inventory", "Slot 1 is now  " + mSlot1.getmName());
	}
	public void setSlot2(Item i){
		mSlot2 = i;
		Log.e("Inventory", "Slot 2 is now  " + mSlot2.getmName());
	}
	public void setSlot3(Item i){
		mSlot3 = i;
		Log.e("Inventory", "Slot 3 is now  " + mSlot3.getmName());
	}
	public void setSlot4(Item i){
		mSlot4 = i;
		Log.e("Inventory", "Slot 4 is now  " + mSlot4.getmName());
	}	
	
	public void resetInv(){
		mSlot1 = getEmptyItem();
		mSlot2 = getEmptyItem();
		mSlot3 = getEmptyItem();
		mSlot4 = getEmptyItem();
	}
	
	public Item getEmptyItem(){
		Item emptyItem = new Item("","", 0, 0, 0, 0, R.drawable.mz_item_empty);
		return emptyItem;
	}
	
	public void emptySlot1(Item emptyItem){
		mSlot1 = emptyItem;
	}
	public void emptySlot2(Item emptyItem){
		mSlot2 = emptyItem;
	}
	public void emptySlot3(Item emptyItem){
		mSlot3 = emptyItem;
	}
	public void emptySlot4(Item emptyItem){
		mSlot4 = emptyItem;
	}
	
	public int getHungerBonus(){
		int bonus = 0;
		bonus += mSlot1.getHungerBonus();
		bonus += mSlot2.getHungerBonus();
		bonus += mSlot3.getHungerBonus();
		bonus += mSlot4.getHungerBonus();
		return bonus;
	}
	
	public int getHappyBonus(){
		int bonus = 0;
		bonus += mSlot1.getHappyBonus();
		bonus += mSlot2.getHappyBonus();
		bonus += mSlot3.getHappyBonus();
		bonus += mSlot4.getHappyBonus();
		return bonus;
	}
	
	public int getTiredBonus(){
		int bonus = 0;
		bonus += mSlot1.getTiredBonus();
		bonus += mSlot2.getTiredBonus();
		bonus += mSlot3.getTiredBonus();
		bonus += mSlot4.getTiredBonus();
		return bonus;
	}

	public int getSlot1Image() {
		return mSlot1.getImageId();
	}
	
	public int getSlot2Image() {
		return mSlot2.getImageId();
	}
	
	public int getSlot3Image() {
		return mSlot3.getImageId();
	}
	
	public int getSlot4Image() {
		return mSlot4.getImageId();
	}

	public int getPettedBonus() {
		int bonus = 0;
		bonus += mSlot1.getPettedBonus();
		bonus += mSlot2.getPettedBonus();
		bonus += mSlot3.getPettedBonus();
		bonus += mSlot4.getPettedBonus();
		return bonus;
	}
}
