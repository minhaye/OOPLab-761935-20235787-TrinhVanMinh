package hust.soict.hedspi.test.screen.customer.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application {

    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String CART_FXML_FILE_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

        CartController cartController = new CartController(store, cart);
        fxmlLoader.setController(cartController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
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

        Book book1 = new Book(
                3,
                "The Alchemist",
                "Novel",
                10.99f
        );

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book1);

        launch(args);
    }
}