package aria.p.chord.exam_module.adapter;

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

import aria.p.chord.exam_module.R;
import aria.p.chord.exam_module.activity.ExamMainActivity;
import aria.p.chord.exam_module.bean.ExamListDataBean;

public class ExamListRecAdapter extends RecyclerView.Adapter<ExamListRecAdapter.ExamViewHolder> {
    private ArrayList<ExamListDataBean> mData;
    private Context mContext;

    public ExamListRecAdapter(ArrayList<ExamListDataBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ExamListRecAdapter.ExamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ExamViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rec_exam,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExamListRecAdapter.ExamViewHolder viewHolder, int i) {
        viewHolder.title.setText(mData.get(i).getTitle());
        Glide.with(mContext).load(mData.get(i).getCover()).into(viewHolder.cover);
        viewHolder.users.setText(String.valueOf(mData.get(i).getExam_values_count()));
        if (mData.get(i).getExpire()==2){
            viewHolder.hide.setVisibility(View.VISIBLE);
        }else {
            viewHolder.hide.setVisibility(View.GONE);
        }
        final int pos=i;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, ExamMainActivity.class);
                intent.putExtra("id",mData.get(pos).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ExamViewHolder extends RecyclerView.ViewHolder{
        private ImageView cover;
        private LinearLayout hide;
        private TextView title,duration,users;
        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            cover=itemView.findViewById(R.id.iv_img);
            title=itemView.findViewById(R.id.tv_title);
            duration=itemView.findViewById(R.id.tv_duration);
            users=itemView.findViewById(R.id.tv_users);
            hide=itemView.findViewById(R.id.ll_hide);
        }
    }

    public void setmData(ArrayList<ExamListDataBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }
}
