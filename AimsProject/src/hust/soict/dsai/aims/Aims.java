package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static final int MAIN_MENU = 1;
	private static final int STORE_MENU = 2;
	private static final int MEDIA_MENU = 3;
	private static final int CART_MENU = 4;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		int menu = 1; //1: Main, 2: Store, 3: MediaDetail, 4: Cart
		
		Store store = new Store();
		Cart cart = new Cart();
		Media currentMedia = null;
		
		Media md1 = new Book("The forest book", "natural", 12.53f);
		Media md2 = new DigitalVideoDisc("DVD1");
		Media md3 = new CompactDisc("CD1");
		
		store.addMedia(md1);
		store.addMedia(md2);
		store.addMedia(md3);
		
		showMenu();
		while(menu != 0) {
			try {
				option = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid input!");
				continue;
			}
			if(menu == MAIN_MENU) {
				switch (option) {
				case 0: {
					menu = 0;
					break;
				}
				case 1: {
					store.printStore();
					storeMenu();
					menu = STORE_MENU;
					break;
				}
				case 2: {
					updateStoreMenu();
					int update_option = Integer.parseInt(sc.nextLine());
					if(update_option == 1) {
						// Creating
						chooseMediaTypeMenu();
						int mediaType_option = Integer.parseInt(sc.nextLine());
						if(mediaType_option != 1 && mediaType_option != 2 && mediaType_option != 3) {
							System.out.println("Invalid media type!");
							continue;
						}
						
						Media media = inputMedia(mediaType_option, sc);
						if(media != null) {
							Media mediaCheck = store.searchMediaByTitle(media.getTitle());
							if(mediaCheck == null) {
								store.addMedia(media);
								System.out.println("The media is added.");
							}else {
								System.out.println("Title must be unique!");
							}
						}
					}else if(update_option == 2) {
						// Removing
						System.out.println("Enter title: ");
						String title = sc.nextLine();
						Media media = store.searchMediaByTitle(title);
						if(media != null) {
							store.removeDVD(media);
							System.out.println("The media is removed.");
						}else {
							System.out.println("No media with that title!");
							continue;
						}
					}else if(update_option == 0) {
						continue;
					}else {
						System.out.println("Invalid option!");
						continue;
					}
					break;
				}
				case 3: {
					cart.printOrder();
					cartMenu();
					menu = CART_MENU;
					break;
				}
				default:
					System.out.println("Invalid input!");
					continue;
				}
			}else if(menu == STORE_MENU) {
				switch (option) {
				case 0: {
					showMenu();
					menu = MAIN_MENU;
					break;
				}
				case 1: {
					System.out.println("Enter title: ");
					String title = sc.nextLine();
					Media media = store.searchMediaByTitle(title);
					if(media != null) {
						System.out.println(media);
						menu = MEDIA_MENU;
						currentMedia = media;
						mediaDetailsMenu();
					}
					break;
				}
				case 2: {
					System.out.println("Enter title: ");
					String title = sc.nextLine();
					
					Media media = store.searchMediaByTitle(title);
					if(media != null) {
						cart.addMedia(media);
					}
					break;
				}
				case 3: {
					System.out.println("Enter title: ");
					String title = sc.nextLine();
					
					Media media = store.searchMediaByTitle(title);
					if(media instanceof Playable) {
						// can play
						((Playable) media).play();
					}else {
						System.out.println("Cannot play this media.");
					}
					break;
				}
				case 4: {
					cart.printOrder();
					cartMenu();
					menu = CART_MENU;
					break;
				}
				default:
					System.out.println("Invalid input!");
					continue;
				}
			}else if(menu == MEDIA_MENU) {
				switch (option) {
				case 0: {
					storeMenu();
					menu = STORE_MENU;
					break;
				}
				case 1: {
					if(currentMedia != null) {
						cart.addMedia(currentMedia);
					}
					break;
				}
				case 2: {
					if(currentMedia != null) {
						if(currentMedia instanceof Playable) {
							((Playable) currentMedia).play();
						}else {
							System.out.println("Cannot play this media.");
						}
					}
					break;
				}
				default: 
					System.out.println("Invalid input!");
					continue;
				}
			}else if(menu == CART_MENU) {
				switch (option) {
				case 0: {
					showMenu();
					menu = MAIN_MENU;
					break;
				}
				case 1: {
					filterCartMenu();
					int filter_option;
					try {
						filter_option = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Invalid input!");
						continue;
					}
					
					Media media = null;
					if(filter_option == 1) {
						System.out.println("Enter ID: ");
						int id = Integer.parseInt(sc.nextLine());
						media = cart.searchMediaById(id);
					}else if(filter_option == 2) {
						System.out.println("Enter title: ");
						String title = sc.nextLine();
						media = cart.searchMediaByTitle(title);
					}else if(filter_option == 0) {
						continue;
					}else {
						System.out.println("Invalid option!");
						continue;
					}

					if(media != null) {
						System.out.println(media);
					}
					
					break;
				}
				case 2: {
					sortCartMenu();
					int sort_option;
					ArrayList<Media> mediasInCart = cart.getItemsOrdered();
					
					try {
						sort_option = Integer.parseInt(sc.nextLine());
					}catch (Exception e) {
						System.out.println("Invalid input!");
						continue;
					}
					
					if(sort_option == 1) {
						Collections.sort(mediasInCart, Media.COMPARE_BY_TITLE_COST);
					}else if(sort_option == 2) {
						Collections.sort(mediasInCart, Media.COMPARE_BY_COST_TITLE);
					}else if(sort_option == 0){
						continue;
					}else {
						System.out.println("Invalid option!");
						continue;
					}

					for (Media media : mediasInCart) {
						System.out.println(media);
					}
					break;
				}
				case 3: {
					String title = sc.nextLine();
					Media media = cart.searchMediaByTitle(title);
					if(media != null) {
						cart.removeMedia(media);
					}
					break;
				}
				case 4: {
					String title = sc.nextLine();
					Media media = cart.searchMediaByTitle(title);
					if(media != null) {
						if(media instanceof Playable) {
							((Playable) media).play();
						}else {
							System.out.println("Cannot play this media.");
						}
					}
					break;
				}
				case 5: {
					System.out.println("Your order is coming!");
					break;
				}
				default:
					System.out.println("Invalid input!");
					continue;
				}
			}
		}
		
		sc.close();
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
	
	public static void sortCartMenu() {
		System.out.println("Sort by: ");
		System.out.println("--------------------------------");
		System.out.println("1. Title");
		System.out.println("2. Cost");
		System.out.println("0. Cancle");
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void filterCartMenu() {
		System.out.println("Filter by: ");
		System.out.println("--------------------------------");
		System.out.println("1. ID");
		System.out.println("2. Title");
		System.out.println("0. Cancle");
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void updateStoreMenu() {
		System.out.println("Update by: ");
		System.out.println("--------------------------------");
		System.out.println("1. Creating media");
		System.out.println("2. Removing media");
		System.out.println("0. Cancle");
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void chooseMediaTypeMenu() {
		System.out.println("Choose type: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DVD");
		System.out.println("3. CD");
		System.out.println("0. Cancle");
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static Media inputMedia(int type, Scanner sc) {
		System.out.println("Input title: ");
		String title = sc.nextLine();
		System.out.println("Input category: ");
		String category = sc.nextLine();
		System.out.println("Input cost: ");
		Float cost = Float.parseFloat(sc.nextLine());

		Media media = null;
		if(type == 1) {
			media = new Book(title, category, cost);
		}else if(type == 2) {
			media = new DigitalVideoDisc(title, category, cost);
		}else if(type == 3) {
			media = new CompactDisc(title, category, cost);
		}
		
		return media;
	}

}
