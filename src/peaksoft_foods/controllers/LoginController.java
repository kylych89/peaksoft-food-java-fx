package peaksoft_foods.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import peaksoft_foods.services_and_databases.LoginService;
import peaksoft_foods.services_and_databases.impl.LoginServiceImpl;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnEnter)) {
            enter();
        } else if (event.getSource().equals(btnCancel)) {
            close();
        }
    }

    private void enter() {
        String login = txtLogin.getText();
        String password = txtPassword.getText();

        LoginService loginService = new LoginServiceImpl();

        boolean result = loginService.login(login,password);

        if (result) {
            System.out.println("ok");
            showMainPage();
        } else {
            System.out.println("error");
        }
        clearFields();
    }

    private void clearFields() {
        txtLogin.clear();
        txtPassword.clear();
    }

    private void showMainPage() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/main_page_fxmls/mainPageFoods.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void close() {
        btnCancel.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
    }
}
