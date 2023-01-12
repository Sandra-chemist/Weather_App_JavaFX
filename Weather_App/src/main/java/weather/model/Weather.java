package weather.model;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Weather {

    public List<WeatherDescription> getWeather() {
        return weather;
    }
    List<WeatherDescription> weather;

    public WeatherConditions getMain() {
        return main;
    }
    WeatherConditions main;

    public List<WeatherList> getList() {
        return list;
    }

    List<WeatherList>list;

    private final String name;
    private final double temp;
    private final int humidity;
    private final String description;
    private final LocalDate date;
    private final String icon;

    public Weather(String cityName, double tempInCelsius, int humidityInPercent, String descriptionWeather, LocalDate date, String icon) {
        this.name = cityName;
        this.temp = tempInCelsius;
        this.humidity = humidityInPercent;
        this.description = descriptionWeather;
        this.date = date;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }
    public double getTemp() {
        return temp;
    }
    public int getHumidity() {
        return humidity;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getIcon() {
        return icon;
    }

}
