package edu.uco.rdobie.myzombiepet;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class PagerActivity extends FragmentActivity {
	ViewPager mViewPager;
	SectionsPagerAdapter mSectionsPagerAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		
		mViewPager = (ViewPager)findViewById(R.id.viewPager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}
	
	@Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.my_zombie, menu);  
        return true;  
    }  
	
	public class SectionsPagerAdapter extends FragmentPagerAdapter {  
		  
        public SectionsPagerAdapter(FragmentManager fm) {  
            super(fm);  
        }  
  
        @Override  
        public Fragment getItem(int position) {  
        	switch (position) {  
            case 0:  
                return new StoreFragment();  
            case 1:  
                return new MyZombieFragment();
            case 2:  
                return new StatsFragment();
            }  
            return new MyZombieFragment();  
        }  
  
        @Override  
        public int getCount() {  
            return 3;  
        }  
  
        @Override  
        public CharSequence getPageTitle(int position) {  
            Locale l = Locale.getDefault();  
            switch (position) {  
            case 0:  
                return getString(R.string.text_string_inventory).toUpperCase(l);  
            case 1:  
                return getString(R.string.app_name).toUpperCase(l);  
            case 2:  
                return getString(R.string.title_activity_main).toUpperCase(l);  
            }  
            return null;  
        }  
    }  
}
		
		