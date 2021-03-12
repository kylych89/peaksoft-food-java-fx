package peaksoft_foods.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private MenuItem mnItemDelete;

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
            userRegister();
        } else if (event.getSource().equals(mnItemEdit)) {
            editCurrentUser();
        } else if (event.getSource().equals(mnItemDelete)) {
            deleteCurrentUser();
        }
    }

    private void deleteCurrentUser() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/registerUsersToDatabase.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            RegisterController controller = loader.getController();
            User user = tbUsers.getSelectionModel().getSelectedItem();
            controller.initDate(stage, user);
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void userRegister() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/registerUsersToDatabase.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            RegisterController controller = loader.getController();
            controller.initDate(stage, null);
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void editCurrentUser() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/registerUsersToDatabase.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            RegisterController controller = loader.getController();
            User user = tbUsers.getSelectionModel().getSelectedItem();
            controller.initDate(stage, user);
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
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

        refresh();
    }

    private void refresh() {
        DbHelperForUser dbHelperForUser = new DbHelperForUserImpl();
        List<User> list = dbHelperForUser.getAllUser();
        ObservableList<User> observableList = FXCollections.observableList(list);
        tbUsers.setItems(observableList);
    }
}
