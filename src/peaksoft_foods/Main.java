package peaksoft_foods;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml_files/main_page_fxmls/sample.fxml"));
        primaryStage.setTitle("Peaksoft Food");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaxHeight(1000);
        primaryStage.setMaxWidth(1200);
        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(1000);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
