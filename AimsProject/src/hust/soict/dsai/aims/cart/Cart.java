package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media) {
		for (Media mediaInList : itemsOrdered) {
			if(mediaInList == media) {
				System.out.println("This media is already in the cart.");
				return;
			}
		}
		itemsOrdered.add(media);
		System.out.println("The media is added to the cart.");
	}
	
	public void removeMedia(Media media) {
		Iterator<Media> iter = itemsOrdered.iterator();
		while(iter.hasNext()) {
			Media mediaInList = iter.next();
			if(mediaInList == media) {
				iter.remove();
				System.out.println("The media has been removed.");
				return;
			}
		}
		System.out.println("No media found with title \"" + media.getTitle() + "\"");
	}
	
	public float totalCost() {
		float total = 0.0f;

		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		
		return total;
	}
	
//	public DigitalVideoDisc searchDVDById(int id) {
//		for(int i = 0; i < getQtyOrdered(); i++) {
//			DigitalVideoDisc disc = getItemsOrdered()[i];
//			if(disc.getId() == id) {
//				return disc;
//			}
//		}
//		System.out.println("No disk found with id: " + id);
//		return null;
//	}
//	
//	public DigitalVideoDisc searchDVDByTitle(String title) {
//		for(int i = 0; i < getQtyOrdered(); i++) {
//			DigitalVideoDisc disc = getItemsOrdered()[i];
//			if(disc.getTitle().equals(title)) {
//				return disc;
//			}
//		}
//		System.out.println("No disk found with title: " + title);
//		return null;
//	}
	
	public void printOrder() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			Media media = itemsOrdered.get(i);
			System.out.println(media);
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
}
