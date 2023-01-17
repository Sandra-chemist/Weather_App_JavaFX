package weather.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import weather.controllers.MainPaneController;

import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() throws IOException {
        MainPaneController controller = new MainPaneController();
        initializeStage(controller);
    }
    private void initializeStage(MainPaneController mainPaneController) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/weather/MainScreen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane, 800, 547);
        scene.getStylesheets().add(getClass().getResource("/weather/css/application.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Weather application");
        stage.setResizable(false);
        stage.show();
    }

}
