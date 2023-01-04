package weather.model.client;

import weather.model.Weather;

import java.time.LocalDate;

public class OpenWeatherMapClient implements WeatherClient {

    @Override
    public Weather getWeather(String cityName) {
        return new Weather(cityName, 10, LocalDate.now());
    }
}
