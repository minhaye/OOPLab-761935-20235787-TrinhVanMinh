package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;


public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int qtyOrdered = 0;
    public void addMedia(Media media){
        if(itemsOrdered.contains(media)) System.out.println("The media is already in the cart");
        else{
            itemsOrdered.add(media);
            qtyOrdered++;
            System.out.println("The media " + media.getTitle() + " has been added");
        }
    }
    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            qtyOrdered--;
            System.out.println("The media " + media.getTitle() + " has been removed");
        } else System.out.println("The media is not in the cart");
    }

    public float totalCost(){
        float total=0;
        for(int i=0;i<qtyOrdered;i++) total+=itemsOrdered.get(i).getCost();
        return total;
    }
    public void printCost(){
        float total=0;
        for(int i=0;i<qtyOrdered;i++){
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
        for(int i=0;i<qtyOrdered;i++) System.out.println((i+1)+". "+itemsOrdered.get(i) .toString());
        System.out.println("Total cost: "+totalCost());
        System.out.println("************************************************");
    }
    public void searchById(int id){
        for(int i=0;i<qtyOrdered;i++){
            if(itemsOrdered.get(i).getId()==id){
                System.out.println("Found DVD "+(i+1)+": "+itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("Not found DVD id "+id);
    }
    public void searchByTitle(String title){
        for(int i=0;i<qtyOrdered;i++){
            if(itemsOrdered.get(i).getTitle().equals(title)){
                System.out.println("Found DVD "+(i+1)+": "+itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("Not found DVD title "+title);
    }
}
