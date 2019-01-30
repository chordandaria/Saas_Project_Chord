package aria.p.chord.group_event_module.fragments;

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
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aria.p.chord.group_event_module.R;
import aria.p.chord.group_event_module.adapters.InfoExtrasAdapter;
import aria.p.chord.group_event_module.beans.EventExtraBean;
import aria.p.chord.group_event_module.beans.EventInfoDataBean;
import aria.p.chord.group_event_module.viewmodule.EventInfoViewModule;

public class EventInfoFragment extends Fragment {
    private ImageView cover;
    private ListView extras;
    private WebView info;
    private Button sign;
    private TextView title,joined,total,cost;
    private EventInfoViewModule viewModule;
    private InfoExtrasAdapter extrasAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(EventInfoViewModule.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.event_info_fragment,container,false);
        View head=LayoutInflater.from(getContext()).inflate(R.layout.event_info_head,null,false);
        View foot=LayoutInflater.from(getContext()).inflate(R.layout.event_info_foot,null,false);
        initView(view,head,foot);
        extrasAdapter=new InfoExtrasAdapter(viewModule.getExtras().getValue(),getContext());
        extras.setAdapter(extrasAdapter);
        extras.setDividerHeight(0);
        extras.addHeaderView(head);
        extras.addFooterView(foot);

        viewModule.getInfo().observe(this, new Observer<EventInfoDataBean>() {
            @Override
            public void onChanged(@Nullable EventInfoDataBean eventInfoDataBean) {
                Glide.with(getContext()).load(eventInfoDataBean.getCover()).into(cover);
                title.setText(eventInfoDataBean.getTitle());
                joined.setText(String.valueOf(eventInfoDataBean.getReserve_values_count()));
                total.setText(String.valueOf(eventInfoDataBean.getLimit()));
                cost.setText(String.valueOf(eventInfoDataBean.getCost()));
                info.loadDataWithBaseURL(null,eventInfoDataBean.getDescription(),"text/html","utf-8",null);
            }
        });
        viewModule.getExtras().observe(this, new Observer<ArrayList<EventExtraBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<EventExtraBean> eventExtraBeans) {
                extrasAdapter.setmData(eventExtraBeans);
            }
        });
        return view;
    }

    private void initView(View view,View head,View foot){
        cover=head.findViewById(R.id.iv_cover);
        title=head.findViewById(R.id.tv_title);
        joined=head.findViewById(R.id.join_count);
        total=head.findViewById(R.id.event_total);
        cost=head.findViewById(R.id.need_point);
        extras=view.findViewById(R.id.lv_info);
        info=foot.findViewById(R.id.event_info);
        sign=view.findViewById(R.id.btn_sign);
        WebSettings webSettings=info.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        head.setEnabled(false);
        foot.setEnabled(false);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModule.getPos().setValue(2);
            }
        });
    }
}
