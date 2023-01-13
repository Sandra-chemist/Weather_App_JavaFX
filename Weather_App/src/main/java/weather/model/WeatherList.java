package weather.model;

import java.util.List;

public class WeatherList {
    List<MainList>weather;
    Main main;
    public String getDt_txt() {
        return dt_txt;
    }

    private String dt_txt;

    public Main getMain() {
        return main;
    }

    public List<MainList> getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "WeatherList{" +
                "main=" + main +
                '}';
    }
}
