package weather.model.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.model.ForecastData;
import weather.model.Weather;
import weather.model.WeatherService;

import java.util.List;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
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
    void shouldReturnCorrectValue() {
        //given
        OpenWeatherMapClientStub openWeatherMapClientStub = new OpenWeatherMapClientStub();

        //when
        int temp = openWeatherMapClientStub.getWeather().getTemp();
        int humidity = openWeatherMapClientStub.getWeather().getHumidity();
        String description = openWeatherMapClientStub.getWeather().getDescription();
        String icon = openWeatherMapClientStub.getWeather().getIcon();
        String date = openWeatherMapClientStub.getWeather().getDate();

        //then
        assertAll(
                () ->  assertThat(temp, is(12)),
                () ->  assertThat(humidity,is(not(empty()))),
                () ->  assertThat(description, notNullValue()),
                () -> assertThat(icon, nullValue()),
                () -> assertThat(date, is("2023-02-14 15:00:00"))
        );
    }

}
