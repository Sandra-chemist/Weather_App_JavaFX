package weather.model;

public class ForecastData {
    private String description;
    private int temp;
    private String icon;

    public ForecastData(String description, int temp, String icon) {
        this.description = description;
        this.temp = temp;
        this.icon = icon;
    }
    public String getDescription() {
        return description;
    }
    public int getTemp() {
        return temp;
    }
    public String getIcon() {
        return icon;
    }


}
