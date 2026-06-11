package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.AimsException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    private Store store;
    private Cart cart;
    private FilteredList<Media> filteredList;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredList);

        updateButtonBar(null);
        updateTotalCost();

        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> {
            updateTotalCost();
            showFilteredMedia();
            updateButtonBar(tblMedia.getSelectionModel().getSelectedItem());
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> updateButtonBar(newValue)
        );

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia()
        );

        radioBtnFilterId.setOnAction(event -> showFilteredMedia());
        radioBtnFilterTitle.setOnAction(event -> showFilteredMedia());
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnPlay.setManaged(false);

            btnRemove.setVisible(false);
            btnRemove.setManaged(false);
            return;
        }

        btnRemove.setVisible(true);
        btnRemove.setManaged(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
            btnPlay.setManaged(true);
        } else {
            btnPlay.setVisible(false);
            btnPlay.setManaged(false);
        }
    }

    private void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    private void showFilteredMedia() {
        String keyword = tfFilter.getText();

        if (keyword == null || keyword.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
            return;
        }

        String lowerKeyword = keyword.toLowerCase().trim();

        filteredList.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerKeyword);
            }

            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerKeyword);
            }

            return true;
        });
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH =
                    "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);

            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Store");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media != null) {
            try {
                cart.removeMedia(media);
            } catch (AimsException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Remove media");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Place order");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place order");
        alert.setHeaderText(null);
        alert.setContentText("An order has been created successfully.");
        alert.showAndWait();

        cart.clear();
        updateButtonBar(null);
    }
}
