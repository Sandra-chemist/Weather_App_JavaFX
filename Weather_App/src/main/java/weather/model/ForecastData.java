package weather.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForecastData that = (ForecastData) o;

        if (temp != that.temp) return false;
        if (!Objects.equals(description, that.description)) return false;
        return Objects.equals(icon, that.icon);
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + temp;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }
}
