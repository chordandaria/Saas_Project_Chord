package aria.p.chord.exam_module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import aria.p.chord.exam_module.R;
import aria.p.chord.exam_module.bean.OptionBean;

public class ExamOptionAdapter extends BaseAdapter {
    private ArrayList<OptionBean> mData;
    private Context mContext;

    public ExamOptionAdapter(ArrayList<OptionBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
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
        view= LayoutInflater.from(mContext).inflate(R.layout.item_option,viewGroup,false);
        TextView title=view.findViewById(R.id.option_item);
        title.setText(mData.get(i).getLabel());
        return view;
    }

    public void setmData(ArrayList<OptionBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }
}
