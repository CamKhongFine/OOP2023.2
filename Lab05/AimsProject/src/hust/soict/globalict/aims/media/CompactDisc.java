package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String artist, ArrayList<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String director, String artist, ArrayList<Track> tracks) {
        super(0, director);
        this.artist = artist;
        this.tracks = tracks;
        super.setLength(setNewLength());
    }
    public CompactDisc(int id, String title,  String category, int length, float cost, String artist, String director, ArrayList<Track> tracks) {
        super(length, "");
        this.artist = artist;
        this.tracks = tracks;
        super.setLength(setNewLength());
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost,0, " ");
        this.artist = artist;
        this.tracks = tracks;
        super.setLength(setNewLength());
    }
    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost,0, " ");
        this.artist = artist;
        this.tracks = tracks;
        super.setLength(setNewLength());
    }


    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("Track already in list");
            return;
        }
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        if(!tracks.contains(track)) {
            System.out.println("Track isn't exist in list");
            return;
        }
        tracks.remove(track);
    }

    public int getLength() {
        int sumLength = 0;
        for(Track ite : tracks) {
            sumLength += ite.getLength();
        }
        return sumLength;
    }

    public int setNewLength() {
        int sumLength = 0;
        for(Track ite : tracks) {
            sumLength += ite.getLength();
        }
        return sumLength;
    }

    @Override
    public void play() throws PlayerException {
        if(tracks.size() > 0) {
            for(Track ite : tracks) {
                try {
                    ite.play();
                }
                catch (PlayerException e) {
                    throw e;
                }
            }
        }
        else {
            throw new PlayerException("There is nothing to play");
        }
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "artist='" + artist + '\'' +
                ", tracks=" + tracks.toString() +
                "} " + super.toString();
    }
}
