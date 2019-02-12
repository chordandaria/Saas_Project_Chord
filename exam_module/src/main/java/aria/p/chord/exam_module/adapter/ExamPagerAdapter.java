package aria.p.chord.exam_module.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ExamPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mData;

    public ExamPagerAdapter(FragmentManager fm, ArrayList<Fragment> mData) {
        super(fm);
        this.mData = mData;
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
