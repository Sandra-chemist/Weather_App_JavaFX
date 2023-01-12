package weather.model.client;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;

import weather.model.Weather;
import weather.model.WeatherList;

import java.time.LocalDate;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&appid=";
    private static final String UNITS = "&units=metric";
    private static String iconURL = "http://openweathermap.org/img/wn/";
    private RestTemplate restTemplate = new RestTemplate();
    private RestTemplate restTemplateWeatherForecast = new RestTemplate();

    @Override
    public Weather getWeather(String cityName) {
        String response = null;

        try {
            response = restTemplateWeatherForecast.getForObject(WEATHER_URL + Config.getAPIKey() + UNITS, String.class, cityName);
            System.out.println(response);

        }
        catch (Exception e){
            System.out.println("City not found");
        }

        Gson gson = new Gson();
        Weather weather = gson.fromJson(response, Weather.class);
        WeatherList liste = weather.getList().get(0);
        WeatherList liste4 = weather.getList().get(8);
        WeatherList liste5 = weather.getList().get(16);
        WeatherList liste6 = weather.getList().get(24);
        WeatherList liste7 = weather.getList().get(32);

        System.out.println(liste);
        System.out.println(liste4);
        System.out.println(liste5);
        System.out.println(liste6);
        System.out.println(liste7);

        String date = weather.getList().get(0).getDt_txt();
        double tempInCelsius = weather.getList().get(0).getMain().getTemp();
        int humidityInPercent = (int) weather.getList().get(0).getMain().getHumidity();
        String iconNumber = weather.getList().get(0).getWeather().get(0).getIcon();
        String icon = iconURL + iconNumber + "@2x.png";
        String description = weather.getList().get(0).getWeather().get(0).getMain();

        System.out.println(date);
        System.out.println(tempInCelsius);
        System.out.println(humidityInPercent);
        System.out.println(description);
        return new Weather(cityName, tempInCelsius, humidityInPercent, description, LocalDate.now(), icon);
    }
}
