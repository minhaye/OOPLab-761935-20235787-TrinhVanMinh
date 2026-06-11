package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.InvalidMediaException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {}

    public Track(String title, int length) {
        setTitle(title);
        setLength(length);
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidMediaException("Track title must not be empty.");
        }
        this.title = title;
    }

    private void setLength(int length) {
        if (length < 0) {
            throw new InvalidMediaException("Track length must be non-negative.");
        }
        this.length = length;
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive.");
            throw new PlayerException("ERROR: Track length is non-positive.");
        }
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength();
        //return this.getTitle().equals(track.getTitle())&& this.getLength() == track.getLength()&& this.getClass() == track.getClass();
    }
}
