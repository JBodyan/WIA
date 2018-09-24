package weather_informer_application.bk.wia;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import weather_informer_application.bk.wia.adapters.CustomPagerAdapter;
import weather_informer_application.bk.wia.adapters.WeatherAdapter;
import weather_informer_application.bk.wia.adapters.WeatherINF;
import weather_informer_application.bk.wia.api.App;
import weather_informer_application.bk.wia.api.WeatherApi;
import weather_informer_application.bk.wia.entities.WeatherList;
import weather_informer_application.bk.wia.entities.other.DatesHelper;
import weather_informer_application.bk.wia.entities.other.MyWeather;

public class MainActivity extends AppCompatActivity {
    GraphView weatherGraphView;
    TextView descriptionView;
    TextView tempView;
    TextView cityView;
    TextView dateView;
    TextView humidityView;
    TextView windSpeedView;
    ImageView imageView;
    DatesHelper datesHelper;
    MyWeather myWeather;



    @BindView(R.id.tab_panel_id) TabLayout tabPanel;
    @BindView(R.id.view_pager_id) ViewPager viewPager;
    @BindView(R.id.toolbar_id) Toolbar toolbar;

    RecyclerView recyclerView;
    WeatherAdapter weatherAdapter;
    WeatherINF wINF;
    WeatherApi weatherApi;
    Retrofit retrofit;

    public void initRView(){
        recyclerView = findViewById(R.id.weatherRecyclerView);
        weatherAdapter = new WeatherAdapter(wINF.getEveryDayList(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherAdapter);

    }

    private void initViews(){
        weatherGraphView = findViewById(R.id.weatherGraphID);
        tempView = findViewById(R.id.tempID);
        cityView = findViewById(R.id.cityID);
        dateView = findViewById(R.id.dateID);
        imageView = findViewById(R.id.imageID);
        windSpeedView = findViewById(R.id.windSpeedID);
        humidityView = findViewById(R.id.humidityID);
        descriptionView = findViewById(R.id.descriptionID);
        try {
            Drawable d = Drawable.createFromStream(getAssets().open("background.png"), null);
            Typeface tf = Typeface.createFromAsset(getAssets(),"Behrens_KursivC.ttf");
            findViewById(R.id.firstFragmentID).setBackground(d);
            findViewById(R.id.secondFragmentID).setBackground(d);
            cityView.setTypeface(tf);
            dateView.setTypeface(tf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(){
        wINF = WeatherINF.getInstance();
        datesHelper = new DatesHelper();
        retrofit = App.get(this).getRetrofit();
        weatherApi = retrofit.create(WeatherApi.class);
    }
    private void initFragments(){
        viewPager.setAdapter(adapter);
        tabPanel.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
    }

    private void setInfo(){
        Log.v("DateFilter2", String.valueOf(wINF.getWeatherList().get(0).getMain().getTemp()));
        ArrayList<WeatherList> todayWeather = (ArrayList<WeatherList>) wINF.getWeatherList();
        myWeather = new MyWeather(todayWeather.get(0));
        String today = datesHelper.formatDay.format(Calendar.getInstance().getTime());
        String correctTemp = String.format("%.1f",myWeather.getTempC())+"C";
        cityView.setText(wINF.getWeather().getCity().getName());
        tempView.setText(correctTemp);
        dateView.setText(today);
        humidityView.setText("Humidity: "+myWeather.getHumidity()+"%");
        windSpeedView.setText("Wind speed: "+myWeather.getWindSpeed()+"mps");
        descriptionView.setText(myWeather.getDescription());
        Picasso.with(this).load(myWeather.getImageURL()).into(imageView);
        MyWeather[] weathersToday = new MyWeather[]{
                new MyWeather(todayWeather.get(0)),
                new MyWeather(todayWeather.get(1)),
                new MyWeather(todayWeather.get(2)),
                new MyWeather(todayWeather.get(3)),
                new MyWeather(todayWeather.get(4)),
                new MyWeather(todayWeather.get(5)),
                new MyWeather(todayWeather.get(6))
        };
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1, weathersToday[0].getTempC()),
                new DataPoint(2, weathersToday[1].getTempC()),
                new DataPoint(3, weathersToday[2].getTempC()),
                new DataPoint(4, weathersToday[3].getTempC()),
                new DataPoint(5, weathersToday[4].getTempC()),
                new DataPoint(6, weathersToday[5].getTempC()),
                new DataPoint(7, weathersToday[6].getTempC())
        });
        //Paint myPaint = new Paint();
        //myPaint.setARGB(255,0,255,100);
        //myPaint.setStrokeWidth(5);
        //series.setCustomPaint(myPaint);
        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                String text = weathersToday[(int)dataPoint.getX()-1].getDateTxt()+" Temp: "+String.format("%.1f",weathersToday[(int)dataPoint.getX()-1].getTempC())+"C";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
        });

        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb(150, (int) Math.abs(data.getY()*255/7),(int) data.getX()*255 );
            }
        });


        series.setAnimated(true);
        series.setSpacing(20);
        weatherGraphView.addSeries(series);
    }

    CustomPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new CustomPagerAdapter(getSupportFragmentManager());
        init();
        Disposable disp = weatherApi.getWeather("709930")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r->{
                    wINF.setWeather(r);
                    initFragments();
                    initViews();
                    setInfo();
                    initRView();
                    Log.v("InfoAPI1",wINF.getWeather().getCity().getName());
                },e->{
                    e.printStackTrace();
                    Log.v("InfoAPI1",e.getMessage());
                });

    }
}
