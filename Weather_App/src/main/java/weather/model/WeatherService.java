package weather.model;

import net.aksingh.owmjapis.core.OWM;
import weather.config.Config;
import weather.model.client.WeatherClient;

public class WeatherService {

//    private OWM weatherMap;
//    public WeatherService(){
//       weatherMap = new OWM(Config.getAPIKey());
//       this.weatherMap = weatherMap;
//       }

   private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Weather getWeather(String cityName){
        return weatherClient.getWeather(cityName);
    }
}
