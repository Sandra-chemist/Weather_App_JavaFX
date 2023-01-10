package weather.model;

public class WeatherConditions {

    private double temp;

    public double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    private int humidity;

    @Override
    public String toString() {
        return temp + "," + humidity;
    }
}
