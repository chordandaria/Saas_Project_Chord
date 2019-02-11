package aria.p.chord.group_event_module.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aria.p.chord.group_event_module.R;

public class ImageItemGridAdapter extends BaseAdapter {
    private ArrayList<String> mData;
    private Context mContext;

    public ImageItemGridAdapter(ArrayList<String> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if (mData.size()==0){
            return 1;
        }else if (mData.size()==9){
            return mData.size();
        }else {
            return mData.size()+1;
        }
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(mContext).inflate(R.layout.item_grid_image,viewGroup,false);
        ImageView img=view.findViewById(R.id.iv_img);
        LinearLayout upload=view.findViewById(R.id.ll_upload);
        if (i>mData.size()||mData.size()==0){

        }else {
            upload.setVisibility(View.GONE);
            Glide.with(mContext).load(mData.get(i)).into(img);
        }
        return view;
    }
}
