package weather.model;

public class MainList {

    private String main;
    private String icon;

    @Override
    public String toString() {
        return "MainList{" +
                "main='" + main + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public String getIcon() {
        return icon;
    }

    public String getMain() {
        return main;
    }
}
