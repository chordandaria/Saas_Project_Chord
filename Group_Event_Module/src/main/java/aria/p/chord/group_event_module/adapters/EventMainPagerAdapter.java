package aria.p.chord.group_event_module.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class EventMainPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mData;
    private ArrayList<String> titles;
    public EventMainPagerAdapter(FragmentManager fm, ArrayList<Fragment> mData, ArrayList<String> titles) {
        super(fm);
        this.mData = mData;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void setmData(ArrayList<Fragment> mData) {
        this.mData = mData;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }
}
