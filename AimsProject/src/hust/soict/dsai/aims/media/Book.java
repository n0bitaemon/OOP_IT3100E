package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private static int nbBook = 0;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
		assignId();
	}
	
	public Book(String title) {
		super(title);
		assignId();
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		assignId();
	}
	
	public void assignId() {
		nbBook++;
		setId(nbBook);
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("This author is already assigned in this book.");
			return;
		}
		authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println("This is not an author of this book.");
			return;
		}
		authors.remove(authorName);
	}
}