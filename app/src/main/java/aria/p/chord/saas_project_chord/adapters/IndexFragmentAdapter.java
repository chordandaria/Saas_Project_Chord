package aria.p.chord.saas_project_chord.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aria.p.chord.exam_module.ExamListActivity;
import aria.p.chord.group_event_module.GroupEventActivity;
import aria.p.chord.myutilslibrary.IndexIconGridView;
import aria.p.chord.request_forms_module.FormListActivity;
import aria.p.chord.saas_project_chord.R;
import aria.p.chord.saas_project_chord.bean.SectionsBean;

public class IndexFragmentAdapter extends RecyclerView.Adapter {
    private ArrayList<SectionsBean> mData;
    private Context mContext;

    public IndexFragmentAdapter(ArrayList<SectionsBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder viewHolder=null;
        switch (i){
            case 0:
                view= LayoutInflater.from(mContext).inflate(R.layout.item_gridviewholder,viewGroup,false);
                viewHolder=new GridViewHolder(view);
                break;
            case 1:
                view=LayoutInflater.from(mContext).inflate(R.layout.item_imageviewholder,viewGroup,false);
                viewHolder=new ImageViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof GridViewHolder){
            final int pos=i;
            GridViewHolder gridViewHolder=(GridViewHolder) viewHolder;
            IconGridAdapter gridAdapter=new IconGridAdapter(mData.get(i).getIcons(),mContext);
            gridViewHolder.gridView.setAdapter(gridAdapter);
            gridViewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int a, long l) {
                    goToFunctions(mData.get(pos).getIcons().get(a).getType());
                }
            });
            gridViewHolder.title.setText(mData.get(i).getTitle());
        }
        if (viewHolder instanceof ImageViewHolder){
            ImageViewHolder imageViewHolder=(ImageViewHolder) viewHolder;
            Glide.with(mContext).load(mData.get(i).getImage()).into(imageViewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getType().equals("grid")) {
            return 0;
        }else{
            return 1;
        }
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        private IndexIconGridView gridView;
        private TextView title;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            gridView=itemView.findViewById(R.id.gv_icons);
            title=itemView.findViewById(R.id.tv_title);
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_img);
        }
    }

    public void setmData(ArrayList<SectionsBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void goToFunctions(String id) {
        Intent intent = null;
//        if (!TextUtils.isEmpty(params) && params.indexOf("id=") == 0) {
//            String[] str = params.split("=");
//            switch (id) {
//                case "vote":
//                    intent = new Intent(Index.this, VoteInfo.class);
//                    intent.putExtra("vote_id", Integer.valueOf(str[1]).intValue());
//                    break;
//                case "form":
//                    intent = new Intent(Index.this, Ivega_info_Activity.class);
//                    intent.putExtra("ivega_id", Integer.valueOf(str[1]).intValue());
//                    break;
//            }
//        } else {
            switch (id) {
                case "reserve":
                    intent = new Intent(mContext,GroupEventActivity.class);
//                    intent.putExtra("id", id);
                    break;
                case "exam":
                    intent = new Intent(mContext, ExamListActivity.class);
//                    intent.putExtra("type", 1);
                    break;
//                case "vote":
//                    intent = new Intent(Index.this, Vote_Activity.class);
//                    intent.putExtra("type", 2);
//                    break;
                case "form":
                    intent = new Intent(mContext, FormListActivity.class);
//                    intent.putExtra("type", 3);
                    break;
//                case "cms":
//                    intent = new Intent(Index.this, cms_Activity.class);
//                    break;
//                case "download":
//                    intent = new Intent(Index.this, Download_Activity.class);
//                    break;
//                case "approval":
//                    intent = new Intent(Index.this, ApprovalIndex.class);
//                    break;
//                case "store":
//                    intent = new Intent(Index.this, Shop_main_Activity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("activityID", params);
//                    intent.putExtras(bundle);
//                    break;
//                case "contest":
//                    intent = new Intent(Index.this, ContestIndex.class);
//                    break;
//                default:
//                    Toast.makeText(Index.this, "功能正在开发中......", Toast.LENGTH_SHORT).show();
//                    break;
            }
//        }
        if (intent != null) {
            mContext.startActivity(intent);
        }
    }
    }
