package weather.model.client;

import weather.model.Weather;

public interface WeatherClient {
    Weather getWeather(String cityName);
}
