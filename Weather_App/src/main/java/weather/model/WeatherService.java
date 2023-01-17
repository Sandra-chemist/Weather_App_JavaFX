package weather.model;

import weather.model.client.WeatherClient;

public class WeatherService {

   private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Weather getWeather(String cityName){
        return weatherClient.getWeather(cityName);
    }

    public WeatherForecast getWeatherForecast(String cityName){
        return weatherClient.getWeatherForecast(cityName);
    }
}
