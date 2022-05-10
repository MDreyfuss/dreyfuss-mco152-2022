package weather.json;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {

    String appID = "25b629763406fe726693be7de7f4a026";
    @GET("https://api.openweathermap.org/data/2.5/weather?zip=10019,us&appid="+appID+"&units=imperial")
    Observable<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);

}
