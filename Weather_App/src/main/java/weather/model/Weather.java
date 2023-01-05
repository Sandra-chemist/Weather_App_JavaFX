package weather.model;

import java.time.LocalDate;
import java.util.Objects;

public class Weather {

    private final String cityName;
    private final double tempInCelsius;
    private final int humidityInPercent;
    private final String descriptionWeather;

    private final LocalDate date;

    public Weather(String cityName, double tempInCelsius, int humidityInPercent, String descriptionWeather, LocalDate date) {
        this.cityName = cityName;
        this.tempInCelsius = tempInCelsius;
        this.humidityInPercent = humidityInPercent;
        this.descriptionWeather = descriptionWeather;
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTempInCelsius() {
        return tempInCelsius;
    }
    public int getHumidityInPercent() {
        return humidityInPercent;
    }

    public String getDescriptionWeather() {
        return descriptionWeather;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Double.compare(weather.tempInCelsius, tempInCelsius) == 0 && Objects.equals(cityName, weather.cityName) && Objects.equals(date, weather.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, tempInCelsius, date);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", tempInCelsius=" + tempInCelsius +
                ", date=" + date +
                '}';
    }
}
