package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.StoreException;
import hust.soict.hedspi.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyInStore;
    public Store() {
        this.qtyInStore = 0;
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                System.out.println("Found media: " + media.toString());
                return media;
            }
        }
        System.out.println("Not found media title " + title);
        return null;
    }
    public void addMedia(Media media) {
        if (media == null) {
            throw new StoreException("Cannot add null media to store.");
        }
        if (itemsInStore.contains(media)) throw new StoreException("The media is already in the store.");
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
        } else throw new StoreException("The media is not in the store.");
    }
    public void sortByTitleCost(){
        itemsInStore.sort(new MediaComparatorByTitleCost());
        System.out.println("Sorted by title cost");
    }
    public void sortByCostTitle(){
        itemsInStore.sort(new MediaComparatorByCostTitle());
        System.out.println("Sorted by cost title");
    }
    public void printStore(){
        System.out.println("***********************STORE***********************");
        System.out.println("Items in the store:");
        for(int i=0;i<qtyInStore;i++) System.out.println((i+1)+". "+itemsInStore.get(i) .toString());
        System.out.println("************************************************");
     }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

}
