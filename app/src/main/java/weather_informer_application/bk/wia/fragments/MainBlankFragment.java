package weather_informer_application.bk.wia.fragments;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import weather_informer_application.bk.wia.R;
import weather_informer_application.bk.wia.adapters.WeatherINF;
import weather_informer_application.bk.wia.entities.WeatherList;
import weather_informer_application.bk.wia.entities.other.DatesHelper;
import weather_informer_application.bk.wia.entities.other.MyWeather;


public class MainBlankFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

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
        if (getArguments() != null) {
            panelText = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_blank, container, false);
        return view;
    }

}
