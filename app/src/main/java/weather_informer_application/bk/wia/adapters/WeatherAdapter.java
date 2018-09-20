package weather_informer_application.bk.wia.adapters;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import weather_informer_application.bk.wia.entities.Weather;
import weather_informer_application.bk.wia.entities.WeatherList;

public class WeatherAdapter {
    Weather weather = new Weather();

    public void setWeather(Weather weather){
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }

    public List<WeatherList> getWeatherList(){
        return weather.getList();
    }

    public WeatherList getWeatherByDate(String date){
        if(weather!=null) {
            for (WeatherList weather : weather.getList()) {
                if (weather.getDtTxt().equals(date)) {
                    return weather;
                }
            }
        }
        return null;
    }
}
