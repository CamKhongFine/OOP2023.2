package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemController {
    private Media media;
    private Cart cart;
    private Store store;

    public ItemController(Media media, Store store, Cart cart) {
        this.media = media;
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        cart.addMedia(media);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add to Cart");                               //Show popup
        alert.setHeaderText(null);
        alert.setContentText("Item '" + media.getTitle() + "' has been added to the cart!");
        alert.showAndWait();
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
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
    void initialize() {
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'Item.fxml'.";
        assert lblCost != null : "fx:id=\"lblCost\" was not injected: check your FXML file 'Item.fxml'.";
        assert btnAddToCart != null : "fx:id=\"btnAddToCart\" was not injected: check your FXML file 'Item.fxml'.";
        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'Item.fxml'.";
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
