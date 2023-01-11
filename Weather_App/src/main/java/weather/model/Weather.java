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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Double.compare(weather.temp, temp) == 0 && Objects.equals(name, weather.name) && Objects.equals(date, weather.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, temp, date);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + name + '\'' +
                ", tempInCelsius=" + temp +
                ", date=" + date +
                '}';
    }
}
