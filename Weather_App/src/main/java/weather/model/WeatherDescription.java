package weather.model;

public class WeatherDescription {

    private String description;
    private String main;

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
