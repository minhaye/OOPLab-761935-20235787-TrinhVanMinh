package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.InvalidMediaException;

public class Disc extends Media {
    private int length;
    private String director;
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        setLength(length);
        this.director = director;
    }
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + ": " + this.getCost() + "$";
    }

    public String getDirector() {
        return director;
    }

    protected void setLength(int length) {
        if (length < 0) {
            throw new InvalidMediaException("Disc length must be non-negative.");
        }
        this.length = length;
    }
}
