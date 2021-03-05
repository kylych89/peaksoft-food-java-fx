package sample.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import sample.models.Food;

public class OrderMantuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnCancel;


    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnOrder)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Заказыныз кабыл алынды!", ButtonType.FINISH);
            alert.show();
        } else if (event.getSource().equals(btnCancel)) {
            btnCancel.getScene().getWindow().hide();
        }
    }


    @FXML
    void initialize() {
    }
}
