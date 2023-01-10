package weather.model;

public class WeatherDescription {

    public String getMain() {
        return main;
    }

    private String main;

    @Override
    public String toString() {
        return main;
    }

}
