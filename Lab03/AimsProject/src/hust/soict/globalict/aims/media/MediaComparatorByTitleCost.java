package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());        //Using thenComparring that implemented in Cart
    }
}
