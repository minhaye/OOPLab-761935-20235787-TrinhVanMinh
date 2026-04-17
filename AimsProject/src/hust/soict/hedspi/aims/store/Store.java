package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    private final int MAX_NUMBERS_IN_STORE = 1000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0;
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        } else System.out.println("The store is full");
    }
    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == disc) {
                for (int j = i; j < qtyInStore - 1; j++) itemsInStore[j] = itemsInStore[j + 1];
                qtyInStore--;
                System.out.println("The disc " + disc.getTitle() + " has been removed");
                return;
            }
        }
        System.out.println("cant found disc: " + disc.getTitle());
    }
}
