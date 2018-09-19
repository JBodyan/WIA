package weather_informer_application.bk.wia.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import weather_informer_application.bk.wia.R;

public class WeatherListBlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public WeatherListBlankFragment() {
        // Required empty public constructor
    }

    public static WeatherListBlankFragment newInstance(String param1) {
        WeatherListBlankFragment fragment = new WeatherListBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_list_blank, container, false);
    }

}