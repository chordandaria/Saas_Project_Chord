package aria.p.chord.request_forms_module.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FormInfoPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mData;

    public FormInfoPagerAdapter(FragmentManager fm, ArrayList<Fragment> mData) {
        super(fm);
        this.mData = mData;
    }

    public FormInfoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    
}
