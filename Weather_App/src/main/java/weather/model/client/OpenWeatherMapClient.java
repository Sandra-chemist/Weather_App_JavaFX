package weather.model.client;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;
import weather.model.Weather;

import java.time.LocalDate;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String UNITS = "metric";
    private static String iconURL = "http://openweathermap.org/img/wn/";
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
        Gson gson = new Gson();
        Weather weather = gson.fromJson(response, Weather.class);

        double tempInCelsium = weather.getMain().getTemp();
        int humidityInPercent = weather.getMain().getHumidity();
        String description = weather.getWeather().get(0).getMain();
        String iconNumber = weather.getWeather().get(0).getIcon();
        String icon = iconURL + iconNumber + "@2x.png";

        return new Weather(cityName, tempInCelsium, humidityInPercent, description, LocalDate.now(), icon);
    }

}
