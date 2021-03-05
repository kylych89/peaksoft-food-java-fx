package sample.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import sample.models.Food;

public class MantuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<Food> comboBoxAmount;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnOrder)) {

        } else if (event.getSource().equals(btnCancel)) {
            btnCancel.getScene().getWindow().hide();
        }
    }

    @FXML
    void initialize() {
        List<Food> list = new ArrayList<>();
        comboBoxAmount.setItems((ObservableList<Food>) list);
    }
}
