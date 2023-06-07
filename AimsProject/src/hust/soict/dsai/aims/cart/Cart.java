package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(getQtyOrdered() < MAX_NUMBERS_ORDERED) {
			getItemsOrdered()[getQtyOrdered()] = disc;
			setQtyOrdered(getQtyOrdered() + 1);
			System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
			if(getQtyOrdered() == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full.");
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc[] dvdList = new DigitalVideoDisc[2];
		dvdList[0] = dvd1;
		dvdList[1] = dvd2;
		
		addDigitalVideoDisc(dvdList);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if(getQtyOrdered() == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full, cannot add more disk.");
			}
			addDigitalVideoDisc(disc);
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc newItemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		int k = 0;
		for(int i = 0; i < getQtyOrdered(); i++) {
			DigitalVideoDisc curDisk = getItemsOrdered()[i];
			if(disc.equals(curDisk)) {
				setQtyOrdered(getQtyOrdered() - 1);
				System.out.println("The disk \"" + disc.getTitle() + "\" has been removed.");
				continue;
			}
			newItemsOrdered[k] = curDisk;
			k += 1;
		}
	}
	
	public float totalCost() {
		float total = 0.0f;
		
		for(int i = 0; i < getQtyOrdered(); i++) {
			total += getItemsOrdered()[i].getCost();
		}
		
		return total;
	}
	
	public DigitalVideoDisc searchDVDById(int id) {
		for(int i = 0; i < getQtyOrdered(); i++) {
			DigitalVideoDisc disc = getItemsOrdered()[i];
			if(disc.getId() == id) {
				return disc;
			}
		}
		System.out.println("No disk found with id: " + id);
		return null;
	}
	
	public DigitalVideoDisc searchDVDByTitle(String title) {
		for(int i = 0; i < getQtyOrdered(); i++) {
			DigitalVideoDisc disc = getItemsOrdered()[i];
			if(disc.getTitle().equals(title)) {
				return disc;
			}
		}
		System.out.println("No disk found with title: " + title);
		return null;
	}
	
	public void printOrder() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < getQtyOrdered(); i++) {
			DigitalVideoDisc disc = getItemsOrdered()[i];
			System.out.println(disc);
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
}
