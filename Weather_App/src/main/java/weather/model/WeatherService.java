package weather.model;

import weather.model.client.WeatherClient;

import java.util.List;

public class WeatherService {
    private final WeatherClient weatherClient;
    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }
    public Weather getWeather(String cityName){
        try {
            return weatherClient.getWeather(cityName);
        } catch (Exception e) {
            throw new FailedToGetWeatherException("Failed to get weather", e);
        }
    }
    public List<ForecastData> getWeatherForecast(String cityName){
        return weatherClient.getWeatherForecast(cityName);
    }
}
