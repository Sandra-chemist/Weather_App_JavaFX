package weather.model.client;

import org.springframework.web.client.RestTemplate;
import weather.config.Config;
import weather.model.Weather;

import java.time.LocalDate;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String UNITS = "metric";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Weather getWeather(String cityName) {
        String response = null;

        try {
            response = restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid=" + Config.getAPIKey() + "&units=" + UNITS, String.class, cityName);
            System.out.println(response);
        }
        catch (Exception e){
            System.out.println("City not found");
        }

        return new Weather(cityName, 10, 50, "clouds", LocalDate.now() );
    }



}
