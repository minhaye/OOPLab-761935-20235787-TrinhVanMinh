package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost,int length, String director, String artist) {
        super(id, title, category, cost, length, director);
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
    public int getLength() {
        int sum = 0;
        for (Track track : tracks) sum += track.getLength();
        return sum;
    }

    @Override
    public void play() {
        for (Track track : tracks) track.play();
    }
}