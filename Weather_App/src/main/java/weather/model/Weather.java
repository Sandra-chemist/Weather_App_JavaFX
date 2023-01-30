package weather.model;

import java.time.LocalDate;

public class Weather {
    private final String name;
    private final int temp;
    private final int humidity;
    private final String description;
     private final String date;
    private final String icon;

    public Weather(String cityName, int tempInCelsius, int humidityInPercent, String descriptionWeather, String date, String icon) {
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
    public int getTemp() {
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
