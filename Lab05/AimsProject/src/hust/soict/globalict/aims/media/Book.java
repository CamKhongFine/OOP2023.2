package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<>();

    public Book() {

    }

    public Book(ArrayList<String> authors) {
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if(authors.indexOf(authorName) > 0) {
            System.out.println("Author already exist");
            return;
        }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        if(authors.indexOf(authorName) < 0) {
            System.out.println("Author name not exist");
            return;
        }
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                ", authors=" + authors +
                '}';
    }

    @Override
    public void play() {
        //
    }
}
