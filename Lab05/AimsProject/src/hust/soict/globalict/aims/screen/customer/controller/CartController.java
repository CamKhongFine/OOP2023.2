package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    private float cost = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup filterCategory;

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
    private Button btnPlaceOrder;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            media.play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Play");
            alert.setHeaderText(null);
            alert.setContentText(media.getTitle() + " are playing");
            alert.showAndWait();
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Illegal Length!");
            alert.setHeaderText("An error occurred");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);

        costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);



        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        costLabel.setText(cart.totalCost() + " $");

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    @FXML
    void PlacerOrderController(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add to Cart");
        alert.setHeaderText(null);
        alert.setContentText("An order has been placed, please notice your phone!");
        alert.showAndWait();
    }

    void updateButtonBar(Media media) {
        if(media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable) {
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }

    public void setCostLabel() {
        costLabel.setText(cost + " $");
    }

    public void addCost(float cost) {
        this.cost += cost;
        setCostLabel();
    }

    void showFilteredMedia(String filter) {
        ObservableList filteredList = FXCollections.observableArrayList();
        if(radioBtnFilterTitle.isSelected()) {
            for(Media media : store.getItemsInStore()) {
                try {
                    if (media.getTitle().toLowerCase().contains(filter.toLowerCase())) {
                        filteredList.add(media);
                    }
                } catch (NullPointerException e) {
                    return;
                }
            }
            if(filter.isEmpty()){
                tblMedia.setItems(cart.getItemsOrdered());
            }
            else {
                tblMedia.setItems(filteredList);
            }
        }
        else {
            if(!filter.isEmpty()) { // Check if filter is not empty
                for(Media media : store.getItemsInStore()) {
                    try {
                        if (media.getId() == Integer.parseInt(filter)) {
                            filteredList.add(media);
                        }
                    } catch (NullPointerException e) {
                        return;
                    }
                    catch (NumberFormatException e) {
                        return;
                    }
                }
            }
            if(filter.isEmpty()){
                tblMedia.setItems(cart.getItemsOrdered());
            }
            else {
                tblMedia.setItems(filteredList);
            }
        }

    }
}
