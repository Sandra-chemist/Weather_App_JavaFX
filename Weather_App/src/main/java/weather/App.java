package weather;

import javafx.application.Application;
import javafx.stage.Stage;
import weather.view.ViewFactory;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMainWindow();
    }
}