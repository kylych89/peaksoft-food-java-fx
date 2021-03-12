package peaksoft_foods.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMantu;

    @FXML
    private Button btnAshlamfu;

    @FXML
    private Button btnBeshBarmak;

    @FXML
    private Button btnPlov;

    @FXML
    private Button btnShorpo;

    @FXML
    private Button btnShashlyk;

    @FXML
    private Button btnBalyk;

    @FXML
    private Button btnTook;

    @FXML
    private Button btnSamsy;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnClose)) {
            close();
        } else if (event.getSource().equals(btnMantu)) {
            orderMantu();
        }
    }

    private void orderMantu() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/order_fxmls/orderMantu.fxml"));
            stage.setScene(new Scene(parent, 500, 200));
            stage.setTitle("Mantu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void close() {
        btnClose.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
    }
}
