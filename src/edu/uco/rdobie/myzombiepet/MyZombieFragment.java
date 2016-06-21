package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyZombieFragment extends Fragment {
	private ZombiePet mZombiePet;
	private Inventory mInventory;
	private PlayerStats mPlayerStats;
	private ImageView mZombieView;
	private ImageView mInventory1;
	private ImageView mInventory2;
	private ImageView mInventory3;
	private ImageView mInventory4;
	private ProgressBar mStatusBar;
	private ProgressBar mHungerBar;
	private ProgressBar mRestedBar;
	private StoreHandler mStoreHandler;
	private ArrayList<Item> mItems;
	private int mSpeed = 100;
	private boolean gameOver = false;
	private boolean free = false;
	private TextView zombName;
	
	private String mZombieName = "Amigo";
	
	private ThreadGroup myThreads = new ThreadGroup("Loops");
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mInventory = new Inventory();
		mZombiePet = new ZombiePet(mZombieName);
		mPlayerStats = new PlayerStats();
		mStoreHandler = new StoreHandler();
		mItems = mStoreHandler.getStoreItems();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_my_zombie, parent, false);
		setHasOptionsMenu(true);
		zombName = (TextView)v.findViewById(R.id.text_zombie_name);
		CharSequence c = ((MyZombieActivity)getActivity()).getZombieName();
		zombName.setText(c);
		
		mZombieView = (ImageView)v.findViewById(R.id.ZombieView);
		mZombieView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				CharSequence c;
				mZombiePet.petZombie(mPlayerStats.getmPettingBonus() + mInventory.getPettedBonus());
				mPlayerStats.incPetting();
				c = mPlayerStats.checkAchievements();
				if (c != null) {
					Toast.makeText(getActivity(), c, Toast.LENGTH_SHORT).show();
					//int i = mPlayerStats.completedAchievements.size() - 1;
					//((MyZombieActivity)getActivity()).addItemToInventory(mItems.get(i));
				}
			}
			
		});
		
		mInventory1 = (ImageView)v.findViewById(R.id.inventory1);
		mInventory1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				int i = mZombiePet.getmRested();
				i += 10;
				mZombiePet.setmRested(i);
				
			}
			
		});
		
		mInventory2 = (ImageView)v.findViewById(R.id.inventory2);
		mInventory2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				int i = mZombiePet.getmHunger();
				i += 10;
				mZombiePet.setmHunger(i);
				
			}
			
		});
		
		mInventory3 = (ImageView)v.findViewById(R.id.inventory3);
		mInventory3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				int i = mZombiePet.getmRested();
				i += 10;
				mZombiePet.setmRested(i);
				
			}
			
		});
		
		mInventory4 = (ImageView)v.findViewById(R.id.inventory4);
		mInventory4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				int i = mZombiePet.getmHunger();
				i += 10;
				mZombiePet.setmHunger(i);
				
			}
			
		});
		
		mStatusBar = (ProgressBar)v.findViewById(R.id.happy_sad_bar);
		mHungerBar = (ProgressBar)v.findViewById(R.id.Hunger_bar);
		mRestedBar = (ProgressBar)v.findViewById(R.id.tired_bar);
		
		updateInvImages();
		
		new Thread(myThreads, new Looper(), "Looper").start();
		
		return v;
	}	
	
	public Inventory getInventory() {
		Log.e("Zomb Frag", "getInventory()");
		return mInventory;
	}
	
	public void updateInvImages() {
		mInventory1.setImageResource(mInventory.getSlot1Image());
		mInventory2.setImageResource(mInventory.getSlot2Image());
		mInventory3.setImageResource(mInventory.getSlot3Image());
		mInventory4.setImageResource(mInventory.getSlot4Image());
		
	}
	
	public void resetFragment(){
		
	}
	
	public PlayerStats getPlayerStats(){
		return this.mPlayerStats;
	}
	
	public ArrayList<Item> storeItems(){
		return mItems;
	}
	
	
	public class Looper implements Runnable {

		@Override
		public void run() {
		
			try {
				while (!gameOver) {
					mZombiePet.updateZombie();
					if (mZombiePet.getmStatus() <= 0){
						gameOver = true;
					}
					
					int happyBonus = mInventory.getHappyBonus();
					int hungryBonus = mInventory.getHungerBonus();
					int tiredBonus = mInventory.getTiredBonus();
					int pettingBonus = mInventory.getPettedBonus();
					
					mZombiePet.setmStatus(mZombiePet.getmStatus() + happyBonus);
					mZombiePet.setmHunger(mZombiePet.getmHunger() + hungryBonus);
					mZombiePet.setmRested(mZombiePet.getmRested() + tiredBonus);
					
					mPlayerStats.setmHappyBonus(mPlayerStats.getmHappyBonus() + happyBonus);
					mPlayerStats.setmHungerBonus(mPlayerStats.getmHungerBonus() + hungryBonus);
					mPlayerStats.setmTiredBonus(mPlayerStats.getmTiredBonus() + tiredBonus);
					mPlayerStats.setmPettingBonus(mPlayerStats.getmPettingBonus() + pettingBonus);
					if (((MyZombieActivity)getActivity()).getmAccel() > 4){
						mZombiePet.setmStatus(mZombiePet.getmStatus() - 3500);
					}
					updateInvImages();
					
					new Thread(new Runnable() {
						@Override
						public void run() {
							mStatusBar.setProgress(mZombiePet.getmStatus() / 100);
							mHungerBar.setProgress(mZombiePet.getmHunger() / 100);
							mRestedBar.setProgress(mZombiePet.getmRested() / 100);
							
						}
				
					}).start();
					Thread.sleep(mSpeed);
				}
				if (!free){ 
				Intent i = new Intent(getActivity(), GameOverActivity.class);
				startActivity(i);
				}
			} catch (Exception e) {
			
			}
		}
	
	}


	public void setSpeed(int i) {
		mSpeed = i;
		
	}

	public void setGameOver() {
		gameOver = true;
		free = true;
		
	}
}
