package aria.p.chord.exam_module.fragment;

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

import aria.p.chord.exam_module.R;
import aria.p.chord.exam_module.bean.ExamInfoDataBean;
import aria.p.chord.exam_module.viewmodule.ExamViewModule;

public class ExamInitFragment extends Fragment {
    private ExamViewModule viewModule;
    private WebView exam;
    private Button start;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(ExamViewModule.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_init_exam,container,false);
        initView(view);
        viewModule.getInfo().observe(this, new Observer<ExamInfoDataBean>() {
            @Override
            public void onChanged(@Nullable ExamInfoDataBean examInfoDataBean) {
                exam.loadDataWithBaseURL(null,examInfoDataBean.getDescription(),"text/html","utf-8",null);
            }
        });
        return view;

    }

    public void initView(View view){
        exam=view.findViewById(R.id.wv_exam);
        start=view.findViewById(R.id.btn_start);
        WebSettings webSettings=exam.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModule.getPos().setValue(1);
            }
        });
    }
}
