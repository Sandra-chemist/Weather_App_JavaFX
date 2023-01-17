package weather.model.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;

import weather.model.Weather;
import weather.model.WeatherForecast;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&appid=";
    private static final String UNITS = "&units=metric";
    private static final String iconURL = "http://openweathermap.org/img/wn/";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Weather getWeather(String cityName) {
        String response = null;

        try {
            response = restTemplate.getForObject(WEATHER_URL + Config.getAPIKey() + UNITS, String.class, cityName);
            System.out.println(response);

        }
        catch (Exception e){
            System.out.println("City not found");
        }
        Gson gson = new Gson();
        JsonObject weather = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(0).getAsJsonObject();

        double tempInCelsius = weather.getAsJsonObject("main").get("temp").getAsDouble();
        int humidityInPercent = weather.getAsJsonObject("main").get("humidity").getAsInt();
        String description = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String iconNumber = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String icon = iconURL + iconNumber + "@2x.png";
        String date = weather.get("dt_txt").getAsString();

//        System.out.println(date);
//        System.out.println(tempInCelsius);
//        System.out.println(humidityInPercent);
//        System.out.println(description);
//        System.out.println(iconNumber);
        return new Weather(cityName, tempInCelsius, humidityInPercent, description, date, icon);
    }

    public WeatherForecast getWeatherForecast(String cityName){
        return new WeatherForecast(cityName, "ddds", 5, "ds");
    }
}
