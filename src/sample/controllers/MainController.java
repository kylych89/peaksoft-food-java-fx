package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    private ImageView btnMantu;

    @FXML
    private Label btnLagman;

    @FXML
    private Label btnShorpo;

    @FXML
    private Button btnOrderMantu;

    @FXML
    private Button btnOrderLagman;

    @FXML
    private Button btnOrderShorpo;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnOrderMantu)) {
            showMantuPanel();
        }
    }

    @FXML
    void initialize() {
//        btnRegister.setOnAction(actionEvent -> {
//            onButtonRegister();
//        });
//
//
//
//        btnLagman.setOnMouseClicked(mouseEvent -> {
//            showLagmanPanel();
//        });
//
//        btnShorpo.setOnMouseClicked(mouseEvent -> {
//            showShorpoPanel();
//        });
    }

    private void showShorpoPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/fxml_files/shorpo.fxml"));
            stage.setScene(new Scene(parent, 1000, 800));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void showLagmanPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/fxml_files/lagman.fxml"));
            stage.setScene(new Scene(parent, 1000, 800));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void showMantuPanel() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/fxml_files/mantu.fxml"));
            stage.setScene(new Scene(parent, 1000, 800));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void onButtonRegister() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/fxml_files/register.fxml"));
            stage.setScene(new Scene(parent, 500, 300));
            stage.setTitle("Register");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
