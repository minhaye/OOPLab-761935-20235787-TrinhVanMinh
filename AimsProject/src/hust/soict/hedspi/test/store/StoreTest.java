package hust.soict.hedspi.test.store;

//import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation",87,19.95f);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction",87,24.95f);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladdin","Animation",18.99f);
        DigitalVideoDisc dvd4=new DigitalVideoDisc("bubu","Animation",20.99f);
        DigitalVideoDisc dvd5=new DigitalVideoDisc("laba","Animation",28.99f);
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
