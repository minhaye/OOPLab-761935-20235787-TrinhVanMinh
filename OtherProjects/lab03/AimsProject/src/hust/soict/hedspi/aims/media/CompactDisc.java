package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost,int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }
    public CompactDisc(int id, String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added");
        } 
        else System.out.println("Track already exists");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed");
        } 
        else System.out.println("Track not found");
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
    public void play() {
        if(this.getLength() <= 0) {
            System.out.println("cant play because CD length <=0");
            return;
        }
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) track.play();
    }
}