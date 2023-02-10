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
            Weather weather = weatherClient.getWeather(cityName);
            return weatherClient.getWeather(cityName);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return null;
    }
    public List<ForecastData> getWeatherForecast(String cityName){
        return weatherClient.getWeatherForecast(cityName);
    }
}
