package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media added");
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
        System.out.println("Media remove");
    }

    @Override
    public String toString() {
        return "Store{" +
                "itemsInStore=" + itemsInStore +
                '}';
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
