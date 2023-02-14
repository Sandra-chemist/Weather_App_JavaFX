package weather.model.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherMapClientTest {

    @Mock
    private RestTemplate restTemplate;
    private OpenWeatherMapClient openWeatherMapClient;
    @BeforeEach
    void setUp() {
        openWeatherMapClient = new OpenWeatherMapClient();
        restTemplate = new RestTemplate();
    }

    private String getWeatherFromJson() {
        String filePath = "weatherForecast.json";

        try (FileReader fileReader = new FileReader(ClassLoader.getSystemResource(filePath).getFile())) {
            Gson gson = new Gson();
            JsonObject weather = gson.fromJson(fileReader, JsonObject.class);
            String weatherForecast = weather.toString();
            System.out.println(weatherForecast);
        } catch (IOException e) {
            e.printStackTrace();
        };
        return filePath;
    }

}
