package weather.model;

import net.aksingh.owmjapis.core.OWM;

public class WeatherService {

    private final OWM weatherMap;

    public WeatherService(){
        weatherMap = new OWM("key");
    }
}
