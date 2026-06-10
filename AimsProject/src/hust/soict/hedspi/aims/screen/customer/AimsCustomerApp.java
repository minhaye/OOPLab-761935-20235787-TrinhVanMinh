package hust.soict.hedspi.aims.screen.customer;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AimsCustomerApp extends Application {

    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                1,
                "The Lion King",
                "Animation",
                19.95f,
                87,
                "Roger Allers"
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                2,
                "Star Wars",
                "Science Fiction",
                24.95f,
                87,
                "George Lucas"
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                3,
                "Aladdin",
                "Animation",
                18.99f,
                90,
                "John Musker"
        );

        Book book1 = new Book(
                4,
                "The Alchemist",
                "Novel",
                10.99f
        );

        Book book2 = new Book(
                5,
                "Harry Potter",
                "Fantasy",
                15.50f
        );

        Book book3 = new Book(
                6,
                "Clean Code",
                "Programming",
                25.00f
        );

        Book book4 = new Book(
                7,
                "The Little Prince",
                "Classic",
                12.50f
        );

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(
                8,
                "Interstellar",
                "Science Fiction",
                29.99f,
                169,
                "Christopher Nolan"
        );

        DigitalVideoDisc dvd5 = new DigitalVideoDisc(
                9,
                "Inception",
                "Science Fiction",
                27.99f,
                148,
                "Christopher Nolan"
        );

        CompactDisc cd1 = new CompactDisc(
                10,
                "Greatest Hits",
                "Music",
                18.00f,
                0,
                "Various",
                "Various Artists"
        );
        cd1.addTrack(new Track("Hit One", 180));
        cd1.addTrack(new Track("Hit Two", 210));

        CompactDisc cd2 = new CompactDisc(
                11,
                "Lo-fi Study",
                "Music",
                16.50f,
                0,
                "Studio",
                "Lo-fi Collective"
        );
        cd2.addTrack(new Track("Rainy Window", 150));
        cd2.addTrack(new Track("Late Night Desk", 195));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(cd1);
        store.addMedia(cd2);

        launch(args);
    }
}
