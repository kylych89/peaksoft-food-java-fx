package peaksoft_foods.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import peaksoft_foods.models.Food;
import peaksoft_foods.services_and_databases.DbHelperForFood;
import peaksoft_foods.services_and_databases.impl.DbHelperForFoodImpl;

public class AddFoodsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtAmount;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnSave)) {
            onSaveButtonClicked();
        } else if (event.getSource().equals(btnCancel)) {
            btnCancel.getScene().getWindow().hide();
        }
    }

    private void onSaveButtonClicked() {
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int amount = Integer.parseInt(txtAmount.getText());

        Food food = new Food(name,price,amount);

        DbHelperForFood forFood = new DbHelperForFoodImpl();
        forFood.saveFood(food);
        clearFields();
    }

    private void clearFields() {
        txtName.clear();
        txtPrice.clear();
        txtAmount.clear();
    }

    @FXML
    void initialize() {
    }
}
