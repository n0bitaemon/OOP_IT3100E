package hust.soict.dsai.aims.cart;

import java.util.Iterator;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();//	FilteredList<Media> filteredItems = new FilteredList<>(itemsOrdered, m->true);

    FilteredList<Media> filteredItems = new FilteredList<>(itemsOrdered, m->true);

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
	
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
	
	public void filterCart(String title, boolean type) 
    {
        if (title == null || title.length() == 0) 
        {
            filteredItems.setPredicate(m->true);
        } 
        else 
        {
            if (type) 
            {
                try 
                {
                    int idValue = Integer.parseInt(title);
                    filteredItems.setPredicate(m->m.getId() == idValue);
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("The id value is invalid!");
                }
            } 
            else 
            {
                filteredItems.setPredicate(m->m.getTitle().contains(title));
            }

        }
    }
	
	public Media searchMediaById(int id) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			Media media = itemsOrdered.get(i);
			if(media.getId() == id) {
				return media;
			}
		}
		System.out.println("No media found with id: " + id);
		return null;
	}
	
	public Media searchMediaByTitle(String title){
		for(int i = 0; i < itemsOrdered.size(); i++) {
			Media media = getItemsOrdered().get(i);
			if(media.getTitle().equals(title)) {
				return media;
			}
		}
		System.out.println("No media found with title: " + title);
		return null;
	}
	
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

	public void clear() {
		itemsOrdered.clear();
	}
}
