package edu.uco.rdobie.myzombiepet;

public class Item {
	private String mName;
	private String type;
	private String mDescription;
	private int hungerBonus;
	private int happyBonus;
	private int tiredBonus;
	private int pettedBonus;
	private int duration;
	private int imageId;
	private int mPrice;
	private boolean isActive;
	private boolean isOwned;
	
	public Item(String name, String description, int hunger, int happy, int tired, int petted, int image){
		this.mName = name;
		this.mDescription = description;
		isActive = false;
		isOwned = false;
		hungerBonus = hunger;
		happyBonus = happy;
		tiredBonus = tired;
		this.imageId = image;
		this.pettedBonus = petted;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getPrice() {
		return mPrice;
	}

	public void setPrice(int price) {
		this.mPrice = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public int getmPrice() {
		return mPrice;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	public int getHungerBonus() {
		return this.hungerBonus;
	}

	public int getHappyBonus() {
		return this.happyBonus;
	}

	public int getTiredBonus() {
		return this.tiredBonus;
	}

	public int getPettedBonus() {
		return pettedBonus;
	}
	
}
