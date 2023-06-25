package hust.soict.dsai.aims.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		if(o1.getCost() != o2.getCost()) {
			return (int) (o1.getCost() - o2.getCost());
		}
		return o1.getTitle().compareTo(o2.getTitle());
	}
	
}
