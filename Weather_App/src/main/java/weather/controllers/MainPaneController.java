package weather.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
public class MainPaneController {
    private MainScreenController mainScreenController;

    @FXML
    void openApplication() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/weather/WeatherApp.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WeatherAppController weatherAppController = loader.getController();
        weatherAppController.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(pane);
    }
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
}
