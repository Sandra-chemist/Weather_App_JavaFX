package weather.model;

import weather.model.client.OpenWeatherMapClient;
import weather.model.client.WeatherClient;

public class WeatherServiceFactory {

    public static WeatherService createWeatherService(){
        return new WeatherService((WeatherClient) createWeatherClient());
    }
    private static OpenWeatherMapClient createWeatherClient() {
        return new OpenWeatherMapClient();
    }

}
