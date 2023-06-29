package hust.soict.dsai.aims.store;

import java.util.Iterator;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
	private ObservableList<Media> itemsInStore;

    public Store() {
        itemsInStore = FXCollections.observableArrayList();
    }
	
    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
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
	
	public Media searchMediaByTitle(String title){
		for(int i = 0; i < itemsInStore.size(); i++) {
			Media media = getItemsInStore().get(i);
			if(media.getTitle().equals(title)) {
				return media;
			}
		}
		System.out.println("No media found with title: " + title);
		return null;
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
