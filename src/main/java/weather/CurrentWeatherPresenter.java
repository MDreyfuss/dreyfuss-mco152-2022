package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

public class CurrentWeatherPresenter {

    private final GetCurrentWeatherFrame view;
    private final GetCurrentWeather model;
    private Disposable disposable;

    public CurrentWeatherPresenter(GetCurrentWeatherFrame view, GetCurrentWeather model)
    {
        this.model = model;
        this.view = view;
    }

    public void loadWeatherFromZip(String zip)
    {
        Observable<CurrentWeather> observable = model.getCurrentWeather(zip);

        disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);
    }

    private void onNext(CurrentWeather currentWeather)
    {
        double fahrenheit = currentWeather.getTemperature();
        view.setTemperature(fahrenheit);
    }

    private void onError(Throwable throwable)
    {
        throwable.printStackTrace();
        view.showError();
    }

    public void cancel()
    {
        if (disposable != null)
        {
            disposable.dispose();
        }
    }


}
