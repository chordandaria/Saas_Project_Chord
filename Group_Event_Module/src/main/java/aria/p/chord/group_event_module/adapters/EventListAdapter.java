package aria.p.chord.group_event_module.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aria.p.chord.group_event_module.R;
import aria.p.chord.group_event_module.activitices.EventInfoActivity;
import aria.p.chord.group_event_module.beans.EventListDataBean;
import butterknife.BindView;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    private ArrayList<EventListDataBean> mData;
    private Context mContext;

    public void setmData(ArrayList<EventListDataBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public EventListAdapter(ArrayList<EventListDataBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EventViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_eventlist,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder viewHolder, int i) {
        final EventListDataBean data=mData.get(i);
        viewHolder.total.setText(String.valueOf(data.getLimit()));
        viewHolder.title.setText(data.getTitle());
        viewHolder.signCount.setText(String.valueOf(data.getReserve_values_count()));
        Glide.with(mContext).load(data.getCover()).into(viewHolder.img);
        if (data.getExpire()==2){
            viewHolder.hide.setVisibility(View.VISIBLE);
        }else {
            viewHolder.hide.setVisibility(View.GONE);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, EventInfoActivity.class);
                intent.putExtra("id",data.getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class EventViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private LinearLayout hide;
        private TextView title,duration,signCount,total;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.iv_img);
            title=itemView.findViewById(R.id.tv_title);
            duration=itemView.findViewById(R.id.tv_duration);
            signCount=itemView.findViewById(R.id.tv_signcount);
            total=itemView.findViewById(R.id.tv_total);
            hide=itemView.findViewById(R.id.ll_hide);
        }
    }

}
