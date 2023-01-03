package weather.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import weather.model.Weather;
import weather.model.WeatherService;
import weather.model.WeatherServiceFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class WeatherAppController implements Initializable {

    private MainScreenController mainScreenController;
    private WeatherService weatherService;
    @FXML
    private Label displayTemperature;
    @FXML
    private Label displayHumidity;
    @FXML
    private Label currDate;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
    }

    @FXML
    void displayWeather() {
        currDate.setText(dateFormat.format(date));
        String cityName = "Warsow";
        Weather weather = weatherService.getWeather(cityName);
        displayWeather(weather);
    }

    private void displayWeather(Weather weather) {
        displayTemperature.setText("" + weather.getTempInClesius());
        displayHumidity.setText("70%");
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }


}
