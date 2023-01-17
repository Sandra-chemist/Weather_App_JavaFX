package weather.model.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;

import weather.model.Weather;
import weather.model.WeatherForecast;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&appid=";
    private static final String UNITS = "&units=metric";
    private static final String iconURL = "http://openweathermap.org/img/wn/";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Weather getWeather(String cityName) {
        String response = getResponse(cityName);
        Gson gson = new Gson();
        JsonObject weather = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(0).getAsJsonObject();

        double tempInCelsius = weather.getAsJsonObject("main").get("temp").getAsDouble();
        int humidityInPercent = weather.getAsJsonObject("main").get("humidity").getAsInt();
        String description = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String iconNumber = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String icon = iconURL + iconNumber + "@2x.png";
        String date = weather.get("dt_txt").getAsString();

        return new Weather(cityName, tempInCelsius, humidityInPercent, description, date, icon);
    }

    public WeatherForecast getWeatherForecast(String cityName){
        String response = getResponse(cityName);
        Gson gson = new Gson();
        JsonObject firstDayWeatherForecast = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(8).getAsJsonObject();
        JsonObject secondDayWeatherForecast = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(16).getAsJsonObject();
        JsonObject thirdDayWeatherForecast = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(24).getAsJsonObject();
        JsonObject fourthDayWeatherForecast = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(32).getAsJsonObject();


        double firstTempInCelsius = firstDayWeatherForecast.getAsJsonObject("main").get("temp").getAsDouble();
        String firstDescription = firstDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String firstIconNumber = firstDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String firstIcon = iconURL + firstIconNumber + "@2x.png";
        String firstDate = firstDayWeatherForecast.get("dt_txt").getAsString();

        System.out.println(firstDate);
        System.out.println(firstDescription);
        System.out.println(firstTempInCelsius);
        System.out.println(firstIconNumber);
        System.out.println("");

        double secondTempCelsius = secondDayWeatherForecast.getAsJsonObject("main").get("temp").getAsDouble();
        String secondDescription = secondDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String secondIconNumber = secondDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String secondIcon = iconURL + secondIconNumber + "@2x.png";
        String secondDate = secondDayWeatherForecast.get("dt_txt").getAsString();

        System.out.println(secondDate);
        System.out.println(secondDescription);
        System.out.println(secondTempCelsius);
        System.out.println(secondIconNumber);
        System.out.println("");

        double thirdTempCelsius = thirdDayWeatherForecast.getAsJsonObject("main").get("temp").getAsDouble();
        String thirdDescription = thirdDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String thirdIconNumber = thirdDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String thirdIcon = iconURL + thirdIconNumber + "@2x.png";
        String thirdDate = thirdDayWeatherForecast.get("dt_txt").getAsString();

        System.out.println(thirdDate);
        System.out.println(thirdDescription);
        System.out.println(thirdTempCelsius);
        System.out.println(thirdIconNumber);
        System.out.println("");

        double fourthTempCelsius = firstDayWeatherForecast.getAsJsonObject("main").get("temp").getAsDouble();
        String fourthDescription = fourthDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String fourthIconNumber = fourthDayWeatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        String fourthIcon = iconURL + fourthIconNumber + "@2x.png";
        String fourthDate = fourthDayWeatherForecast.get("dt_txt").getAsString();

        System.out.println(fourthDate);
        System.out.println(fourthDescription);
        System.out.println(fourthTempCelsius);
        System.out.println(fourthIconNumber);

        List<WeatherForecast> weatherForecasts = new ArrayList<WeatherForecast>();
        weatherForecasts.add(new WeatherForecast(firstDescription, firstTempInCelsius, firstIcon));
        weatherForecasts.add(new WeatherForecast(secondDescription, secondTempCelsius, secondIcon));
        weatherForecasts.add(new WeatherForecast(thirdDescription, thirdTempCelsius, thirdIcon));
        weatherForecasts.add(new WeatherForecast(fourthDescription, fourthTempCelsius, fourthIcon));
        System.out.println("indeks 0");
        System.out.println(weatherForecasts.get(0).getDescription());
        System.out.println("indeks 1");
        System.out.println(weatherForecasts.get(1).getDescription());

        return new WeatherForecast(firstDescription, firstTempInCelsius, firstIcon);
    }

    @Nullable
    private String getResponse(String cityName) {
        String response = null;

        try {
            response = restTemplate.getForObject(WEATHER_URL + Config.getAPIKey() + UNITS, String.class, cityName);
        }
        catch (Exception e){
            System.out.println("City not found");
        }
        return response;
    }

}
