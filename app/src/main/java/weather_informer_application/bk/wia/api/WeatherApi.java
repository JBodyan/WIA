package weather_informer_application.bk.wia.api;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weather_informer_application.bk.wia.entities.Weather;

public interface WeatherApi {

    @GET("/data/2.5/forecast?appid=b19396297136d376cbb0ccce638e33cf")
    Observable<Weather> getWeather(@Query("id") String cityId);

}
