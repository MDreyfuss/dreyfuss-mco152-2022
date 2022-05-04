package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {

    @Test
    void getCurrentWeather() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        //when
        CurrentWeather currentWeather = getCurrentWeather.getCurrentWeather("10019").blockingFirst();

        assertTrue(currentWeather.getTemperature() > -459.67);
        assertTrue(currentWeather.getMaxTemperature() > -459.67);
        assertTrue(currentWeather.getMinTemperature() > -459.67);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());
    }
}