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
    private MainScreenController mainScreenController;
    private WeatherService weatherService;

    @FXML
    private TextField locationInput, secondLocationInput;
    @FXML
    private Label currDate,  currDateInRightPanel;
    @FXML
    private Label displayCity, displayCityInRightPanel;
    @FXML
    private ImageView weatherIcon, weatherIconInRightPanel;
    @FXML
    private Label displayTemperature, displayTemperatureInRightPanel;
    @FXML
    private Label displayHumidity, displayHumidityInRightPanel;
    @FXML
    private Label displayDescription, displayDescriptionInRightPanel;


    @FXML
    private Label firstDescription;
    @FXML
    private ImageView firstIcon;
    @FXML
    private Label firstTemp;
    @FXML
    private Label firstDate;
    @FXML
    private Label secondDate;
    @FXML
    private Label thirdDate;
    @FXML
    private Label fourthDate;
    @FXML
    private Label secondDescription;
    @FXML
    private Label secondTemp;
    @FXML
    private ImageView secondIcon;
    @FXML
    private Label thirdDescription;
    @FXML
    private Label thirdTemp;
    @FXML
    private ImageView thirdIcon;
    @FXML
    private Label fourthDescription;
    @FXML
    private Label fourthTemp;
    @FXML
    private ImageView fourthIcon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
    }
    @FXML
    void displayWeather() {
        String cityName = locationInput.getText();
        Weather weather = weatherService.getWeather(cityName);
        List<ForecastData> forecastData = weatherService.getWeatherForecast(cityName);
        displayCurrentWeather(weather);
        displayWeatherForecastDayAfter((ArrayList<ForecastData>) forecastData);
        displayWeatherForecastTwoDaysAfter((ArrayList<ForecastData>) forecastData);
        displayWeatherForecastThreeDaysAfter((ArrayList<ForecastData>) forecastData);
        displayWeatherForecastFourDaysAfter((ArrayList<ForecastData>) forecastData);
    }

    @FXML
    void secondButtonOfDisplayWeather() {
        String cityName = secondLocationInput.getText();
        Weather weather = weatherService.getWeather(cityName);
        displayCurrentWeatherInRightPanel(weather);
    }

    private void displayCurrentWeatherInRightPanel(Weather weather) {
        String location = secondLocationInput.getText();
        currDateInRightPanel.setText("" + weather.getDate());
        displayCityInRightPanel.setText(location);
        displayTemperatureInRightPanel.setText("" + weather.getTemp() + " \u00b0C");
        displayHumidityInRightPanel.setText("" + weather.getHumidity() + " %");
        displayDescriptionInRightPanel.setText("" + weather.getDescription());
        weatherIconInRightPanel.setImage(new Image(String.valueOf(weather.getIcon())));
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
    private void displayWeatherForecastTwoDaysAfter(ArrayList<ForecastData> forecastData){
        secondDate.setText(String.valueOf(LocalDate.now().plusDays(2)));
        secondTemp.setText("" +  forecastData.get(1).getTemp() + " \u00b0C");
        secondDescription.setText("" + forecastData.get(1).getDescription());
        secondIcon.setImage(new Image(String.valueOf(forecastData.get(1).getIcon())));
    }
    private void displayWeatherForecastThreeDaysAfter(ArrayList<ForecastData> forecastData){
        thirdDate.setText(String.valueOf(LocalDate.now().plusDays(3)));
        thirdTemp.setText("" +  forecastData.get(2).getTemp() + " \u00b0C");
        thirdDescription.setText("" + forecastData.get(2).getDescription());
        thirdIcon.setImage(new Image(String.valueOf(forecastData.get(2).getIcon())));
    }
    private void displayWeatherForecastFourDaysAfter(ArrayList<ForecastData> forecastData){
        fourthDate.setText(String.valueOf(LocalDate.now().plusDays(4)));
        fourthTemp.setText("" +  forecastData.get(3).getTemp() + " \u00b0C");
        fourthDescription.setText("" + forecastData.get(3).getDescription());
        fourthIcon.setImage(new Image(String.valueOf(forecastData.get(3).getIcon())));
    }
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
