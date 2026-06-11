package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.InvalidMediaException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // public CompactDisc(int id, String title, String category, float cost,int length, String director, String artist) {
    //     super(id, title, category, cost, length, director);
    //     this.artist = artist;
    // }
    // public CompactDisc(int id, String title, String category, String artist, float cost) {
    //     super(title, category, cost);
    //     this.artist = artist;
    // }
    // public CompactDisc(String title, String category, String artist, float cost) {
    //     super(title, category, cost);
    //     this.artist = artist;
    // }

    // constructor duy nhất, đầy đủ mọi thứ nhưng chưa có tracks
    public CompactDisc(int id, String title, String category, float cost,int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (track == null) {
            throw new InvalidMediaException("Track must not be null.");
        }
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added");
        } 
        else throw new InvalidMediaException("Track already exists.");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed");
        } 
        else throw new InvalidMediaException("Track not found.");
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getArtist() + ": " + this.getCost() + "$";
    }

    @Override
    public int getLength() {
        int sum = 0;
        for (Track track : tracks) sum += track.getLength();
        return sum;
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive.");
            throw new PlayerException("ERROR: CD length is non-positive.");
        }
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                throw new PlayerException("ERROR: A track in CD cannot be played.");
            }
        }
    }
}
