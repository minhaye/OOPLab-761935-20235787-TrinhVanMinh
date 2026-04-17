
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder= new Cart();
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladdin","Animation",18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        //anOrder.printCost();
        anOrder.removeDigitalVideoDisc(dvd1);
        //anOrder.printCost();
        DigitalVideoDisc dvd4=new DigitalVideoDisc("bubu","Animation",20.99f);
        anOrder.removeDigitalVideoDisc(dvd4);
        DigitalVideoDisc dvd5=new DigitalVideoDisc("laba","Animation",28.99f);
        anOrder.addDigitalVideoDisc(dvd4,dvd5,dvd1);
        //anOrder.printCost();
        anOrder.printListOrdered();
        anOrder.searchById(2);
        anOrder.searchById(50);
        anOrder.searchByTitle("Aladdin");
        anOrder.searchByTitle("bububbubu");
    }
}
