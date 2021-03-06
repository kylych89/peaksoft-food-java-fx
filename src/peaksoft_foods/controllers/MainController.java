package peaksoft_foods.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnOrderMantu;

    @FXML
    private Button btnOrderLagman;

    @FXML
    private Button btnOrderShorpo;

    @FXML
    private Button btnDatabase;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnOrderMantu)) {
            showMantuPanel();
        } else if (event.getSource().equals(btnOrderLagman)) {
            showLagmanPanel();
        } else if (event.getSource().equals(btnOrderShorpo)) {
            showShorpoPanel();
        } else if (event.getSource().equals(btnRegister)) {
            onButtonRegister();
        } else if (event.getSource().equals(btnDatabase)) {
            showDatabaseFoods();
        }
    }

    private void showDatabaseFoods() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/show_foods_database_fxmls/showFoodsInDatabase.fxml"));
            stage.setScene(new Scene(parent, 1000, 800));
            stage.setTitle("Database foods");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @FXML
    void initialize() {
    }

    private void showShorpoPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/order_fxmls/orderShorpo.fxml"));
            stage.setScene(new Scene(parent, 600, 500));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void showLagmanPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/order_fxmls/orderLagman.fxml"));
            stage.setScene(new Scene(parent, 600, 500));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void showMantuPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/order_fxmls/orderMantu.fxml"));
            stage.setScene(new Scene(parent, 600, 500));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void onButtonRegister() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/registerUsersToDatabase.fxml"));
            stage.setScene(new Scene(parent, 500, 300));
            stage.setTitle("Register");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
