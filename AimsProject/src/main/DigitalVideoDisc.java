package main;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDisc = 0;
	
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc() {
		assignId();
	}
	
	public DigitalVideoDisc(String title) {
		super();
		assignId();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		assignId();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		assignId();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		assignId();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	public void assignId() {
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	
	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String toString() {
		String _title = getTitle() == null ? "" : getTitle();
		String _category = getCategory() == null ? "" : getCategory();
		String _director = getDirector() == null ? "" : getDirector();
		int _length = getLength();
		float _price = getCost();
		
		return String.format("DVD - %s - %s - %s - %d: %.2f $", _title, _category, _director, _length, _price);
	}
	
}



