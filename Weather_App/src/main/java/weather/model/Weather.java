package weather.model;

public class Weather {
    private final int temp;
    private final int humidity;
    private final String description;
     private final String date;
    private final String icon;

    public Weather(int tempInCelsius, int humidityInPercent, String descriptionWeather, String date, String icon) {
        this.temp = tempInCelsius;
        this.humidity = humidityInPercent;
        this.description = descriptionWeather;
        this.date = date;
        this.icon = icon;
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
