package weather.model;

public class WeatherForecast {

    private final String description;
    private final double temp;
    private final String icon;

    public WeatherForecast(String description, double temp, String icon) {
        this.description = description;
        this.temp = temp;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public String getIcon() {
        return icon;
    }

}
