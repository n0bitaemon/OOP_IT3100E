package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private List<DigitalVideoDisc> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<DigitalVideoDisc>();
	}
	
	public List<DigitalVideoDisc> getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(List<DigitalVideoDisc> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	public void addDVD(DigitalVideoDisc dvd) {
		if(dvd != null)
			getItemsInStore().add(dvd);
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		Iterator<DigitalVideoDisc> iter = getItemsInStore().iterator();
		while(iter.hasNext()) {
			DigitalVideoDisc disc = iter.next();
			if(disc == dvd)
				iter.remove();
		}
	}
	
	public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store Items:");
		for(int i = 0; i < getItemsInStore().size(); i++) {
			DigitalVideoDisc disc = getItemsInStore().get(i);
			System.out.println(disc);
		}
		System.out.println("***************************************************");
	}
}
