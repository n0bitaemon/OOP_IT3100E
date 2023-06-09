package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<Media>();
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	public void addMedia(Media media) {
		if(media != null)
			getItemsInStore().add(media);
	}
	
	public void removeDVD(Media media) {
		Iterator<Media> iter = getItemsInStore().iterator();
		while(iter.hasNext()) {
			Media mediaInList = iter.next();
			if(mediaInList == media)
				iter.remove();
		}
	}
	
	public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store Items:");
		for(int i = 0; i < getItemsInStore().size(); i++) {
			Media media = getItemsInStore().get(i);
			System.out.println(media);
		}
		System.out.println("***************************************************");
	}
}
