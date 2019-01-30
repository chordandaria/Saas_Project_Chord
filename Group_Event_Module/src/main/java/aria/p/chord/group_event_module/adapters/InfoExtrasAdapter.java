package aria.p.chord.group_event_module.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import aria.p.chord.group_event_module.R;
import aria.p.chord.group_event_module.beans.EventExtraBean;

public class InfoExtrasAdapter extends BaseAdapter {
    private ArrayList<EventExtraBean> mData;
    private Context mContext;

    public InfoExtrasAdapter(ArrayList<EventExtraBean> mData, Context mContext) {
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
        view= LayoutInflater.from(mContext).inflate(R.layout.item_info_extra,viewGroup,false);
        TextView key=view.findViewById(R.id.tv_key);
        TextView value=view.findViewById(R.id.tv_value);
        key.setText(mData.get(i).getTitle());
        value.setText(mData.get(i).getValue());
        view.setEnabled(false);
        return view;
    }

    public void setmData(ArrayList<EventExtraBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }
}
