package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Cart {


    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public float totalCost() {
        double sumCost = 0;
        for(Media ite : itemsOrdered) {
            sumCost += ite.getCost();
        }
        return (float)sumCost;
    }

    public void addMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            System.out.println("Item exist");
            return;
        };
        itemsOrdered.add(media);
        System.out.println("Media added");
    }

    public void removeMedia(Media media) {
        if(!itemsOrdered.contains(media)) {
            System.out.println("Cart not include this media");
            return;
        }
        itemsOrdered.remove(media);
        System.out.println("Media removed");
    }

    public void printList() {
        double totalCost = 0;
        int i = 0;
        System.out.println("***********************CART***********************");
        for(Media ite : itemsOrdered) {
            System.out.println((i + 1) + ". " + ite.toString());
            totalCost += ite.getCost();
            i++;
        }
        System.out.print("Total Cost: ");
        System.out.printf("%.2f \n", totalCost);
        System.out.println("***************************************************");
    }

    public void searchByTitle(String title) {
        for(Media ite : itemsOrdered) {
            if(ite.getTitle().equals(title)) {
                System.out.println(ite);
                return;
            }
        }
        System.out.println("No matched title found");
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST.thenComparing(Media.COMPARE_BY_COST_TITLE));
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE.thenComparing(Media.COMPARE_BY_TITLE_COST));
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
