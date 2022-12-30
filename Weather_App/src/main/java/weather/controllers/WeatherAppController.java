package weather.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WeatherAppController{

    private MainScreenController mainScreenController;

    @FXML
    private Label currDate;

    @FXML
    void setLocation() {
        currDate.setText("2022-12-30");
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
