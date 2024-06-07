package hust.soict.globalict.test.screen.customer.store;

import hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    public static Store store;
    public static Cart cart;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setStore(Store store) {
        this.store = store;
    }

       //To run GUI, first Add medias then select option 4 to open
    public static void main(String[] args) {
        Aims.main(args);
        launch(args);
       /*
        Book:

        1
        Dune
        Fiction
        210
        1
        Soc

////////////////////////
        CD:

        30
        Nonstop
        Nhac tre
        300
        Son Tung
        1
        Con Mua Ngang Qua
        -5

        */
    }
}
