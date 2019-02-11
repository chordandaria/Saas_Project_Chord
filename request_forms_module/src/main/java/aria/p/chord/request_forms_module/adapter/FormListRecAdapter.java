package aria.p.chord.request_forms_module.adapter;

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

import aria.p.chord.request_forms_module.R;
import aria.p.chord.request_forms_module.activity.FormInfoActivity;
import aria.p.chord.request_forms_module.bean.FormListDataBean;

public class FormListRecAdapter extends RecyclerView.Adapter<FormListRecAdapter.FormViewHolder> {
    private ArrayList<FormListDataBean> mData;
    private Context mContext;

    public FormListRecAdapter(ArrayList<FormListDataBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FormListRecAdapter.FormViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FormViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_form,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FormListRecAdapter.FormViewHolder viewHolder, int i) {
        viewHolder.title.setText(mData.get(i).getTitle());
        Glide.with(mContext).load(mData.get(i).getCover()).into(viewHolder.img);
        viewHolder.total.setText(String.valueOf(mData.get(i).getForm_values_count()));
        if (mData.get(i).getExpire()==2){
            viewHolder.hide.setVisibility(View.VISIBLE);
        }else {
            viewHolder.hide.setVisibility(View.GONE);
        }
        final int pos=i;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, FormInfoActivity.class);
                intent.putExtra("id",mData.get(pos).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class FormViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title,duration,total;
        private LinearLayout hide;
        public FormViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.iv_img);
            title=itemView.findViewById(R.id.tv_title);
            duration=itemView.findViewById(R.id.tv_duration);
            total=itemView.findViewById(R.id.tv_total);
            hide=itemView.findViewById(R.id.ll_hide);
        }
    }

    public void setmData(ArrayList<FormListDataBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }
}
