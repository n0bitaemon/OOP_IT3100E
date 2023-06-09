package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track() {
		
	}
	
	public Track(String title, int length) {
		setTitle(title);
		setLength(length);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void play() {
		System.out.println("Play Track: " + getTitle());
	}
	
	
	
}
