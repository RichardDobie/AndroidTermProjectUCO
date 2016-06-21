package edu.uco.rdobie.myzombiepet;

public class ZombiePet {
	private static final int mStatusRateDefault = 10;
	private static final int mHungerRateDefault = 10;
	private static final int mRestedRateDefault = 10;
	private int mStatus;
	private int mStatusRate;
	private int mHunger;
	private int mHungerRate;
	private int mRested;
	private int mRestedRate;
	
	private String mZombieName;
	
	private boolean mIsHappy;
	private boolean mIsHungry;
	private boolean mIsTired;
	
	public ZombiePet(String zombieName){
		mZombieName = zombieName;
		mStatus = 10000;
		mStatusRate = 0;
		mHunger = 10000;
		mHungerRate = 10;
		mRested = 10000;
		mRestedRate = 10;
		mIsHappy = true;
		mIsHungry = false;
		mIsTired = false;
		updateZombie();
	}
	
	public void updateZombie(){
		if (mHunger < 5000 && !mIsHungry) { 
			mIsHungry = true;
			mHungerRate *= 2;
		} else if (mHunger < 5000) {
			mIsHungry = true;
		} else {
			mIsHungry = false;
			mHungerRate = mHungerRateDefault;
		}
		
		if (mRested < 5000 && !mIsTired){
			mIsTired = true;
			mRestedRate *=2;
		} else if (mRested < 5000) {
			mIsTired = true;
		} else {
			mIsTired = false;
			mRestedRate = mRestedRateDefault;
		}
		
		mStatusRate = mRestedRate + mHungerRate;
		mStatus -= mStatusRate;
		mRested -= mRestedRate;
		mHunger -= mHungerRate;
			
		if (mStatus < 5000){
			mIsHappy = false;
		}
		else {
			mIsHappy = true;
		}		
	}

	public int getmStatus() {
		return mStatus;
	}

	public void setmStatus(int mStatus) {
		this.mStatus = mStatus;
	}

	public String getmZombieName() {
		return mZombieName;
	}

	public void setmZombieName(String mZombieName) {
		this.mZombieName = mZombieName;
	}

	public boolean ismIsHappy() {
		return mIsHappy;
	}

	public void setmIsHappy(boolean mIsHappy) {
		this.mIsHappy = mIsHappy;
	}

	public int getmHunger() {
		return mHunger;
	}

	public void setmHunger(int mHunger) {
		this.mHunger = mHunger;
	}

	public int getmRested() {
		return mRested;
	}

	public void setmRested(int mRested) {
		this.mRested = mRested;
	}

	public void petZombie() {
		mStatus +=100;
		
	}

	public void petZombie(int i) {
		mStatus += 100 + i;
		
	}
	
	
	
}
