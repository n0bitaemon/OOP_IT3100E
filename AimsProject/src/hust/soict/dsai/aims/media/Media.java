package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private static int nbMedia = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost);
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator.comparing(Media::getCost).thenComparing(Media::getTitle);
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media() {
		assignId();
	}
	
	public Media(String title) {
		setTitle(title);;
		assignId();
	}
	
	public Media(String title, String category, float cost) {
		setTitle(title);
		setCategory(category);
		setCost(cost);
		assignId();
	}
	
	public void assignId() {
		nbMedia++;
		setId(nbMedia);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Media))
			return false;
		
		Media media = (Media) o;
		return media.getTitle().equals(getTitle());
	}
	
}
