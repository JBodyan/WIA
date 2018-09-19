package weather_informer_application.bk.wia.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import weather_informer_application.bk.wia.fragments.MainBlankFragment;
import weather_informer_application.bk.wia.fragments.WeatherListBlankFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    String[] titles = new String[]{
            "Today","Week"
    };

    Fragment[] fragments = new Fragment[]{
           MainBlankFragment.newInstance(titles[0]),
           WeatherListBlankFragment.newInstance(titles[1])
   };

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
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
