package weather.model;

import java.time.LocalDate;

public class Weather {

    private final String name;
    private final double temp;
    private final int humidity;
    private final String description;
    private final String date;
    private final String icon;

    public Weather(String cityName, double tempInCelsius, int humidityInPercent, String descriptionWeather, String date, String icon) {
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
    public String getDate() {
        return date;
    }
    public String getIcon() {
        return icon;
    }

}
