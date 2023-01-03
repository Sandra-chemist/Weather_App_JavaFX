package weather.model;

import weather.model.client.WeatherClient;

public class WeatherService {
//    private final OWM weatherMap;
//
//   public WeatherService(){
//       weatherMap = new OWM(Config.getAPIKey());    }

   private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Weather getWeather(String cityName){
        return weatherClient.getWeather(cityName);
    }
}
