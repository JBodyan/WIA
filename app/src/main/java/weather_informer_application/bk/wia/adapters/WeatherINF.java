package weather_informer_application.bk.wia.adapters;


import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weather_informer_application.bk.wia.entities.Weather;
import weather_informer_application.bk.wia.entities.WeatherList;
import weather_informer_application.bk.wia.entities.other.DatesHelper;
import weather_informer_application.bk.wia.entities.other.MyWeather;

public class WeatherINF {
    //Singleton
    private static WeatherINF weatherINF = null;
    public static WeatherINF getInstance() {
        return weatherINF = weatherINF == null ? new WeatherINF() : weatherINF;
    }
    //

    DatesHelper datesHelper = new DatesHelper();
    Weather weather = null;

    public void setWeather(Weather weather){
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }

    public List<WeatherList> getWeatherList(){
        return weather.getList();
    }

    private List<WeatherList> getTodayList(){
        SimpleDateFormat dateFormat = datesHelper.formatDayAndTime;
        List<WeatherList> todayWeather = new ArrayList<>();
        Date today = datesHelper.TODAY_00_00_00;
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        Log.v("DateFilter","Current date: "+dateFormat.format(today));
        for(WeatherList w:weather.getList()){
            try {
                Date weatherDate = dateFormat.parse(w.getDtTxt());
                if(weatherDate.before(tomorrow) && weatherDate.after(today)){
                    Log.v("DateFilter","Today date: "+weatherDate);
                    todayWeather.add(w);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return todayWeather;
    }

    public List<MyWeather> getEveryDayList(){
        SimpleDateFormat dateFormatTime = datesHelper.formatTime;
        SimpleDateFormat dateFormatDayAndTime = datesHelper.formatDayAndTime;
        List<MyWeather> todayWeather = new ArrayList<>();
        Date day = datesHelper.TODAY_12_00_00;
        String dayTime = dateFormatTime.format(day);
        //Log.v("DateFilter","Current time: "+dayTime);
        for(WeatherList w : weather.getList()){
            try {
                Date weatherDate = dateFormatDayAndTime.parse(w.getDtTxt());
                String otherTime = dateFormatTime.format(weatherDate);
                //Log.v("DateFilter","Today time filtered: "+otherTime);
                if(dayTime.equals(otherTime)){
                    //Log.v("DateFilter","Today time: "+weatherDate);
                    todayWeather.add(new MyWeather(w));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return todayWeather;
    }
}
