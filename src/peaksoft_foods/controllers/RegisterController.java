package peaksoft_foods.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import peaksoft_foods.models.User;
import peaksoft_foods.services_and_databases.DbHelperForUser;
import peaksoft_foods.services_and_databases.impl.DbHelperForUserImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController {
    private Stage stage;
    private User user;

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
        } else if (event.getSource().equals(btnCancel)) {
            close();
        }
    }

    private void close() {
        btnCancel.getScene().getWindow().hide();
    }

    private void onSaveButtonClicked() {
        String name = txtName.getText();
        String login = txtLogin.getText();
        String passwordText = txtPassword.getText();
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(passwordText);
        DbHelperForUser dbHelper = new DbHelperForUserImpl();
        if (user.getId() == null) {
            dbHelper.saveUser(user);
        } else {
            dbHelper.updateUser(user);
        }
        clearFields();
    }

    private void clearFields() {
        txtName.clear();
        txtLogin.clear();
        txtPassword.clear();
    }

    public void initDate(Stage stage, User user) {
        this.stage = stage;
        if (user != null) {
//            this.stage = stage;
            this.user = user;
            txtName.setText(user.getName());
            txtLogin.setText(user.getLogin());
            txtPassword.setText(user.getPassword());
        } else {
            this.user = new User();
        }
    }

    public void deleteCurrUser(Stage stage, User user) {
        this.stage = stage;
            DbHelperForUser dbHelperForUser = new DbHelperForUserImpl();
            dbHelperForUser.deleteUserById(user.getId());
    }
}
