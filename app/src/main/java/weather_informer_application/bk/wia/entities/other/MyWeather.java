package weather_informer_application.bk.wia.entities.other;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.InputStream;

import java.net.URL;

import weather_informer_application.bk.wia.entities.WeatherList;

public class MyWeather {
    WeatherList weather;

    public MyWeather(WeatherList weather) {
        this.weather = weather;
    }

    public Double getTempC(){
        return weather.getMain().getTemp()-273.15;
    }
    public Double getTempK(){
        return weather.getMain().getTemp();
    }
    public Double getTempF(){
        return weather.getMain().getTemp()*1.8-459.67;
    }
    public String getDateTxt(){
        return weather.getDtTxt();
    }
    public Integer getHumidity(){
        return weather.getMain().getHumidity();
    }
    public Double getWindSpeed(){
        return weather.getWind().getSpeed();
    }
    public Drawable getImage(){
        try {
            String imgId = weather.getWeather().get(0).getIcon();
            URL url = new URL("http://openweathermap.org/img/w/"+imgId+".png");
                Log.v("ImageFilter",url.toString());
                InputStream is = (InputStream) url.getContent();
                Drawable d = Drawable.createFromStream(is, "weatherImage"+imgId);
                return d;
        } catch (Exception e) {
                return null;
        }
    }
    public String getImageURL(){
        String imgId = weather.getWeather().get(0).getIcon();
        return "http://openweathermap.org/img/w/"+imgId+".png";
    }
    public String getDescription(){
        return weather.getWeather().get(0).getDescription();
    }
}
