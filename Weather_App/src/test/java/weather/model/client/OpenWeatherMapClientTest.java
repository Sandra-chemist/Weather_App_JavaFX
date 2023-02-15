package weather.model.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.model.ForecastData;
import weather.model.Weather;
import weather.model.WeatherService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherMapClientTest {

    String cityName = "Ateny";
    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private OpenWeatherMapClient openWeatherMapClient;

    @Test
    void shouldReturnWeatherForecastObject() {
        //given
        Weather expectedCurrentWeather = new Weather(7, 75, "light rain", "2023-02-09", null);
        given(openWeatherMapClient.getWeather(cityName)).willReturn(expectedCurrentWeather);

        //when
        Weather result = weatherService.getWeather(cityName);

        //then
        assertThat(result, sameInstance(expectedCurrentWeather));
    }

    @Test
    void shouldReturnWeatherForecastList() {
        //given
        List<ForecastData> expectedWeatherForecasts = List.of(
                new ForecastData("light rain", 7, null),
                new ForecastData("rain", 15, null));
        given(weatherService.getWeatherForecast(cityName)).willReturn(expectedWeatherForecasts);

        //when
        List<ForecastData> result = openWeatherMapClient.getWeatherForecast(cityName);

        //then
        assertThat(result, sameInstance(expectedWeatherForecasts));

    }
    @Test
    void shouldReturnCorrectTemperature() {
        //given
        OpenWeatherMapClientStub openWeatherMapClientStub = new OpenWeatherMapClientStub();

        //when
        int temp = openWeatherMapClientStub.getWeather(cityName).getTemp() ;

        //then
        assertThat(temp, is(12));
    }

    @Test
    void shouldReturnCorrectDescription() {
        //given
        OpenWeatherMapClientStub openWeatherMapClientStub = new OpenWeatherMapClientStub();

        //when
        String description = openWeatherMapClientStub.getWeather(cityName).getDescription() ;

        //then
        assertThat(description, notNullValue());
    }
}
