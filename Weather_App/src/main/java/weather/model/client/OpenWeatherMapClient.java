package weather.model.client;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;
import weather.model.Weather;

import java.time.LocalDate;
import java.util.List;

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

            try {
//                String jsonText =  "{\"name\": \"Sandra\", \"age\": 24, \"weather\": [{\"id\": 500, \"description\": \"light rain\"}]}";
//                System.out.println(jsonText);
//
//            Gson gson = new Gson();
//            User user = gson.fromJson(jsonText, User.class);
//                System.out.println(user.getWeather());

                Gson gson = new Gson();
                Weather weather = gson.fromJson(response, Weather.class);
                System.out.println(weather.getWeather());
                System.out.println(weather.getMain().getTemp());
                System.out.println(weather.getMain().getHumidity());

            } catch (Exception ex){
                System.out.println("Error");
            }

        }
        catch (Exception e){
            System.out.println("City not found");
        }

        return new Weather(cityName, 10, 50, "clouds", LocalDate.now() );
    }



}
