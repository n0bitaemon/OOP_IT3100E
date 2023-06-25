package hust.soict.dsai.book;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("This author is already in this book.");
			return;
		}
		
		authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println("This author is not in this book.");
			return;
		}
		
		authors.remove(authorName);
	}
	
}
