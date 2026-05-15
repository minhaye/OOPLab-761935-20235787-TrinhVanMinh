package hust.soict.hedspi.test.store;

//import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "bubu", "Animation", 20.99f, 95, "Unknown");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "laba", "Animation", 28.99f, 100, "Unknown");
        Store store = new Store();
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.removeMedia(dvd1);
        store.removeMedia(dvd4);
    }
}
