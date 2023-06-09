package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private static int nbCompactDisc = 0;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		super();
		assignId();
	}
	
	public CompactDisc(String title) {
		super(title);
		assignId();
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		assignId();
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		assignId();
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		assignId();
	}
	
	public void assignId() {
		nbCompactDisc++;
		setId(nbCompactDisc);
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
	
	public String toString() {
		String _title = getTitle() == null ? "" : getTitle();
		String _category = getCategory() == null ? "" : getCategory();
		String _director = getDirector() == null ? "" : getDirector();
		int _length = getLength();
		float _price = getCost();
		
		return String.format("CD - %s - %s - %s - %d: %.2f $", _title, _category, _director, _length, _price);
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
}
