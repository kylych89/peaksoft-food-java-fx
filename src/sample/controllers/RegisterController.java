package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.models.User;
import sample.services_and_databases.DbHelperForUser;
import sample.services_and_databases.impl.DbHelperForUserImpl;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void initialize() {
    }


    @FXML
    void onButtonClick(ActionEvent event) {
        if (event.getSource().equals(btnSave)) {
            onSaveButtonClicked();
        }else if (event.getSource().equals(btnCancel)) {
            btnCancel.getScene().getWindow().hide();
        }
    }

    private void onSaveButtonClicked() {
        String name = txtName.getText();
        String login = txtLogin.getText();
        String passwordText = txtPassword.getText();
        User user = new User(name,login,passwordText);
        DbHelperForUser dbHelper = new DbHelperForUserImpl();
        dbHelper.saveUser(user);
        clearFields();
    }

    private void clearFields() {
        txtName.clear();
        txtLogin.clear();
        txtPassword.clear();
    }
}
