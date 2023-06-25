package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
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
	
	public String toString() {
		String _title = getTitle() == null ? "" : getTitle();
		String _category = getCategory() == null ? "" : getCategory();
		StringBuilder _authors = new StringBuilder();
		for (String author : authors) {
			_authors.append(author);
			_authors.append("; ");
		}
		float _price = getCost();
		
		return String.format("******Book******\n"
				+ "Title: %s\n"
				+ "Category: %s\n"
				+ "Authors: %s\n"
				+ "Price: %.2f $\n", _title, _category, _authors, _price);
	}
}
