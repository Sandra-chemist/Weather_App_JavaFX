package weather.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import weather.model.Weather;
import weather.model.WeatherService;
import weather.model.WeatherServiceFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class WeatherAppController implements Initializable {
    @FXML
    private ImageView weatherIcon;
    private MainScreenController mainScreenController;
    private WeatherService weatherService;
    @FXML
    private Label displayTemperature;
    @FXML
    private Label displayHumidity;
    @FXML
    private Label displayDescription;
    @FXML
    private Label currDate;
    @FXML
    private Label displayCity;
    @FXML
    private TextField locationInput;
    @FXML
    private Label temperatureOne;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
    }
    @FXML
    void displayWeather() {
        currDate.setText(dateFormat.format(date));
        String cityName = locationInput.getText();;
        Weather weather = weatherService.getWeather(cityName);
        displayCurrentWeather(weather);
    }

    private void displayCurrentWeather(Weather weather) {
        String location = locationInput.getText();
        displayCity.setText(location);
        displayTemperature.setText("" + weather.getTemp() + " \u00b0C");
        displayHumidity.setText("" + weather.getHumidity() + " %");
        displayDescription.setText("" + weather.getDescription());
        weatherIcon.setImage(new Image(String.valueOf(weather.getIcon())));
    }

    private void displayWeatherForecast(Weather weather){
        temperatureOne.setText("" + weather.getList().get(0).getMain().getTemp());
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
