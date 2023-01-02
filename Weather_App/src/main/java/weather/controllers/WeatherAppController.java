package weather.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherAppController{

    private MainScreenController mainScreenController;
    @FXML
    private Label displayTemperature;
    @FXML
    private Label displayHumidity;

    @FXML
    private Label currDate;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @FXML
    void setLocation() {
        currDate.setText(dateFormat.format(date));
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
