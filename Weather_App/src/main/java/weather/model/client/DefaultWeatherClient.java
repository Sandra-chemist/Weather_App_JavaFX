package weather.model.client;

import weather.model.Weather;

import java.time.LocalDate;

public class DefaultWeatherClient implements WeatherClient {

    @Override
    public Weather getWeather(String cityName) {
        return new Weather(cityName, 10, LocalDate.now());
    }
}
