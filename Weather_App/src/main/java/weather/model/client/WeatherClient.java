package weather.model.client;

import weather.model.Weather;
import weather.model.WeatherForecast;

public interface WeatherClient {
    Weather getWeather(String cityName);
    WeatherForecast getWeatherForecast(String cityName);
}
