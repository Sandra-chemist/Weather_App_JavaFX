package weather.model;

public class WeatherList {

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
