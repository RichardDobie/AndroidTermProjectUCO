package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;
import java.util.Locale;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyZombieActivity extends FragmentActivity {

	ViewPager mViewPager;
	SectionsPagerAdapter mSectionsPagerAdapter;
	Fragment invFragment;
	Fragment storeFragment;
	Fragment zombieFragment;
	Fragment statsFragment;
	
	private String zombieName;
	
	private SensorManager mSensorManager;
	private float mAccel; // acceleration apart from gravity
	private float mAccelCurrent; // current acceleration including gravity
	private float mAccelLast; // last acceleration including gravity

	private final SensorEventListener mSensorListener = new SensorEventListener() {

		public void onSensorChanged(SensorEvent se) {
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2];
			mAccelLast = mAccelCurrent;
			mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
			float delta = mAccelCurrent - mAccelLast;
			mAccel = mAccel * 0.9f + delta; // perform low-cut filter
		}

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	};

	@Override
	protected void onResume() {
	  super.onResume();
	  mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
	    mSensorManager.unregisterListener(mSensorListener);
	    super.onPause();
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager);
		
		zombieName = getIntent().getStringExtra("name");
		Log.e("name", zombieName);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	    mAccel = 0.00f;
	    mAccelCurrent = SensorManager.GRAVITY_EARTH;
	    mAccelLast = SensorManager.GRAVITY_EARTH;
		
		mViewPager = (ViewPager)findViewById(R.id.viewPager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
    	
    	invFragment = new InventoryFragment();
    	storeFragment = new StoreFragment();
    	statsFragment = new StatsFragment();
    	zombieFragment = new MyZombieFragment();
    	
	}
	
	@Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.my_zombie, menu);  
        return true;  
    }  
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		CharSequence text;
		MyZombieFragment fragment = (MyZombieFragment)mSectionsPagerAdapter.getItem(0);
		switch(item.getItemId()) {
		case R.id.menu_item_set_free:
			fragment.setGameOver();
			Intent i = new Intent(this, SetFreeActivity.class);
			startActivity(i);
			return true;
		case R.id.menu_item_save:
			text = "Saved";
			Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menu_item_speed_slow:
			fragment.setSpeed(250);
			return true;
		case R.id.menu_item_speed_medium:
			fragment.setSpeed(100);
			return true;
		case R.id.menu_item_speed_fast:
			fragment.setSpeed(50);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void addItemToInventory(Item item){
		//InventoryFragment fragment = (InventoryFragment)getSupportFragmentManager().findFragmentByTag("InventoryFragment");
		InventoryFragment fragment = (InventoryFragment)mSectionsPagerAdapter.getItem(2);
		if (fragment == null){
			CharSequence chars = "NULL";
			Toast.makeText(this, chars, Toast.LENGTH_SHORT).show();
		} else {
			fragment.addToInventory(item);
		}
	}
	
	public void notifyInvChanged(){
		InventoryFragment fragment = (InventoryFragment) mSectionsPagerAdapter.getItem(2);
		fragment.notifyInvChanged();
	}
	
	public Inventory getInventory() {
		Log.e("Zomb Act", "getInventory()");
		MyZombieFragment fragment = (MyZombieFragment)mSectionsPagerAdapter.getItem(0);
		Inventory inventory = fragment.getInventory();
		return inventory;
	}
	
	public PlayerStats getPlayerStats(){
		return ((MyZombieFragment)mSectionsPagerAdapter.getItem(0)).getPlayerStats();
	}
	
		
	public class SectionsPagerAdapter extends FragmentPagerAdapter {  
		PagerTitleStrip titleStrip;
		
        public SectionsPagerAdapter(FragmentManager fm) {  
            super(fm);  
        }  
        
        
  
        @Override  
        public Fragment getItem(int position) {  
        	
        	switch (position) {  
            case 0:  
            	return zombieFragment;  
            case 1:
            	return storeFragment; 
            case 2:
                return invFragment;
            case 3:
            	return statsFragment;
        	default:
        		return zombieFragment;  
        	}
        }  
  
        @Override  
        public int getCount() {  
            return 4;  
        }  
  
        @Override  
        public CharSequence getPageTitle(int position) {  
            Locale l = Locale.getDefault();  
            switch (position) {  
            case 0:  
                return getString(R.string.title_activity_main);  
            case 1:  
            	return getString(R.string.title_store_fragment);  
            case 2:  
            	return getString(R.string.title_string_inventory);
            case 3:
            	return getString(R.string.title_stats_fragment);
            }  
            return null;  
        }  
    }


	public ArrayList<Item> storeItems() {
		MyZombieFragment fragment = (MyZombieFragment)mSectionsPagerAdapter.getItem(0);
		ArrayList<Item> items = fragment.storeItems();
		return items;
	}

	public float getmAccel() {
		return mAccel;
	}

	public void setmAccel(float mAccel) {
		this.mAccel = mAccel;
	}

	public String getZombieName() {
		return zombieName;
	}

	public void setZombieName(String zombieName) {
		this.zombieName = zombieName;
	}  
	
	
	
}