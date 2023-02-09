package weather.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import weather.model.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class WeatherAppController implements Initializable {
    private MainScreenController mainScreenController;
    private WeatherService weatherService;
    @FXML
    private Label firstError, secondError;

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
    private Label firstDate, firstDateInRightPanel, secondDate, secondDateInRightPanel, thirdDate, thirdDateInRightPanel, fourthDate, fourthDateInRightPanel;
    @FXML
    private Label firstDescription, firstDescriptionInRightPanel, secondDescription,  secondDescriptionInRightPanel, thirdDescription, thirdDescriptionInRightPanel, fourthDescription, fourthDescriptionInRightPanel;
    @FXML
    private Label firstTemp, firstTempInRightPanel, secondTemp, secondTempInRightPanel, thirdTemp, thirdTempInRightPanel, fourthTemp, fourthTempInRightPanel;
    @FXML
    private ImageView firstIcon,  firstIconInRightPanel, secondIcon, secondIconInRightPanel, thirdIcon, thirdIconInRightPanel, fourthIcon, fourthIconInRightPanel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
    }
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    @FXML
    private void displayWeather() {
        try {
            firstError.setText("");
            String cityName = locationInput.getText();
            Weather weather = weatherService.getWeather(cityName);
            List<ForecastData> forecastData = weatherService.getWeatherForecast(cityName);
            displayCurrentWeather(weather);
            displayWeatherForecast((ArrayList<ForecastData>) forecastData);

        } catch (Exception e){
            firstError.setText("City not found!");
            locationInput.setText("");
            displayCity.setText("");
            displayTemperature.setText("");
            displayHumidity.setText("");
            displayDescription.setText("");
            weatherIcon.setImage(null);
            firstDescription.setText("");
            firstTemp.setText("");
            firstIcon.setImage(null);
            secondDescription.setText("");
            secondTemp.setText("");
            secondIcon.setImage(null);
            thirdDescription.setText("");
            thirdTemp.setText("");
            thirdIcon.setImage(null);
            fourthDescription.setText("");
            fourthTemp.setText("");
            fourthIcon.setImage(null);
        }
    }
    private void displayCurrentWeather(Weather weather) {
        String location = locationInput.getText();
        currDate.setText("" + weather.getDate());
        displayCity.setText(location.toUpperCase());
        displayTemperature.setText("" + weather.getTemp() + " °C");
        displayHumidity.setText("" + weather.getHumidity() + " %");
        displayDescription.setText("" + weather.getDescription());
        weatherIcon.setImage(new Image(String.valueOf(weather.getIcon())));
        locationInput.setText("");
    }
    private void displayWeatherForecast(ArrayList<ForecastData> forecastData){
        for (int i = 1; i < 5; i++) {
            String date = String.valueOf(LocalDate.now().plusDays(i));
            if (i == 1) {
                firstDate.setText(date);
            } else if (i == 2) {
                secondDate.setText(date);
            } else if (i == 3) {
                thirdDate.setText(date);
            } else if (i == 4) {
                fourthDate.setText(date);
            }
        }

        for (int num = 0; num <forecastData.size(); num++) {
            String temp = "" +  forecastData.get(num).getTemp() + " °C";
            String description = "" + forecastData.get(num).getDescription();
            Image image = new Image(String.valueOf(forecastData.get(num).getIcon()));
            if (num == 0 ) {
                firstTemp.setText(temp);
                firstDescription.setText(description);
                firstIcon.setImage(image);
            } else if (num == 1) {
                secondTemp.setText(temp);
                secondDescription.setText(description);
                secondIcon.setImage(image);
            } else if (num == 2) {
                thirdTemp.setText(temp);
                thirdDescription.setText(description);
                thirdIcon.setImage(image);
            } else if (num == 3) {
                fourthTemp.setText(temp);
                fourthDescription.setText(description);
                fourthIcon.setImage(image);
            }
        }
    }

    @FXML
    private void secondButtonOfDisplayWeather() {
        try {
            secondError.setText("");
            String cityName = secondLocationInput.getText();
            Weather weather = weatherService.getWeather(cityName);
            List<ForecastData> forecastData = weatherService.getWeatherForecast(cityName);
            displayCurrentWeatherInRightPanel(weather);
            displayWeatherForecastInRightPanel((ArrayList<ForecastData>) forecastData);

        } catch (Exception e) {
            secondError.setText("City not found!");
            secondLocationInput.setText("");
            displayCityInRightPanel.setText("");
            displayTemperatureInRightPanel.setText("");
            displayHumidityInRightPanel.setText("");
            displayDescriptionInRightPanel.setText("");
            weatherIconInRightPanel.setImage(null);
            firstDescriptionInRightPanel.setText("");
            firstTempInRightPanel.setText("");
            firstIconInRightPanel.setImage(null);
            secondDescriptionInRightPanel.setText("");
            secondTempInRightPanel.setText("");
            secondIconInRightPanel.setImage(null);
            thirdDescriptionInRightPanel.setText("");
            thirdTempInRightPanel.setText("");
            thirdIconInRightPanel.setImage(null);
            fourthDescriptionInRightPanel.setText("");
            fourthTempInRightPanel.setText("");
            fourthIconInRightPanel.setImage(null);
        }
    }
    private void displayCurrentWeatherInRightPanel(Weather weather) {
        String location = secondLocationInput.getText();
        currDateInRightPanel.setText("" + weather.getDate());
        displayCityInRightPanel.setText(location.toUpperCase());
        displayTemperatureInRightPanel.setText("" + weather.getTemp() + " °C");
        displayHumidityInRightPanel.setText("" + weather.getHumidity() + " %");
        displayDescriptionInRightPanel.setText("" + weather.getDescription());
        weatherIconInRightPanel.setImage(new Image(String.valueOf(weather.getIcon())));
        secondLocationInput.setText("");
    }
    private void displayWeatherForecastInRightPanel(ArrayList<ForecastData> forecastData){
        for (int i = 1; i < 5; i++) {
            String date = String.valueOf(LocalDate.now().plusDays(i));
            if (i == 1) {
                firstDateInRightPanel.setText(date);
            } else if (i == 2) {
                secondDateInRightPanel.setText(date);
            } else if (i == 3) {
                thirdDateInRightPanel.setText(date);
            } else if (i == 4) {
                fourthDateInRightPanel.setText(date);
            }
        }

        for (int num = 0; num <forecastData.size(); num++) {
            String temp = "" +  forecastData.get(num).getTemp() + " °C";
            String description = "" + forecastData.get(num).getDescription();
            Image image = new Image(String.valueOf(forecastData.get(num).getIcon()));
            if (num == 0 ) {
                firstTempInRightPanel.setText(temp);
                firstDescriptionInRightPanel.setText(description);
                firstIconInRightPanel.setImage(image);
            } else if (num == 1) {
                secondTempInRightPanel.setText(temp);
                secondDescriptionInRightPanel.setText(description);
                secondIconInRightPanel.setImage(image);
            } else if (num == 2) {
                thirdTempInRightPanel.setText(temp);
                thirdDescriptionInRightPanel.setText(description);
                thirdIconInRightPanel.setImage(image);
            } else if (num == 3) {
                fourthTempInRightPanel.setText(temp);
                fourthDescriptionInRightPanel.setText(description);
                fourthIconInRightPanel.setImage(image);
            }
        }
    }

}
