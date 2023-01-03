module weather {
    requires javafx.controls;
    requires javafx.fxml;
    requires owm.japis;
    requires java.sql;

    opens weather to javafx.fxml;
    exports weather;
    exports weather.controllers;
    opens weather.controllers to javafx.fxml;
}