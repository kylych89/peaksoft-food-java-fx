package peaksoft_foods.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import peaksoft_foods.services_and_databases.DbHelperForFood;
import peaksoft_foods.services_and_databases.impl.DbHelperForFoodImpl;

public class OrderMantuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtAmount;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnSave)) {
            onOrderClicked();
        } else if (event.getSource().equals(btnCancel)) {
            close();
        }
    }

    private void onOrderClicked() {
        String foodId = txtAmount.getText();
        DbHelperForFood dbHelperForFood = new DbHelperForFoodImpl();
        dbHelperForFood.findFoodById(Long.valueOf(foodId));
        dbHelperForFood.deleteFoodById(Long.valueOf(foodId));
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Заказыныз кабыл алынды тамагыныз таттуу болсун!!!", ButtonType.OK);
        alert.show();
        close();
    }

    private void close() {
        btnCancel.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
    }
}
