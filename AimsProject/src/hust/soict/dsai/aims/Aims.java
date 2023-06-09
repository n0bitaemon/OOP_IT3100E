package hust.soict.dsai.aims;

import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		int menu = 1; //1: Main, 2: Store, 3: MediaDetail, 4: Cart
		
		while(true) {
			System.out.println("Your option: ");
			option = sc.nextInt();
			if(option == 0) {
				if(menu == 1) {
					break;
				}else {
					menu = 1;
					continue;
				}
			}
			
			if(menu == 1) {
				switch (option) {
				case 1: {
					System.out.println("View store");
					menu = 2;
					break;
				}
				case 2: {
					System.out.println("Update store");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			}
		}
	}
	
	public static void showMenu() {
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
	}
	
	public static void storeMenu() {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back");
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
	}

}
