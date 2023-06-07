package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	private static int nbDigitalVideoDisc = 0;
	
	public DigitalVideoDisc() {
		super();
		assignId();
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
		assignId();
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		assignId();
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		assignId();
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		assignId();
	}
	
	public void assignId() {
		nbDigitalVideoDisc++;
		setId(nbDigitalVideoDisc);
	}
	
	public String toString() {
		String _title = getTitle() == null ? "" : getTitle();
		String _category = getCategory() == null ? "" : getCategory();
		String _director = getDirector() == null ? "" : getDirector();
		int _length = getLength();
		float _price = getCost();
		
		return String.format("DVD - %s - %s - %s - %d: %.2f $", _title, _category, _director, _length, _price);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		DigitalVideoDisc disc_obj = (DigitalVideoDisc) obj;
		return getId() == disc_obj.getId() && getTitle().equals(disc_obj.getTitle()) 
				&& getCategory().equals(disc_obj.getTitle())
				&& getDirector() == disc_obj.getDirector()
				&& getLength() == disc_obj.getLength()
				&& getCost() == disc_obj.getCost();
	}
	
}



