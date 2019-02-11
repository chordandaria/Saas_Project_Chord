package aria.p.chord.request_forms_module.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import aria.p.chord.request_forms_module.R;
import aria.p.chord.request_forms_module.bean.FormInfoDataBean;
import aria.p.chord.request_forms_module.viewmodule.InfoViewModule;
import butterknife.BindView;

public class FormInfoFragment extends Fragment {
    private InfoViewModule viewModule;
    private ImageView cover;
    private WebView info;
    private TextView joinTime,joinCount;
    private Button sign;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(InfoViewModule.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_form_info,container,false);
        initView(view);
        viewModule.getInfoData().observe(this, new Observer<FormInfoDataBean>() {
            @Override
            public void onChanged(@Nullable FormInfoDataBean formInfoDataBean) {
                Glide.with(getActivity()).load(formInfoDataBean.getCover()).into(cover);
                joinTime.setText(formInfoDataBean.getStart_time());
                joinCount.setText(String.valueOf(formInfoDataBean.getForm_values_count()));
                info.loadDataWithBaseURL(null,formInfoDataBean.getDescription(),"text/html","utf-8",null);
            }
        });
        return view;
    }

    public void initView(View view){
        cover=view.findViewById(R.id.iv_info);
        info=view.findViewById(R.id.wv_info);
        joinTime=view.findViewById(R.id.tv_join_time);
        joinCount=view.findViewById(R.id.tv_join_count);
        sign=view.findViewById(R.id.btn_sign);
        WebSettings webSettings=info.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModule.getPos().setValue(1);
            }
        });
    }
}
