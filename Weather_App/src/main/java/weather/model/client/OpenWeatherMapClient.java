package weather.model.client;

import org.springframework.web.client.RestTemplate;
import weather.model.Weather;

import java.time.LocalDate;

public class OpenWeatherMapClient implements WeatherClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Weather getWeather(String cityName) {
        String response = null;
        response = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=Warszawa&appid=3ae4059ead35a9827fe77d59cd36f4fc&units=metric", String.class);
        System.out.println(response);
        return new Weather(cityName, 10, 50, "few clouds", LocalDate.now() );
    }
}
