package hust.soict.hedspi.aims.media;

public class Track {
    private String title;
    private int length;

    public Track() {}

    public Track(String title, int length) {
        if(length < 0) {
            System.out.println("Length must be non-negative");
            return;
        }
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
