package weather_informer_application.bk.wia.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import weather_informer_application.bk.wia.R;
import weather_informer_application.bk.wia.adapters.WeatherAdapter;
import weather_informer_application.bk.wia.api.App;
import weather_informer_application.bk.wia.api.WeatherApi;
import weather_informer_application.bk.wia.entities.WeatherList;


public class MainBlankFragment extends Fragment {

    @BindView(R.id.tempID) TextView temp;
    @BindView(R.id.cityID) TextView city;
    @BindView(R.id.dateID) TextView date;
    WeatherAdapter adapter;
    WeatherApi weatherApi;
    Retrofit retrofit;

    private void init(){
        adapter = new WeatherAdapter();
        retrofit = App.get(getContext()).getRetrofit();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    private static final String ARG_PARAM1 = "param1";

    private String panelText;

    public MainBlankFragment() {
        // Required empty public constructor
    }

    public static MainBlankFragment newInstance(String param1) {
        MainBlankFragment fragment = new MainBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        if (getArguments() != null) {
            panelText = getArguments().getString(ARG_PARAM1);
        }

         Disposable disp = weatherApi.getWeather("709930")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r->{
                    adapter.setWeather(r);
                    Log.v("InfoAPI",adapter.getWeather().getCity().getName());
                },e->{
                    e.printStackTrace();
                    Log.v("InfoAPI",e.getMessage());
                });


        ArrayList<WeatherList> weatherLists = (ArrayList<WeatherList>) adapter.getWeatherList();
        for(WeatherList w: weatherLists){
            Log.v("Cicle","TIME: " + new Date(w.getDt()));
        }
        Date currentTime = Calendar.getInstance().getTime();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_blank, container, false);
        return view;
    }

}
