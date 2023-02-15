package weather.model.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.client.RestTemplate;
import weather.config.Config;

import weather.model.ForecastData;
import weather.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherMapClient implements WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&appid=";
    private static final String UNITS = "&units=metric";
    private static final String iconURL = "http://openweathermap.org/img/wn/";
    private final RestTemplate restTemplate = new RestTemplate();
    Gson gson = new Gson();

    @Override
    public Weather getWeather(String cityName) {
        String response = getResponse(cityName);
        JsonObject weather = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(0).getAsJsonObject();

        int tempInCelsius = (int) Math.round(weather.getAsJsonObject("main").get("temp").getAsDouble());
        int humidityInPercent = weather.getAsJsonObject("main").get("humidity").getAsInt();
        String description = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String icon = iconURL + weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString() + "@2x.png";
        String date = weather.get("dt_txt").getAsString();

        return new Weather(tempInCelsius, humidityInPercent, description, date, icon);
    }
    public List<ForecastData> getWeatherForecast(String cityName){
        List<ForecastData> weatherForecasts = new ArrayList<>();

        String response = getResponse(cityName);
        int firstTemp, secondTemp, thirdTemp, fourthTemp;
        String firstDescription, secondDescription, thirdDescription, fourthDescription;
        String firstIcon, secondIcon, thirdIcon, fourthIcon;

        for (int i = 0; i < 33; i++) {
            JsonObject weatherForecast = gson.fromJson(response, JsonObject.class).getAsJsonArray("list").get(i).getAsJsonObject();
            int tempInCelsius = (int) Math.round(weatherForecast.getAsJsonObject("main").get("temp").getAsDouble());
            String description = weatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
            String icon = iconURL + weatherForecast.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString() + "@2x.png";
            if (i == 8) {
                firstTemp = tempInCelsius;
                firstDescription = description;
                firstIcon = icon;
                weatherForecasts.add(new ForecastData(firstDescription, firstTemp, firstIcon));
            } else if (i == 16) {
                secondTemp = tempInCelsius;
                secondDescription = description;
                secondIcon = icon;
                weatherForecasts.add(new ForecastData(secondDescription, secondTemp, secondIcon));
            } else if (i == 24) {
                thirdTemp = tempInCelsius;
                thirdDescription = description;
                thirdIcon = icon;
                weatherForecasts.add(new ForecastData(thirdDescription, thirdTemp, thirdIcon));
            } else if (i == 32) {
                fourthTemp = tempInCelsius;
                fourthDescription = description;
                fourthIcon = icon;
                weatherForecasts.add(new ForecastData(fourthDescription, fourthTemp, fourthIcon));
            }
        }
        return weatherForecasts;
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
