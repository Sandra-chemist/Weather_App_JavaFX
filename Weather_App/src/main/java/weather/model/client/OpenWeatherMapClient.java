package weather.model.client;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;

import weather.model.Weather;
import weather.model.WeatherList;

import java.time.LocalDate;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String UNITS = "&units=metric";
    private static String iconURL = "http://openweathermap.org/img/wn/";
    private RestTemplate restTemplate = new RestTemplate();
    private RestTemplate restTemplateWeatherForecast = new RestTemplate();

    @Override
    public Weather getWeather(String cityName) {
        String response = null;
        String responseWeatherForecast = null;

        try {
            response = restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid=" + Config.getAPIKey() + UNITS, String.class, cityName);
            System.out.println(response);
            responseWeatherForecast = restTemplateWeatherForecast.getForObject(WEATHER_URL+ "forecast?q={city}&appid=" + Config.getAPIKey() + UNITS , String.class, cityName);
            System.out.println(responseWeatherForecast);

            Gson gson2 = new Gson();
            Weather weather = gson2.fromJson(responseWeatherForecast, Weather.class);
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

            String dateOne = weather.getList().get(16).getDt_txt();
            System.out.println(dateOne);
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
