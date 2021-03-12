package peaksoft_foods.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import peaksoft_foods.models.Food;
import peaksoft_foods.services_and_databases.DbHelperForFood;
import peaksoft_foods.services_and_databases.impl.DbHelperForFoodImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowFoodsInDatabaseController {

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
    private MenuItem mnItemUsers;

    @FXML
    private MenuItem mnItemDelete;

    @FXML
    private MenuItem mnItemAbout;

    @FXML
    private TableView<Food> tbFoods;

    @FXML
    private TableColumn<Food, Long> columnId;

    @FXML
    private TableColumn<Food, String> columnName;

    @FXML
    private TableColumn<Food, Double> columnPrice;

    @FXML
    private TableColumn<Food, Integer> columnAmount;

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(mnItemAdd)) {
            addNewFood();
        } else if (event.getSource().equals(mnItemEdit)) {
            editCurrFood();
        } else if (event.getSource().equals(mnItemClose)) {
            close();
        } else if (event.getSource().equals(mnItemUsers)) {
            showUsers();
        } else if (event.getSource().equals(mnItemDelete)) {
            deleteCurrFood();
        }
    }

    private void deleteCurrFood() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addNewFood.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            AddNewFoodController addNewFood = loader.getController();
            Food food = tbFoods.getSelectionModel().getSelectedItem();
            addNewFood.deleteCurrFood(stage, food);
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void addNewFood() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addNewFood.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            AddNewFoodController addNewFood = loader.getController();
            addNewFood.initDate(stage, null);
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void editCurrFood() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addNewFood.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            AddNewFoodController addNewFood = loader.getController();
            Food food = tbFoods.getSelectionModel().getSelectedItem();
            addNewFood.initDate(stage, food);
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void showUsers() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/show_users_database_fxmls/showUsers.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            stage.setOnCloseRequest(windowEvent -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void close() {
        mnItemClose.isDisable();
    }

    @FXML
    void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        refresh();
    }

    private void refresh() {
        DbHelperForFood dbHelperForFood = new DbHelperForFoodImpl();
        List<Food> list = dbHelperForFood.getAllFoods();
        ObservableList<Food> observableList = FXCollections.observableList(list);
        tbFoods.setItems(observableList);
    }
}
