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
    private MenuItem mnItemAbout;
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
        } else if (event.getSource().equals(mnItemClose)) {
            close();
        } else if (event.getSource().equals(mnItemAbout)) {
            goToPageAbout();
        }

    }

    private void goToPageAbout() {
        Stage stage = new Stage();
        stage.setTitle("Абсолютно каждому человеку важно питаться регулярно, чтобы всегда быть в тонусе." +
                "А с учетом растущего ритма жизни в Бишкеке это просто необходимость! Поэтому мы разработали и запустили сервис доставки по Бишкеку Namba Food." +
                "Он позволяет не только вовремя и регулярно питаться всегда вкусной, горячей и разнообразной едой. И при этом, не тратить время на ее приготовление." +
                "Но и заказывать свежие продукты из супермаркетов, медикаменты из аптек, еду для Ваших питомцев. А услуга \"личный курьер\" легко решит проблемы с доставкой: " +
                "Если у вас интернет-магазин, инста - магазин, ресторан и любой другой бизнес " +
                "Цветов, подарков и посылок Вашим родным и близким " +
                "Деловой корреспонденции, важных документов, срочных пакетов из рук в руки и многого другого, доставку которого Вам необходимо осуществить.");
        stage.show();
    }

    private void close() {
        mnItemClose.isVisible();
    }

    private void addNewFood() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addFoodsToDatabase.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            AddFoodsController controller = loader.getController();
            controller.initData(stage, null);
            stage.setOnCloseRequest(event -> {
                refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    private void editCurrentFood() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/peaksoft_foods/fxml_files/add_and_register_fxmls/addFoodsToDatabase.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            AddFoodsController controller = loader.getController();
            Food food = tbFoods.getSelectionModel().getSelectedItem();
            controller.initData(stage, food);
            stage.setOnCloseRequest(event -> {
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
