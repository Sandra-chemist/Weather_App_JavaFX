package weather.model.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import weather.model.Weather;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenWeatherMapClientStub {

    public JsonObject getWeatherFromJson() {
        JsonParser parser = new JsonParser();

        try {
            Object obj = parser.parse(new FileReader("C:\\Weather_App_JavaFX\\Weather_App\\src\\test\\resources\\weatherForecast.json"));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return null;
    }

    public Weather getWeather(String cityName) {
        Gson gson = new Gson();
        JsonObject weather = gson.fromJson(getWeatherFromJson(), JsonObject.class).getAsJsonObject();

        int temp = (int) Math.round(weather.getAsJsonObject("main").get("temp").getAsDouble());
        int humidityInPercent = weather.getAsJsonObject("main").get("humidity").getAsInt();
        String description = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String icon = null;
        String date = weather.get("dt_txt").getAsString();

        return new Weather(temp, humidityInPercent, description, date, icon);
    }
}
