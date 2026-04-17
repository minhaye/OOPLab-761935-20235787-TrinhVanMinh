package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladdin","Animation",18.99f);
        DigitalVideoDisc dvd4=new DigitalVideoDisc("bubu","Animation",20.99f);
        DigitalVideoDisc dvd5=new DigitalVideoDisc("laba","Animation",28.99f);
        Store store = new Store();
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);
        store.addDVD(dvd5);
        store.removeDVD(dvd1);
        store.removeDVD(dvd4);
    }
}
