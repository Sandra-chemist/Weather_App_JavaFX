package weather.model;

import weather.model.client.OpenWeatherMapClient;

public class WeatherServiceFactory {

    public static WeatherService createWeatherService(){
        return new WeatherService(createWeatherClient());
    }
    private static OpenWeatherMapClient createWeatherClient() {
        return new OpenWeatherMapClient();
    }

}
