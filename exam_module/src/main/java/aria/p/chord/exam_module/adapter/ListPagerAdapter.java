package aria.p.chord.exam_module.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ListPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mData;
    private ArrayList<String> titles=new ArrayList<String>();

    public ListPagerAdapter(FragmentManager fm, ArrayList<Fragment> mData) {
        super(fm);
        this.mData = mData;
        titles.add("全部");
        titles.add("进行中");
        titles.add("已结束");
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
}
