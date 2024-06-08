package hust.soict.globalict.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton Eraser;

    @FXML
    private RadioButton Pen;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(Pen.isSelected()) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
        else {
            Circle newCircle = new Circle(event.getX(), event.getY(), 8, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }

    }


    @FXML
    void initialize() {
        assert drawingAreaPane != null : "fx:id=\"drawingAreaPane\" was not injected: check your FXML file 'Painter.fxml'.";
    }
}
