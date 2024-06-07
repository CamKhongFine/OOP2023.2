package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing song: " + this.getTitle());
            System.out.println("Song length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Song length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object object) {
        return ((Media) object).getTitle() == this.title && ((Track) object).getLength() == this.length;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", length=" + length +
                '}';
    }
}
