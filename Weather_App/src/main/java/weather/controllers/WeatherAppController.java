package weather.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import weather.model.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
    private Label firstDescription;
    @FXML
    private ImageView firstIcon;

    @FXML
    private Label firstTemp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
    }
    @FXML
    void displayWeather() {
        String cityName = locationInput.getText();;
        Weather weather = weatherService.getWeather(cityName);
        List<ForecastData> forecastData = weatherService.getWeatherForecast(cityName);
        displayCurrentWeather(weather);
        displayWeatherForecastDayAfter((ArrayList<ForecastData>) forecastData);
//        displayWeatherForecastTwoDaysAfter(weather);
//        displayWeatherForecastThreeDaysAfter(weather);
//        displayWeatherForecastFourDaysAfter(weather);
    }

    private void displayCurrentWeather(Weather weather) {
        String location = locationInput.getText();
        currDate.setText("" + weather.getDate());
        displayCity.setText(location);
        displayTemperature.setText("" + weather.getTemp() + " \u00b0C");
        displayHumidity.setText("" + weather.getHumidity() + " %");
        displayDescription.setText("" + weather.getDescription());
        weatherIcon.setImage(new Image(String.valueOf(weather.getIcon())));
    }

    private void displayWeatherForecastDayAfter(ArrayList<ForecastData> forecastData){
        firstDate.setText(String.valueOf(LocalDate.now().plusDays(1)));
        firstTemp.setText("" +  forecastData.get(0).getTemp() + " \u00b0C");
        firstDescription.setText("" + forecastData.get(0).getDescription());
        firstIcon.setImage(new Image(String.valueOf(forecastData.get(0).getIcon())));
    }
    private void displayWeatherForecastTwoDaysAfter(Weather weather){
        secondDate.setText(String.valueOf(LocalDate.now().plusDays(2)));
    }
    private void displayWeatherForecastThreeDaysAfter(Weather weather){
        thirdDate.setText(String.valueOf(LocalDate.now().plusDays(3)));
    }
    private void displayWeatherForecastFourDaysAfter(Weather weather){
        fourtDate.setText(String.valueOf(LocalDate.now().plusDays(4)));
    }
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
