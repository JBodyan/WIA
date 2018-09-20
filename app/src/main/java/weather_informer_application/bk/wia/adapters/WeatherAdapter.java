package weather_informer_application.bk.wia.adapters;


import java.util.List;

import weather_informer_application.bk.wia.entities.Weather;
import weather_informer_application.bk.wia.entities.WeatherList;

public class WeatherAdapter {
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

}
