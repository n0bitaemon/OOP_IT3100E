package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost, List<Track> tracks) {
		super(title, category, director, length, cost);
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		for (Track trackInList : tracks) {
			if(trackInList == track) {
				System.out.println("This track is already exist in the disk.");
				return;
			}
		}
		tracks.add(track);
	}
	
	public void removeTrack(Track track) {
		Iterator<Track> iter = tracks.iterator();
		while(iter.hasNext()) {
			Track curTrack = iter.next();
			if(curTrack == track) {
				iter.remove();
				return;
			}
		}
		System.out.println("No track found.");
	}
	
	@Override
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
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

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Play CD: " + getTitle());
		for (Track track : tracks) {
			track.play();
		}
	}
	
	public String toString() {
		String _title = getTitle() == null ? "" : getTitle();
		String _category = getCategory() == null ? "" : getCategory();
		String _director = getDirector() == null ? "" : getDirector();
		StringBuilder _tracks = new StringBuilder();
		for (Track track : tracks) {
			_tracks.append(track.getTitle());
			_tracks.append("; ");
		}
		int _length = getLength();
		float _price = getCost();
		
		return String.format("*****CD*****\n"
				+ "Title: %s\n"
				+ "Category: %s\n"
				+ "Director: %s\n"
				+ "Length: %d\n"
				+ "Tracks: %s\n"
				+ "Price: %.2f $\n", _title, _category, _director, _length, _tracks, _price);
	}
}
