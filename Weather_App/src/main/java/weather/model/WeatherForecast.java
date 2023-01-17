package weather.model;

public class WeatherForecast {

    private final String name;
    private final String description;
    private final double temp;
    private final String icon;

    public WeatherForecast(String name, String description, double temp, String icon) {
        this.name = name;
        this.description = description;
        this.temp = temp;
        this.icon = icon;
    }

    public String getName() {
        return name;
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
