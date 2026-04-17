package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyInStore;
    public Store() {
        this.qtyInStore = 0;
    }
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) System.out.println("The media is already in the store");
        else {
            itemsInStore.add(media);
            qtyInStore++;
            System.out.println("The media " + media.getTitle() + " has been added");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            qtyInStore--;
            System.out.println("The media " + media.getTitle() + " has been removed");
        } else System.out.println("The media is not in the store");
    }
    public void sortByTitleCost(){
        itemsInStore.sort(new MediaComparatorByTitleCost());
        System.out.println("Sorted by title cost");
    }
    public void sortByCostTitle(){
        itemsInStore.sort(new MediaComparatorByCostTitle());
        System.out.println("Sorted by cost title");
    }
}
