package weather.model;

public class Main {

    private double temp;
    private double humidity;

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                '}';
    }
}
