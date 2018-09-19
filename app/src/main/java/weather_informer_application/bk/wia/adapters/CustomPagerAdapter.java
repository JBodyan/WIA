package weather_informer_application.bk.wia.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import weather_informer_application.bk.wia.fragments.MainBlankFragment;
import weather_informer_application.bk.wia.fragments.WeatherListBlankFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[]{
           MainBlankFragment.newInstance("Today"),
           WeatherListBlankFragment.newInstance("Week")
   };

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
