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
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather("10019");

        Disposable disposable = observable
                .subscribeOn(Schedulers.io())
                .subscribe(this::onNext);
    }
    //then
    public void onNext(CurrentWeather currentWeather)
    {
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());
    }
}