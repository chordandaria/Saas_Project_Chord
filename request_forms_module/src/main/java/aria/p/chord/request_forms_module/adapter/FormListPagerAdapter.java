package aria.p.chord.request_forms_module.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FormListPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mData;
    private ArrayList<String> title=new ArrayList<>();
    public FormListPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public FormListPagerAdapter(FragmentManager fm, ArrayList<Fragment> mData) {
        super(fm);
        this.mData = mData;
        title.add("全部");
        title.add("进行中");
        title.add("已结束");
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
