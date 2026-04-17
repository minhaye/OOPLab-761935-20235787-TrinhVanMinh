package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(String title, String category, int length, float cost) {
        super(title, category, cost);
        this.length = length;
    }
    public Disc() {
        
    }
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
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
}