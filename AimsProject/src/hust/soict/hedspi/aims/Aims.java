
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        seedSampleMedia(store);
        new StoreManagerScreen(store);
    }

    private static void seedSampleMedia(Store store) {
    Book cleanCode = new Book(1, "Clean Code", "Programming", 18.5f);
    cleanCode.addAuthor("Robert C. Martin");

    Book dsaBook = new Book(2, "Data Structures and Algorithms", "Education", 14.2f);
    dsaBook.addAuthor("Mark Allen Weiss");

    DigitalVideoDisc inception = new DigitalVideoDisc(
        101,
        "Inception",
        "Sci-Fi",
        19.95f,
        148,
        "Christopher Nolan"
    );

    DigitalVideoDisc interstellar = new DigitalVideoDisc(
        102,
        "Interstellar",
        "Sci-Fi",
        21.5f,
        169,
        "Christopher Nolan"
    );

    CompactDisc randomAccessMemories = new CompactDisc(
        201,
        "Random Access Memories",
        "Music",
        15.5f,
        0,
        "Nile Rodgers",
        "Daft Punk"
    );
    randomAccessMemories.addTrack(new Track("Give Life Back to Music", 273));
    randomAccessMemories.addTrack(new Track("Get Lucky", 369));

    CompactDisc divide = new CompactDisc(
        202,
        "Divide",
        "Pop",
        13.9f,
        0,
        "Benny Blanco",
        "Ed Sheeran"
    );
    divide.addTrack(new Track("Shape of You", 234));
    divide.addTrack(new Track("Perfect", 263));

    store.addMedia(cleanCode);
    store.addMedia(dsaBook);
    store.addMedia(inception);
    store.addMedia(interstellar);
    store.addMedia(randomAccessMemories);
    store.addMedia(divide);
    }

}
