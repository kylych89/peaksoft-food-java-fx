package peaksoft_foods.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import peaksoft_foods.models.Food;
import peaksoft_foods.services_and_databases.DbHelperForFood;
import peaksoft_foods.services_and_databases.impl.DbHelperForFoodImpl;

public class ShowFoodsInDatabaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

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
            editCurrentFood();
        }

    }

    private void addNewFood() {
        Stage stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addFoodsToDatabase.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            AddFoodsController controller = loader.getController();
            Food food = loader.getController();
            controller.initData(stage, new Food());
            stage.setScene(new Scene(loader.getRoot()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setOnCloseRequest(event -> {
            refresh();
        });
        stage.show();
    }

    private void editCurrentFood() {
        Stage stage = new Stage();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addFoodsToDatabase.fxml"));
            fxmlLoader.load();
            stage.setScene(new Scene(fxmlLoader.getRoot()));
            AddFoodsController controller = fxmlLoader.getController();
            Food food = tbFoods.getSelectionModel().getSelectedItem();
            controller.initData(stage, food);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setOnCloseRequest(event -> {
            refresh();
        });
        stage.show();
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
