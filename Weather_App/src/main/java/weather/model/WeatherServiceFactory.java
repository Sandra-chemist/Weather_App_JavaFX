package weather.model;

import weather.model.client.DefaultWeatherClient;
import weather.model.client.WeatherClient;

public class WeatherServiceFactory {

    public static WeatherService createWeatherService(){
        return new WeatherService((WeatherClient) createWeatherClient());
    }

    private static DefaultWeatherClient createWeatherClient() {
        return new DefaultWeatherClient();
    }


}
