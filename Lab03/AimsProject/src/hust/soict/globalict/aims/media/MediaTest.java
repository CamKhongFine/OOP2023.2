package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> list = new ArrayList<>();
        ArrayList<Track> track = new ArrayList<>();
        track.add(new Track("Interclude",5));
        CompactDisc cd = new CompactDisc(20, "Ngoc Cam", "Rock", 120, 60,  "5SSM", "Alay", track);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("JFC");
        Book book = new Book(1, "Dune", "Fiction", 10, authors);

        System.out.println(cd);
        System.out.println(dvd);
        System.out.println(book);
    }
}
