package weather.model;

import java.util.ArrayList;

public class WeatherForecast {

    public WeatherForecast(ArrayList<ForecastData> forecastData) {
        this.forecastData = forecastData;
    }

    private ArrayList<ForecastData> forecastData;
}
