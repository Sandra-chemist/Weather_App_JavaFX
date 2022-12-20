module weather {
    requires javafx.controls;
    requires javafx.fxml;

    opens weather to javafx.fxml;
    exports weather;
}