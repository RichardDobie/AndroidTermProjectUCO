package edu.uco.rdobie.myzombiepet;

public class Achievement {
	private int mCeiling; //number of points required to achieve 
	private int mProgress; //number of points so far
	private int mBonus;
	private String mTitle;
	private String mDescription;
	private String mType;
	private boolean mIsAchieved;
	
	public Achievement(int ceiling, int bonus, String title, String desc, String type){
		mCeiling = ceiling;
		mTitle = title;
		mIsAchieved = false;
		mProgress = 0;
		mDescription = desc;
		mType = type;
		this.mBonus = bonus;
	}
	
	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public boolean ismIsAchieved() {
		return mIsAchieved;
	}

	public void setmIsAchieved(boolean mIsAchieved) {
		this.mIsAchieved = mIsAchieved;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public int getmCeiling() {
		return mCeiling;
	}

	public void setmCeiling(int mCeiling) {
		this.mCeiling = mCeiling;
	}

	public int getmProgress() {
		return mProgress;
	}

	public void setmProgress(int mProgress) {
		this.mProgress = mProgress;
	}

	public String getmType() {
		return mType;
	}

	public void incProgress() {
		mProgress++;
	}

	public int getmBonus() {
		return mBonus;
	}

	public void setmBonus(int mBonus) {
		this.mBonus = mBonus;
	}
	
	
}
