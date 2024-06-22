package gui;

import board.Circuit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

class chatGPThandler {

    private Circuit circuit;

    @FXML
    private ScrollPane sp_main;

    @FXML
    private VBox vbox;

    @FXML
    private TextField question;

    @FXML
    private Button buttonAsk;

    @FXML
    private Button buttonExit;


    @FXML
    private void AskGPT(ActionEvent event) {
        String ques = question.getText();
        if(!ques.isEmpty()){
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER_RIGHT);
            hbox.setPadding(new Insets(5,5,5,10));
            Text text = new Text(ques);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setPadding(new Insets(5, 10, 5, 10));
            textFlow.setStyle("-fx-color: rgb(239,242,255); -fx-background-color: rgb(15,125,242);-fx-background-radius: 20px");
            hbox.getChildren().add(textFlow);
            vbox.getChildren().add(hbox);
            question.clear();
            //chatGPT chatgpt = new chatGPT();
            //System.out.println("Me: " + ques + "\nGPT: " + chatgpt.chatGPT(ques));
        } else {
            System.out.println("You need to fill question!");
        }

        chatGPT bot = new chatGPT();
        if(!bot.chatGPT(ques).isEmpty()) {
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER_LEFT);
            hbox.setPadding(new Insets(5,5,5,10));
            String ans = bot.chatGPT(ques);
            Text text = new Text(ans);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-background-color: rgb(233,233,235);" + "-fx-background-radius: 20px");
            textFlow.setPadding(new Insets(5,50 , 5, 5));
            hbox.getChildren().add(textFlow);
            vbox.getChildren().add(hbox);


        } else {
            System.out.println("No answer from GPT");
        }
        vbox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sp_main.setVvalue((Double) newValue);
            }
        });



    }

    @FXML
    private void ExitGPT(ActionEvent event) {
        new ElictricalApplication(circuit);
    }
}
