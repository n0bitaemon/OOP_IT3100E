package main;

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
}
