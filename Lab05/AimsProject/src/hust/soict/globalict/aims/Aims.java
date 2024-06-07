package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.test.screen.customer.store.TestViewStoreScreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        showMenu(store, cart);
        JavaFx(store, cart);
    }

    public static void showMenu(Store store, Cart cart) {
        boolean flag = true;
        while(flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("4. JavaFX GUI");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4: ");
            short option = scanner.nextShort();
            scanner.nextLine();                //Receive the newline input from nextShort
            switch (option) {
                case 1:
                    storeMenu(store, cart);
                    break;
                case 2:
                    System.out.println("1. Add Media");
                    System.out.println("2. Remove Media");
                    System.out.println("3. Return");
                    short choice = scanner.nextShort();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("1. Book");
                            System.out.println("2. Compact Disc");
                            System.out.println("3. Digital Video Disc");
                            System.out.println("4. Return");
                            short choice2 = scanner.nextShort();
                            scanner.nextLine();
                            switch (choice2) {
                                case 1:
                                    createBook(store);
                                    break;
                                case 2:
                                    createCD(store);
                                    break;
                                case 3:
                                    createDVD(store);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Enter title of media to remove: ");
                            String title = scanner.nextLine();
                            for(Media ite : store.getItemsInStore()) {
                                if (ite.getTitle().equalsIgnoreCase(title)) {
                                    store.removeMedia(ite);
                                    break;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    cartMenu(store, cart);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public static void storeMenu(Store store, Cart cart) {
        boolean flag = true;
        while(flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4: ");
            short option = scanner.nextShort();
            scanner.nextLine();               //Receive the newline input from nextShort
            switch (option) {
                case 1:
                    System.out.println("Enter the title of the media you want: ");
                    String wantedTitle = scanner.nextLine();
                    boolean check = true;
                    for(Media ite : store.getItemsInStore()) {
                        if(ite.getTitle().equalsIgnoreCase(wantedTitle)) {
                            System.out.println(ite.toString());
                            check = false;
                            mediaDetailsMenu(store, cart, ite);
                            break;
                        }
                    }
                    if(check) System.out.println("Media not found in store");
                    break;
                case 2:
                    System.out.println("Enter the title of the media you want to add to cart: ");
                    String seeTitle = scanner.nextLine();
                    for(Media ite : store.getItemsInStore()) {
                        if(ite.getTitle().equalsIgnoreCase(seeTitle)) {
                            cart.addMedia(ite);
                            System.out.println(cart.getItemsOrdered().size());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the title of the media you want to play: ");
                    String titlePlay = scanner.nextLine();
                    boolean check2 = true;
                    for(Media ite : store.getItemsInStore()) {
                        if(ite.getTitle().equalsIgnoreCase(titlePlay)) {
                            try {
                                ite.play();
                            } catch (PlayerException e) {
                                throw new RuntimeException(e);
                            }
                            check2 = false;
                            break;
                        }
                    }
                    if(check2) System.out.println("Media not found in store");
                    break;
                case 4:
                    cart.printList();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public static void mediaDetailsMenu(Store store, Cart cart, Media media) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if(media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                        try {
                            media.play();
                        } catch (PlayerException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    System.out.println("Not valid with book");
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public static void cartMenu(Store store, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5: ");
            short option = scanner.nextShort();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("1. Filter by ID");
                    System.out.println("2. Filter by Title");
                    System.out.println("3. Return");
                    short choice = scanner.nextShort();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter ID you want to filter: ");
                            short id = scanner.nextShort();
                            boolean check = true;
                            for(Media ite : cart.getItemsOrdered()) {
                                if(ite.getId() == id) {
                                    System.out.println(ite.toString());
                                    check = false;
                                }
                            }
                            if(check) System.out.println("Can't found this ID!");
                            break;
                        case 2:
                            System.out.println("Enter your title you want to filter: ");
                            String title = scanner.nextLine();
                            cart.searchByTitle(title);
                            break;
                        default:
                            break;
                    }
                case 2:
                    System.out.println("1. Sort by Title");
                    System.out.println("2. Sort by Cost");
                    System.out.println("3. Return");
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            cart.sortByTitle();
                            break;
                        case 2:
                            cart.sortByCost();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter media's title you want to remove: ");
                    String titleRemove = scanner.nextLine();
                    for(Media ite : cart.getItemsOrdered()) {
                        if(ite.getTitle().equalsIgnoreCase(titleRemove)) {
                            cart.removeMedia(ite);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter media title to play: ");
                    String playTitle = scanner.nextLine();
                    boolean check = true;
                    for(Media ite : cart.getItemsOrdered()) {
                        if(ite.getTitle().equalsIgnoreCase(playTitle)) {
                            try {
                                ite.play();
                            } catch (PlayerException e) {
                                throw new RuntimeException("Error occurred during playback: " + e.getMessage(), e);
                            }
                            check = false;
                            break;
                        }
                    }
                    if(check) System.out.println("Cart not include this Media!");
                    break;
                case 5:
                    System.out.println("An order is created!");
                    System.out.println("Empty current cart");
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public static void createBook(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter number of author: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> authors = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            System.out.println("Enter " + (i+1) + " author: ");
            String input = scanner.nextLine();
            authors.add(input);
        }
        Book book = new Book(id, title, category, cost, authors);
        store.addMedia(book);
    }

    public static void createCD(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter artist: ");
        String artist = scanner.nextLine();
        System.out.println("Enter number of track: ");
        int numberOfTrack = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Track> listOfTrack = new ArrayList<Track>();
        for(int i = 0; i < numberOfTrack; i++) {
            System.out.println("Enter title of track" + (i+1) + " :");
            String trackTitle = scanner.nextLine();
            System.out.println("Enter length of this track: ");
            int lengthTrack = scanner.nextInt();
            scanner.nextLine();
            Track newTrack = new Track(trackTitle, lengthTrack);
            listOfTrack.add(newTrack);
        }
        CompactDisc CD = new CompactDisc(id, title, category, cost, "", artist, listOfTrack);
        store.addMedia(CD);
    }

    public static void createDVD(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter number of length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter director: ");
        String director = scanner.nextLine();
        DigitalVideoDisc DVD = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(DVD);
    }

    public static void JavaFx(Store store, Cart cart) {
        TestViewStoreScreen.store = store;
        TestViewStoreScreen.cart = cart;
    }
}
