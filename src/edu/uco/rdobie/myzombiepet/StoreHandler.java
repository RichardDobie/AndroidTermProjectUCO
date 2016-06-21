package edu.uco.rdobie.myzombiepet;

import java.util.ArrayList;

public class StoreHandler {
	private ArrayList<Item> mItems;
	
	public StoreHandler() {
		mItems = new ArrayList<Item>();
		
		mItems.add(new Item("Brains", "Your Zombie's Favorite Food... For Now", 5, 0, 0, 0, R.drawable.mz_item_brains));
		mItems.add(new Item("Chew Toy", "A Toy to Keep Your Zombie Occupied", 0, 5, 0, 0, R.drawable.mz_item_chewtoy));
		mItems.add(new Item("TV", "Your Zombie is Happier when it's watcing TV", 0, 2, 2, 0, R.drawable.mz_item_tv ));
		mItems.add(new Item("Pillow", "Zombie is more Rested", 0, 0, 5, 0, R.drawable.mz_item_pillow));
		mItems.add(new Item("Brush", "Petting your zombie is more effective", 0, 0, 0, 2, R.drawable.mz_item_brush));
		mItems.add(new Item("Nanny", "Hire a Nanny to help take care of your Zombie",2, 2, 2, 0, R.drawable.mz_item_nanny));
		
	}
	
	public ArrayList<Item> getStoreItems(){
		return mItems;
	}
	
	public void removeItem(Item item){
		mItems.remove(item);
	}
}
