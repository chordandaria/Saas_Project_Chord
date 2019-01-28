package aria.p.chord.saas_project_chord.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aria.p.chord.saas_project_chord.R;
import aria.p.chord.saas_project_chord.bean.IconsBean;

public class IconGridAdapter extends BaseAdapter {
    private ArrayList<IconsBean> mData;
    private Context mContext;

    public IconGridAdapter(ArrayList<IconsBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public IconsBean getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(mContext).inflate(R.layout.item_icon_gridview,viewGroup,false);
        ImageView imageView=view.findViewById(R.id.iv_icon);
        TextView title=view.findViewById(R.id.tv_icon_title);
        title.setText(mData.get(i).getTitle());
        Glide.with(mContext).load(mData.get(i).getImage()).into(imageView);
        return view;
    }
}
