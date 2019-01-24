package aria.p.chord.saas_project_chord.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class IndexViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mData;
    private ArrayList<String> titles;

    public IndexViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public IndexViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> mData,ArrayList<String> titles) {
        super(fm);
        this.mData=mData;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.mData = fragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
