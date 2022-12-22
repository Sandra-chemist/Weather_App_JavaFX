module weather {
    requires javafx.controls;
    requires javafx.fxml;

    opens weather to javafx.fxml;
    exports weather;
    exports weather.controllers;
    opens weather.controllers to javafx.fxml;
}