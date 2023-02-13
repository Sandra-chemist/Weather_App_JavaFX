package weather.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.model.client.WeatherClient;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    String cityName = "Ateny";
    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private WeatherClient weatherClient;
    @Test
    void shouldReturnCurrentWeatherForecast(){
        //given
        Weather expectedCurrentWeather = new Weather(7, 75, "light rain", "2023-02-09", null);
        given(weatherClient.getWeather(cityName)).willReturn(expectedCurrentWeather);

        //when
        Weather result = weatherService.getWeather(cityName);

        //then
        assertThat(result,is(expectedCurrentWeather));
    }
    @Test
    void shouldThrowFailedToGetWeatherExceptionWhenCannotGetWeather() {
        //given
        given(weatherClient.getWeather("city")).willThrow(new RuntimeException());

        //when & then
        assertThrows(FailedToGetWeatherException.class, () -> weatherService.getWeather("city"));
    }
    @Test
    void shouldReturnWeatherForecastList() {
        //given
        List<ForecastData> expectedWeatherForecasts = List.of(
                new ForecastData("light rain", 7, null),
                new ForecastData("rain", 15, null));
        given(weatherClient.getWeatherForecast(cityName)).willReturn(expectedWeatherForecasts);

        //when
        List<ForecastData> result = weatherService.getWeatherForecast(cityName);

        //then
        assertThat(result, is(expectedWeatherForecasts));
    }
    @Test
    void shouldThrowFailedToGetWeatherExceptionWhenCannotGetWeatherList() {
        //given
        given(weatherClient.getWeatherForecast("city")).willThrow(new RuntimeException());

        //when & then
        assertThrows(FailedToGetWeatherException.class, () -> weatherService.getWeatherForecast("city"));
    }
}
