
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.JOptionPane;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        seedSampleMedia(store);
        tryPlaySample(store);
        new StoreManagerScreen(store);
    }

    private static void tryPlaySample(Store store) {
        for (Media media : store.getItemsInStore()) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (PlayerException e) {
                    handlePlayerException(e);
                }
            }
        }
    }

    private static void handlePlayerException(PlayerException e) {
        System.err.println(e.getMessage());
        System.err.println(e.toString());
        e.printStackTrace();
        JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Player error",
                JOptionPane.ERROR_MESSAGE
        );
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
