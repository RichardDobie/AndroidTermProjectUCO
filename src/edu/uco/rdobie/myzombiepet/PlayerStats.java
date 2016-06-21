package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;

import android.widget.Toast;

public class PlayerStats {
	public ArrayList<Achievement> Achievements;
	public ArrayList<Achievement> completedAchievements;
	public ArrayList<Item> mItems;
	private int mTimesPetted = 0;
	private int mItemsEquipped = 0;
	private int mHappyBonus = 0;
	private int mHungerBonus = 0;
	private int mTiredBonus = 0;
	private int mPettingBonus = 0;
	private int mNumAchievements = 0;
	
	public PlayerStats(){
		Achievements = new ArrayList<Achievement>();
		completedAchievements = new ArrayList<Achievement>();
		masterAchievementList();
	}
	
	public CharSequence checkAchievements(){
		CharSequence msg = null;
		for (int i = 0; i < Achievements.size(); i++){
			if (Achievements.get(i).getmProgress() == Achievements.get(i).getmCeiling() && !Achievements.get(i).ismIsAchieved()){
				completedAchievements.add(Achievements.get(i));
				Achievements.get(i).setmIsAchieved(true);
				if (Achievements.get(i).getmType().equals("Petting")){
					mPettingBonus += Achievements.get(i).getmBonus();
				} 
				mNumAchievements++;
				msg = "Achievement: " + Achievements.get(i).getmTitle() + ": " + 
							            Achievements.get(i).getmDescription();
				
			}
		}
		return msg;
	}
	
	public void masterAchievementList(){
		
		newAchievement(5, 2, "Cuddle Bunny", "Pet zombie 5 Times", "Petting");
		newAchievement(10, 2, "Super Cuddle Bunny", "Pet zombie 10 Times", "Petting");
		newAchievement(15, 2,"Ultra Cuddle Bunny", "Pet zombie 15 Times", "Petting");
		newAchievement(20, 2,"Cuddle Bunny God", "Pet zombie 20 Times", "Petting");
		
		newAchievement(1, 2, "Equiptment Junkie", "Equip an Item", "Item");
		newAchievement(3, 2, "Equiptment Scholar", "Equip Two Items", "Item");
		newAchievement(5, 2,"Equiptment Artist", "Equip Three Items", "Item");
		newAchievement(7, 2,"Equiptment Specialist", "Equip Four Items", "Item");
		
	}
	
	public void newAchievement(int points, int bonus, String title, String desc, String type) {
		Achievement achievement = new Achievement(points, bonus, title, desc, type);
		Achievements.add(achievement);
	}
	
	public void newItem(String name, int duration, String type, int imageId, int price){
		//Item item = new Item(name, duration, type, imageId, price);
	}
	
	public void incPetting(){
		mTimesPetted++;
		incAchievementByType("Petting");
	}
	
	public void incEquip(){
		mItemsEquipped++;
		incAchievementByType("Item");
	}

	public ArrayList<Achievement> getCompletedAchievements() {
		return completedAchievements;
	}

	public void setCompletedAchievements(
			ArrayList<Achievement> completedAchievements) {
		this.completedAchievements = completedAchievements;
	}

	public int getmTimesPetted() {
		return mTimesPetted;
	}

	public void setmTimesPetted(int mTimesPetted) {
		this.mTimesPetted = mTimesPetted;
	}

	public int getmPettingBonus() {
		return mPettingBonus;
	}

	public void setmPettingBonus(int mPettingBonus) {
		this.mPettingBonus = mPettingBonus;
	}

	private void incAchievementByType(String type) { //increment all achievements specified by a type
		for (int i = 0; i < Achievements.size(); i++){
			if (Achievements.get(i).getmType().equals(type)) Achievements.get(i).incProgress();
		}	
	}

	public int getmHappyBonus() {
		return mHappyBonus;
	}

	public void setmHappyBonus(int mHappyBonus) {
		this.mHappyBonus = mHappyBonus;
	}

	public int getmHungerBonus() {
		return mHungerBonus;
	}

	public void setmHungerBonus(int mHungerBonus) {
		this.mHungerBonus = mHungerBonus;
	}

	public int getmTiredBonus() {
		return mTiredBonus;
	}

	public void setmTiredBonus(int mTiredBonus) {
		this.mTiredBonus = mTiredBonus;
	}

	public int getmNumAchievements() {
		return mNumAchievements;
	}

	public int getmItemsEquipped() {
		return mItemsEquipped;
	}
	
}
