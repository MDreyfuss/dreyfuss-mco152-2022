package weather;

import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import weather.json.CurrentWeather;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CurrentWeatherPresenterTest {

    @BeforeAll
    static void beforeAllTests()
    {
        RxJavaPlugins.setIoSchedulerHandler((scheduler) -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler((scheduler) -> Schedulers.trampoline());
    }

    @Test
    void loadWeatherFromZip()
    {
        //given
        GetCurrentWeatherFrame view = mock(GetCurrentWeatherFrame.class);
        GetCurrentWeather model = mock(GetCurrentWeather.class);
        CurrentWeatherPresenter presenter = new CurrentWeatherPresenter(view, model);
        CurrentWeather currentWeather = mock(CurrentWeather.class);
        Mockito.doReturn(100d).when(currentWeather).getTemperature();
        Mockito.doReturn(Observable.just(currentWeather)).when(model).getCurrentWeather("00000");

        //when
        presenter.loadWeatherFromZip("00000");

        //then
        verify(view).setTemperature(100.0);

    }
}