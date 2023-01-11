module weather {
    requires javafx.controls;
    requires javafx.fxml;
    requires owm.japis;
    requires java.sql;
    requires spring.web;
    requires com.google.gson;

    opens weather to javafx.fxml;
    exports weather;
    exports weather.controllers;
    opens weather.controllers to javafx.fxml;
}