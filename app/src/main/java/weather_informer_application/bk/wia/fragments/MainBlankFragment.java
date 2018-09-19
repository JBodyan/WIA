package weather_informer_application.bk.wia.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import weather_informer_application.bk.wia.R;

public class MainBlankFragment extends Fragment {


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
