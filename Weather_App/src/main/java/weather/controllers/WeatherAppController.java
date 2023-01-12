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
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class WeatherAppController implements Initializable {

    @FXML
    private Label firstDate;
    @FXML
    private Label fourtDate;
    @FXML
    private Label secondDate;
    @FXML
    private Label thirdDate;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
    }
    @FXML
    void displayWeather() {
        String cityName = locationInput.getText();;
        Weather weather = weatherService.getWeather(cityName);
        displayCurrentWeather(weather);
    }

    private void displayCurrentWeather(Weather weather) {
        String location = locationInput.getText();
        currDate.setText("" + weather.getDate());
        displayCity.setText(location);
        displayTemperature.setText("" + weather.getTemp() + " \u00b0C");
        displayHumidity.setText("" + weather.getHumidity() + " %");
        displayDescription.setText("" + weather.getDescription());
        weatherIcon.setImage(new Image(String.valueOf(weather.getIcon())));
        firstDate.setText(String.valueOf(LocalDate.now().plusDays(1)));
        secondDate.setText(String.valueOf(LocalDate.now().plusDays(2)));
        thirdDate.setText(String.valueOf(LocalDate.now().plusDays(3)));
        fourtDate.setText(String.valueOf(LocalDate.now().plusDays(4)));
    }

    private void displayWeatherForecast(Weather weather){
        temperatureOne.setText("" + weather.getList().get(0).getMain().getTemp());
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
