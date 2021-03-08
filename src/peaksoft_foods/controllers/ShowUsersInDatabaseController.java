package peaksoft_foods.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import peaksoft_foods.models.User;
import peaksoft_foods.services_and_databases.DbHelperForUser;
import peaksoft_foods.services_and_databases.impl.DbHelperForUserImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowUsersInDatabaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem mnItemClose;

    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

    @FXML
    private TableView<User> tbUsers;

    @FXML
    private TableColumn<User, Long> columnId;

    @FXML
    private TableColumn<User, String> cloumnName;

    @FXML
    private TableColumn<User, String> cloumnLogin;

    @FXML
    private TableColumn<User, String> cloumnPassword;

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(mnItemAdd)) {
            showRegister();
        }
    }

    private void showRegister() {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/peaksoft_foods/fxml_files/show_users_database_fxmls/showUsers.fxml"));
            stage.setScene(new Scene(root, 1000, 800));
            stage.setTitle("Users");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @FXML
    void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cloumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cloumnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        cloumnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        DbHelperForUser dbHelperForUser = new DbHelperForUserImpl();
        List<User> list = dbHelperForUser.getAllUser();
        ObservableList<User> observableList = FXCollections.observableList(list);
        tbUsers.setItems(observableList);
    }
}
