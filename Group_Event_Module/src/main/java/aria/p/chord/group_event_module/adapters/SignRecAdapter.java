package aria.p.chord.group_event_module.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import aria.p.chord.group_event_module.R;
import aria.p.chord.group_event_module.beans.OptionDataBean;
import aria.p.chord.myutilslibrary.IndexIconGridView;

public class SignRecAdapter extends RecyclerView.Adapter {
    private ArrayList<OptionDataBean> mData;
    private Context mContext;

    public SignRecAdapter(ArrayList<OptionDataBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    public ArrayList<OptionDataBean> getmData() {
        return mData;
    }

    public void setmData(ArrayList<OptionDataBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case 0:
                return new ImageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sign_image,viewGroup,false));
            case 1:
                return new CheckboxViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sign_checkbox,viewGroup,false));
            case 2:
                return new RadioViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sign_radio,viewGroup,false));
            case 3:
                return new DescriptViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sign_descript,viewGroup,false));
            case 4:
                return new InputViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sign_input,viewGroup,false));
                default:
                    return new DescriptViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sign_descript,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final int pos=i;
        if (viewHolder instanceof InputViewHolder){
            InputViewHolder temp= (InputViewHolder) viewHolder;
            temp.title.setText(mData.get(i).getTitle());
            temp.input.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    mData.get(pos).getValue().clear();
                    mData.get(pos).getValue().add(editable.toString().trim());
                }
            });
        }else if (viewHolder instanceof ImageViewHolder){
            ImageViewHolder temp= (ImageViewHolder) viewHolder;
            temp.title.setText(mData.get(pos).getTitle());
            temp.initGridView(pos);
        }else if (viewHolder instanceof RadioViewHolder){
            RadioViewHolder temp= (RadioViewHolder) viewHolder;
            temp.title.setText(mData.get(pos).getTitle());
            for (int count=0;count<mData.get(pos).getOptions().size();count++){
                temp.addButton(mData.get(pos).getOptions().get(count),count);
            }
            temp.radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                }
            });
        }else if (viewHolder instanceof CheckboxViewHolder){
            CheckboxViewHolder temp= (CheckboxViewHolder) viewHolder;
            temp.title.setText(mData.get(pos).getTitle());
            for (int count=0;count<mData.get(pos).getOptions().size();count++){
                temp.addButton(count, mData.get(pos).getOptions().get(count), new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    }
                });
            }
        }else {
            DescriptViewHolder temp= (DescriptViewHolder) viewHolder;
            temp.title.setText(mData.get(i).getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (mData.get(position).getType()){
            case "image":
                return 0;
            case "checkbox":
                return 1;
            case "radio":
                return 2;
            case "descript":
                return 3;
            case "input":
                return 4;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class InputViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private EditText input;
        public InputViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
            input=itemView.findViewById(R.id.et_sign);
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        private IndexIconGridView imgs;
        private TextView title;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgs=itemView.findViewById(R.id.gv_sign);
            title=itemView.findViewById(R.id.tv_title);
        }
        public void initGridView(int pos){
            ImageItemGridAdapter imageItemGridAdapter=new ImageItemGridAdapter(mData.get(pos).getValue(),mContext);
            imgs.setAdapter(imageItemGridAdapter);
            imgs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }
            });
        }
    }

    class CheckboxViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private LinearLayout checkbox;
        public CheckboxViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
            checkbox=itemView.findViewById(R.id.ll_checkbox);
        }
        public void addButton(int p, String txt, CompoundButton.OnCheckedChangeListener listener){
            CheckBox box=new CheckBox(mContext);
            box.setId(p);
            box.setText(txt);
            box.setOnCheckedChangeListener(listener);
            checkbox.addView(box,p);
        }
    }

    class RadioViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private RadioGroup radios;
        public RadioViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
            radios=itemView.findViewById(R.id.rg_sign);
        }

        public void addButton(String option,int a){
            RadioButton button=new RadioButton(mContext);
            button.setId(a);
            button.setText(option);
            radios.addView(button,a);
        }
    }

    class DescriptViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public DescriptViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
        }
    }



}
