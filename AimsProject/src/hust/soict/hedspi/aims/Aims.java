
package hust.soict.hedspi.aims;

import java.util.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder= new Cart();
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        anOrder.addMedia(dvd1);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        anOrder.addMedia(dvd2);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladdin","Animation",18.99f);
        anOrder.addMedia(dvd3);
        //anOrder.printCost();
        //anOrder.removeDigitalVideoDisc(dvd1);
        anOrder.removeMedia(dvd1);
        //anOrder.printCost();
        DigitalVideoDisc dvd4=new DigitalVideoDisc("bubu","Animation",20.99f);
        //anOrder.removeDigitalVideoDisc(dvd4);
        anOrder.removeMedia(dvd4);
        DigitalVideoDisc dvd5=new DigitalVideoDisc("laba","Animation",28.99f);
        //anOrder.addMedia(dvd4,dvd5,dvd1);
        //anOrder.printCost();
        anOrder.printListOrdered();
        anOrder.searchById(2);
        anOrder.searchById(50);
        anOrder.searchByTitle("Aladdin");
        anOrder.searchByTitle("bububbubu");
        List<Media> mediae=new ArrayList<Media>();
        CompactDisc cd1=new CompactDisc("cd1","music","artist1",10.99f);
        mediae.add(cd1);
        Book book1=new Book("book1","education",15.99f);
        mediae.add(book1);
        mediae.add(dvd1);
        for(Media media: mediae) System.out.println(media.toString());
    }
}
