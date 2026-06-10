package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Cart() {
        
    }
    public boolean addMedia(Media media){
        if(itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart");
            return false;
        }
        else{
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added");
            return true;
        }
    }
    public boolean removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed");
            return true;
        } else {
            System.out.println("The media is not in the cart");
            return false;
        }
    }

    public float totalCost(){
        float total=0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public void printCost(){
        float total=0;
        for(int i=0;i<itemsOrdered.size();i++){
            System.out.println((i+1)+"\t"+itemsOrdered.get(i).getTitle()+"\t"+itemsOrdered.get(i).getCost());
            total+=itemsOrdered.get(i).getCost();
        }
        System.out.println("Total Cost: "+total);
    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList){
        for(DigitalVideoDisc dvd: dvdList) addDigitalVideoDisc(dvd);
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void printListOrdered(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i=0;i<itemsOrdered.size();i++) System.out.println((i+1)+". "+itemsOrdered.get(i) .toString());
        System.out.println("Total cost: "+totalCost());
        System.out.println("************************************************");
    }
    public void searchById(int id){
        for(int i=0;i<itemsOrdered.size();i++){
            if(itemsOrdered.get(i).getId()==id){
                System.out.println("Found DVD "+(i+1)+": "+itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("Not found DVD id "+id);
    }
    public void searchByTitle(String title){
        for(int i=0;i<itemsOrdered.size();i++){
            if(itemsOrdered.get(i).getTitle().equals(title)){
                System.out.println("Found DVD "+(i+1)+": "+itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("Not found DVD title "+title);
    }
    public void sortByTitleCost(){
        itemsOrdered.sort(new MediaComparatorByTitleCost());
        System.out.println("Sorted by title cost");
    }
    public void sortByCostTitle(){
        itemsOrdered.sort(new MediaComparatorByCostTitle());
        System.out.println("Sorted by cost title");
    }

}
