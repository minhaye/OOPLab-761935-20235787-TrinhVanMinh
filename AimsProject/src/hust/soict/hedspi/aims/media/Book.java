package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors=new ArrayList<String>();
    public Book(){
        
    }
    public void addAuthor(String authorName){
        if(authors.contains(authorName)) System.out.println("The author is already in the list");
        else{
            authors.add(authorName);
            System.out.println("The author " + authorName + " has been added");
        }
    }
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("The author " + authorName + " has been removed");
        }
        else System.out.println("The author is not in the list");
    }
}
