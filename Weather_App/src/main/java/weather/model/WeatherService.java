package weather.model;

import net.aksingh.owmjapis.core.OWM;
import weather.config.Config;

public class WeatherService {

    private final OWM weatherMap;

    public WeatherService(){
        weatherMap = new OWM(Config.getAPIKey());
    }
}
