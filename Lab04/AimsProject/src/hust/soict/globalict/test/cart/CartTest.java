package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin" +
                "n", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 20.34f);
        anOrder.addMedia(dvd3);
        anOrder.addMedia(dvd4);

        anOrder.sortByTitle();
        anOrder.printList();
        anOrder.searchByTitle("Aladin");
    }
}
