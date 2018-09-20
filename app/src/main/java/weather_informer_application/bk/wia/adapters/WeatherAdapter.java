package weather_informer_application.bk.wia.adapters;


import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<WeatherList> getWeatherToday(){
        if(weather!=null){
            for(WeatherList w : weather.getList()){
                try {
                    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //Date date = dateFormat.parse(w.getDt().toString());
                    Date d = new Date(w.getDt());
                    Log.v("Date=====  ",d.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
