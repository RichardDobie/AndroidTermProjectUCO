package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class StatsFragment extends Fragment {
	private TextView mTimesPetted;
	private TextView mHappyBonus;
	private TextView mHungryBonus;
	private TextView mTiredBonus;
	private TextView mPettingBonus;
	private PlayerStats mPlayerStats;
	private ListView mAchievementsView;
	private AchievementsAdapter mAdapter;
	private ArrayList<Achievement> mAchievements;
	private TextView mNumAchievements;
	private TextView mItemsEquipped;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mPlayerStats = ((MyZombieActivity)getActivity()).getPlayerStats();
		mAchievements = mPlayerStats.completedAchievements;
		mAdapter = new AchievementsAdapter(mAchievements);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_stats, parent, false);

		
		
		CharSequence text = Integer.toString(mPlayerStats.getmTimesPetted());
		mTimesPetted = (TextView)v.findViewById(R.id.text_view_times_petted);
		mTimesPetted.setText(text);
		
		text = Integer.toString(mPlayerStats.getmNumAchievements());
		mNumAchievements = (TextView)v.findViewById(R.id.stats_ach_earned);
		mNumAchievements.setText(text);
		
		text = Integer.toString(mPlayerStats.getmItemsEquipped());
		mItemsEquipped = (TextView)v.findViewById(R.id.stats_items_equipped);
		mItemsEquipped.setText(text);
		
		text = Integer.toString(mPlayerStats.getmHappyBonus());
		mHappyBonus = (TextView)v.findViewById(R.id.stats_happy_bonus);
		mHappyBonus.setText(" +" + text);
		
		text = Integer.toString(mPlayerStats.getmHappyBonus());
		mHungryBonus = (TextView)v.findViewById(R.id.stats_hunger_bonus);
		mHungryBonus.setText(" +" + text);
		
		text = Integer.toString(mPlayerStats.getmTiredBonus());
		mTiredBonus = (TextView)v.findViewById(R.id.stats_tired_bonus);
		mTiredBonus.setText(" +" + text);
		
		text = Integer.toString(mPlayerStats.getmPettingBonus());
		mPettingBonus = (TextView)v.findViewById(R.id.stats_petting_bonus);
		mPettingBonus.setText(" +" + text);
		
		mAchievementsView = (ListView)v.findViewById(R.id.achievements_view);
		mAchievementsView.setAdapter(mAdapter);
		
		
		return v;
	
		
	}
	
	private class AchievementsAdapter extends ArrayAdapter<Achievement> {
		public AchievementsAdapter(ArrayList<Achievement> items){
			super(getActivity(), android.R.layout.simple_list_item_2, items);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_achievements, null);
			}
			
			Achievement i = getItem(position);
			
			TextView nameTextView = (TextView)convertView.findViewById(R.id.ach_text_view_name);
			nameTextView.setText(i.getmTitle());
			TextView descTextView = (TextView)convertView.findViewById(R.id.ach_text_view_description);
			descTextView.setText(i.getmDescription());
			
			return convertView;
			
		}
	}
}
