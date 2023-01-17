package weather.model;

public class ForecastData {
    private String description;
    private double temp;
    private String icon;

    public ForecastData(String description, double temp, String icon) {
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
