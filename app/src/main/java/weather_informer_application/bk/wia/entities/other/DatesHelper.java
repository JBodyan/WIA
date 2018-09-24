package weather_informer_application.bk.wia.entities.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesHelper {
    public Date TODAY_00_00_00;
    public Date TODAY_03_00_00;
    public Date TODAY_06_00_00;
    public Date TODAY_09_00_00;
    public Date TODAY_12_00_00;
    public Date TODAY_15_00_00;
    public Date TODAY_18_00_00;
    public Date TODAY_21_00_00;
    public SimpleDateFormat formatDay;
    public SimpleDateFormat formatDayAndTime;
    public SimpleDateFormat formatTime;
    public DatesHelper() {
        try {
            formatTime = new SimpleDateFormat("HH:mm:ss");
            formatDay = new SimpleDateFormat("yyyy-MM-dd");
            formatDayAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String today = formatDay.format(Calendar.getInstance().getTime());
            TODAY_00_00_00 = formatDayAndTime.parse(today+" 00:00:00");
            TODAY_03_00_00 = formatDayAndTime.parse(today+" 03:00:00");
            TODAY_06_00_00 = formatDayAndTime.parse(today+" 06:00:00");
            TODAY_09_00_00 = formatDayAndTime.parse(today+" 09:00:00");
            TODAY_12_00_00 = formatDayAndTime.parse(today+" 12:00:00");
            TODAY_15_00_00 = formatDayAndTime.parse(today+" 15:00:00");
            TODAY_18_00_00 = formatDayAndTime.parse(today+" 18:00:00");
            TODAY_21_00_00 = formatDayAndTime.parse(today+" 21:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
