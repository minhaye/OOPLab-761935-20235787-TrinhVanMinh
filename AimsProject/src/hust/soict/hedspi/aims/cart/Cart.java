package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;


public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i=0;i<qtyOrdered;i++){
            if(itemsOrdered[i]==disc){
                for(int j=i;j<qtyOrdered-1;j++) itemsOrdered[j]=itemsOrdered[j+1];
                qtyOrdered--;
                System.out.println("removed disc: "+disc.getTitle());
                return;
            }
        }
        System.out.println("cant found disc: "+disc.getTitle());
    }
    public float totalCost(){
        float total=0;
        for(int i=0;i<qtyOrdered;i++) total+=itemsOrdered[i].getCost();
        return total;
    }
    public void printCost(){
        float total=0;
        for(int i=0;i<qtyOrdered;i++){
            System.out.println((i+1)+"\t"+itemsOrdered[i].getTitle()+"\t"+itemsOrdered[i].getCost());
            total+=itemsOrdered[i].getCost();
        }
        System.out.println("Total Cost: "+total);
    }
    // public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
    //     for(int i=0;i<dvdList.length;i++) addDigitalVideoDisc(dvdList[i]);
    // }
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
        for(int i=0;i<qtyOrdered;i++) System.out.println((i+1)+". "+itemsOrdered[i].toString());
        System.out.println("Total cost: "+totalCost());
        System.out.println("************************************************");
    }
    public void searchById(int id){
        for(int i=0;i<qtyOrdered;i++){
            if(itemsOrdered[i].getId()==id){
                System.out.println("Found DVD "+(i+1)+": "+itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("Not found DVD id "+id);
    }
    public void searchByTitle(String title){
        for(int i=0;i<qtyOrdered;i++){
            if(itemsOrdered[i].getTitle().equals(title)){
                System.out.println("Found DVD "+(i+1)+": "+itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("Not found DVD title "+title);
    }
}
