package weather.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.model.client.WeatherClient;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private WeatherClient weatherClient;
    @Test
    void shouldReturnCurrentWeatherForecast(){
        //given
        Weather expectedCurrentWeather = new Weather(7, 75, "light rain", "2023-02-09", null);
        String cityName = "Ateny";
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
}
