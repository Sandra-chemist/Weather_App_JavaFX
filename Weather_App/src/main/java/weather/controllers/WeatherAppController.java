package weather.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import weather.model.CurrentDate;

public class WeatherAppController{

    CurrentDate currentDate;
    @FXML
    private Label date;

    public void setUpCurrentDate(){
        date.setText(currentDate.getDate());
    }

}
