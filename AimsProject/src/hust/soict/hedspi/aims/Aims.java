
package hust.soict.hedspi.aims;

import java.util.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Cart anOrder= new Cart();
        // DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        // anOrder.addMedia(dvd1);
        // DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        // anOrder.addMedia(dvd2);
        // DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladdin","Animation",18.99f);
        // anOrder.addMedia(dvd3);
        // //anOrder.printCost();
        // //anOrder.removeDigitalVideoDisc(dvd1);
        // anOrder.removeMedia(dvd1);
        // //anOrder.printCost();
        // DigitalVideoDisc dvd4=new DigitalVideoDisc("bubu","Animation",20.99f);
        // //anOrder.removeDigitalVideoDisc(dvd4);
        // anOrder.removeMedia(dvd4);
        // //anOrder.addMedia(dvd4,dvd5,dvd1);
        // //anOrder.printCost();
        // anOrder.printListOrdered();
        // anOrder.searchById(2);
        // anOrder.searchById(50);
        // anOrder.searchByTitle("Aladdin");
        // anOrder.searchByTitle("bububbubu");
        // List<Media> mediae=new ArrayList<Media>();
        // CompactDisc cd1=new CompactDisc("cd1","music","artist1",10.99f);
        // mediae.add(cd1);
        // Book book1=new Book("book1","education",15.99f);
        // mediae.add(book1);
        // mediae.add(dvd1);
        // for(Media media: mediae) System.out.println(media.toString());
        showMenu();
    }
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                storeMenu();
                break;
            case 2:
                updateStoreMenu();
                break;
            case 3:
                cart.printListOrdered();
                break;
            case 0:
                System.out.println("exit");
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                showMenu();
        }
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the title of the media: ");
                String title = scanner.nextLine();
                Media media = store.findMediaByTitle(title);
                if (media != null) mediaDetailsMenu(media);
                else System.out.println("Not found media title " + title);
                break;
            case 2:
                System.out.println("Enter the title of the media: ");
                title = scanner.nextLine();
                media = store.findMediaByTitle(title);
                if (media != null) cart.addMedia(media);
                else System.out.println("Not found media title " + title);
                break;
            case 3:
                System.out.println("Enter the title of the media: ");
                title = scanner.nextLine();
                media = store.findMediaByTitle(title);
                if(media != null){
                    if(media instanceof Playable) ((Playable) media).play();
                    else System.out.println(media.toString());
                }
                else System.out.println("Not found media title " + title);
                break;
            case 4:
                cartMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("filtering....");
                break;
            case 2:
                System.out.println("sorting....");
                break;
            case 3:
                System.out.println("Ordered");
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }
    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                cart.addMedia(media);
                break;
            case 2:
                if(media instanceof Playable) ((Playable) media).play();
                else System.out.println(media.toString());
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }
    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the title of the media: ");
                String title = scanner.nextLine();
                Media media = store.findMediaByTitle(title);
                if (media != null) System.out.println("The media is already in the store");
                else {
                    System.out.println("Enter the id of the media: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the category of the media: ");
                    String category = scanner.nextLine();
                    System.out.println("Enter the cost of the media: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Enter the type of the media (DVD/CD/Book): ");
                    String type = scanner.nextLine();
                    if(type.equalsIgnoreCase("DVD")){
                        System.out.println("Enter the director of the DVD: ");
                        String director = scanner.nextLine();
                        System.out.println("Enter the length of the DVD: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        media = new DigitalVideoDisc(id, title, category, cost, length, director);
                    }
                    else if(type.equalsIgnoreCase("CD")){
                        System.out.println("Enter the artist of the CD: ");
                        String artist = scanner.nextLine();
                        media = new CompactDisc(id, title, category, artist, cost);
                    }
                    else if(type.equalsIgnoreCase("Book")){
                        media = new Book(id, title, category, cost);
                    }
                    else{
                        System.out.println("Invalid media type. Media not added.");
                        return;
                    }
                }
                break;
            case 2:
                System.out.println("Enter the title of the media: ");
                title = scanner.nextLine();
                media = store.findMediaByTitle(title);
                if (media != null) store.removeMedia(media);
                else System.out.println("Not found media title " + title);
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }
}
