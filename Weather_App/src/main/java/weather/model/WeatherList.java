package weather.model;

import java.util.List;

public class WeatherList {

    public Main getMain() {
        return main;
    }

    public List<MainList> getWeather() {
        return weather;
    }

    List<MainList>weather;
    Main main;
    public String getDt_txt() {
        return dt_txt;
    }

    private String dt_txt;

    @Override
    public String toString() {
        return "WeatherList{" +
                "main=" + main +
                '}';
    }
}
