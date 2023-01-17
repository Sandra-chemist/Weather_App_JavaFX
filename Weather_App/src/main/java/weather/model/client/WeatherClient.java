package weather.model.client;

import weather.model.ForecastData;
import weather.model.Weather;

import java.util.List;

public interface WeatherClient {
    Weather getWeather(String cityName);
    List<ForecastData> getWeatherForecast(String cityName);
}
