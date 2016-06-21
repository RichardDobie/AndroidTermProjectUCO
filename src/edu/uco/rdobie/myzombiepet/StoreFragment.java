package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.Toast;

public class StoreFragment extends ListFragment {
	private StoreHandler mStoreHandler;
	private ArrayList<Item> mItems;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mStoreHandler = new StoreHandler();
		mItems = mStoreHandler.getStoreItems();
		StoreAdapter adapter = new StoreAdapter(mItems);
		setListAdapter(adapter);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = super.onCreateView(inflater, parent, savedInstanceState);
		
		ListView listView = (ListView)v.findViewById(android.R.id.list);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				return false;
			}

			@Override
			public boolean onCreateActionMode(ActionMode arg0, Menu arg1) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onDestroyActionMode(ActionMode arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean onPrepareActionMode(ActionMode arg0, Menu arg1) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onItemCheckedStateChanged(ActionMode arg0, int arg1,
					long arg2, boolean arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		return v;
	}
	
	public void onListItemClick(ListView l, View v, int position, long id){
		Item i = ((StoreAdapter)getListAdapter()).getItem(position);
		
		((MyZombieActivity)getActivity()).addItemToInventory(i);
		mStoreHandler.removeItem(i);
		((StoreAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	public class StoreAdapter extends ArrayAdapter<Item> {
		public StoreAdapter(ArrayList<Item> items){
			super(getActivity(), android.R.layout.simple_list_item_1, items);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_store, null);
			}
			
			Item i = getItem(position);
			
			TextView nameTextView = (TextView)convertView.findViewById(R.id.store_text_view_name);
			nameTextView.setText(i.getmName());
			TextView descTextView = (TextView)convertView.findViewById(R.id.store_text_view_description);
			descTextView.setText(i.getmDescription());
			TextView priceTextView = (TextView)convertView.findViewById(R.id.store_text_view_price);
			priceTextView.setText(Integer.toString(i.getmPrice()));
			
			return convertView;
			
		}
	}
}
