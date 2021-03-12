package peaksoft_foods.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import peaksoft_foods.models.Food;
import peaksoft_foods.services_and_databases.DbHelperForFood;
import peaksoft_foods.services_and_databases.impl.DbHelperForFoodImpl;

public class AddNewFoodController {
    private Stage stage;
    private Food food;

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
    private Button btnClose;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnSave)) {
            onSaveButtonClicked();
        } else if (event.getSource().equals(btnClose)) {
            close();
        }
    }

    private void onSaveButtonClicked() {
        String name = txtName.getText();
        Double price = Double.valueOf(txtPrice.getText());
        Integer amount = Integer.valueOf(txtAmount.getText());

        food.setName(name);
        food.setPrice(price);
        food.setAmount(amount);

        DbHelperForFood dbHelperForFood = new DbHelperForFoodImpl();
        if (food.getId() == null) {
            dbHelperForFood.saveFood(food);
        } else {
            dbHelperForFood.updateFood(food);
        }


        clearFields();
    }

    private void close() {
        if (stage != null) {
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        }
    }

    private void clearFields() {
        txtName.clear();
        txtPrice.clear();
        txtAmount.clear();
    }

    @FXML
    void initialize() {
    }

    public void initDate(Stage stage, Food food) {
        this.stage = stage;


        if (food != null) {
            this.food = food;
            txtName.setText(food.getName());
            txtPrice.setText(String.valueOf(food.getPrice()));
            txtAmount.setText(String.valueOf(food.getAmount()));
        } else {
            this.food = new Food();
        }
    }

    public void deleteCurrFood(Stage stage, Food food) {
        this.stage = stage;
        DbHelperForFood dbHelperForFood = new DbHelperForFoodImpl();
        dbHelperForFood.deleteFoodById(food.getId());
    }
}
