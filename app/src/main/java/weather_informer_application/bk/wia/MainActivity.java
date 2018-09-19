package weather_informer_application.bk.wia;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import weather_informer_application.bk.wia.adapters.CustomPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager_id) ViewPager viewPager;
    CustomPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new CustomPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}