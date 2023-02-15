package weather.model.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.model.Weather;
import weather.model.WeatherService;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherMapClientTest {

    String cityName = "Ateny";
    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private OpenWeatherMapClient openWeatherMapClient;

    @Test
    void shouldReturnWeatherForecastObject(){
        //given
        Weather expectedCurrentWeather = new Weather(7, 75, "light rain", "2023-02-09", null);
        given(openWeatherMapClient.getWeather(cityName)).willReturn(expectedCurrentWeather);

        //when
        Weather result = weatherService.getWeather(cityName);

        //then
        assertThat(result, sameInstance(expectedCurrentWeather));
    }
}
