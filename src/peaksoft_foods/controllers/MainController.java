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
    private Button btnEnter;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnEnter)) {
            showLoginPanel();
        }  else if (event.getSource().equals(btnRegister)) {
            onButtonRegister();
        }
    }

    private void showLoginPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/main_page_fxmls/login.fxml"));
            stage.setScene(new Scene(parent, 400, 200));
            stage.setTitle("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @FXML
    void initialize() {
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
