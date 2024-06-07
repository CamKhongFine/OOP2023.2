package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        return Double.compare(m2.getCost(),m1.getCost());                //Using thenComparring that implemented in Cart
    }
}
