package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.MultiChoiceModeListener;

public class InventoryFragment extends ListFragment {
	private InventoryHandler mInventoryHandler;
	private ArrayList<Item> mItems;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mInventoryHandler = new InventoryHandler();
		mItems = mInventoryHandler.getInventoryItems();
		InventoryAdapter adapter = new InventoryAdapter(mItems);
		setListAdapter(adapter);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = super.onCreateView(inflater, parent, savedInstanceState);
		
		ListView listView = (ListView)v.findViewById(android.R.id.list);
		registerForContextMenu(listView);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				switch (item.getItemId()) {
					case R.id.inventory_slot_1:
						mode.finish();
						return true;
				}
				return false;
			}

			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				MenuInflater inflater = mode.getMenuInflater();
				inflater.inflate(R.menu.context_menu_inventory, menu);
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
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		getActivity().getMenuInflater().inflate(R.menu.context_menu_inventory, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem i) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)i.getMenuInfo();
		int position = info.position;
		InventoryAdapter adapter = (InventoryAdapter)getListAdapter();
		Item item = adapter.getItem(position);
		
		Inventory inventory;
		inventory = ((MyZombieActivity)getActivity()).getInventory();
		Item anItem;
		PlayerStats playerStats;
		playerStats = ((MyZombieActivity)getActivity()).getPlayerStats();
		CharSequence c;
		int j;
		switch (i.getItemId()) {
		case R.id.inventory_slot_1:
			Log.e("InvFrag", "inserting " + item.getmName() + " into 1");
			playerStats.incEquip();
			inventory.setSlot1(item); 
			c = playerStats.checkAchievements();
			j = playerStats.completedAchievements.size() - 1;
			//anItem = ((MyZombieActivity)getActivity()).storeItems().get(j);
			//((MyZombieActivity)getActivity()).addItemToInventory(anItem);
			if (c != null) Toast.makeText(getActivity(), c, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.inventory_slot_2:
			Log.e("InvFrag", "inserting " + item.getmName() + " into 2");
			inventory = ((MyZombieActivity)getActivity()).getInventory();
			inventory.setSlot2(item);
			playerStats.incEquip();
			c = playerStats.checkAchievements();
			j = playerStats.completedAchievements.size() - 1;
			//anItem = ((MyZombieActivity)getActivity()).storeItems().get(j);
			//((MyZombieActivity)getActivity()).addItemToInventory(anItem);
			if (c != null) Toast.makeText(getActivity(), c, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.inventory_slot_3:
			Log.e("InvFrag", "inserting " + item.getmName() + " into 3");
			inventory = ((MyZombieActivity)getActivity()).getInventory();
			inventory.setSlot3(item);
			playerStats.incEquip();
			c = playerStats.checkAchievements();
			j = playerStats.completedAchievements.size() - 1;
			//anItem = ((MyZombieActivity)getActivity()).storeItems().get(j);
			//((MyZombieActivity)getActivity()).addItemToInventory(anItem);
			if (c != null) Toast.makeText(getActivity(), c, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.inventory_slot_4:
			Log.e("InvFrag", "inserting " + item.getmName() + " into 4");
			inventory = ((MyZombieActivity)getActivity()).getInventory();
			inventory.setSlot4(item);
			playerStats.incEquip();
			c = playerStats.checkAchievements();
			j = playerStats.completedAchievements.size() - 1;
			//anItem = ((MyZombieActivity)getActivity()).storeItems().get(j);
			//((MyZombieActivity)getActivity()).addItemToInventory(anItem);
			if (c != null) Toast.makeText(getActivity(), c, Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onContextItemSelected(i);
		
	}
	
	public void addToInventory(Item item){
		mInventoryHandler.addToInventory(item);
		((InventoryAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	public void notifyInvChanged(){
		((InventoryAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	public class InventoryAdapter extends ArrayAdapter<Item> {
		public InventoryAdapter(ArrayList<Item> items){
			super(getActivity(), android.R.layout.simple_list_item_1, items);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_inventory, null);
			}
			
			Item i = getItem(position);
			
			TextView nameTextView = (TextView)convertView.findViewById(R.id.ach_text_view_name);
			nameTextView.setText(i.getmName());
			TextView descTextView = (TextView)convertView.findViewById(R.id.ach_text_view_description);
			descTextView.setText(i.getmDescription());
			
			return convertView;
			
		}
	}
}
