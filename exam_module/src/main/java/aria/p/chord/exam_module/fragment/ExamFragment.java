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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import aria.p.chord.exam_module.R;
import aria.p.chord.exam_module.adapter.ExamOptionAdapter;
import aria.p.chord.exam_module.bean.OptionBean;
import aria.p.chord.exam_module.bean.QuestionBean;
import aria.p.chord.exam_module.viewmodule.ExamViewModule;

public class ExamFragment extends Fragment {
    private ListView exam;
    private ExamViewModule viewModule;
    private ExamOptionAdapter adapter;
    private TextView title;
    private int pos=0;
    private View head,foot,main;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(ExamViewModule.class);
        adapter=new ExamOptionAdapter(new ArrayList<OptionBean>(),getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main=LayoutInflater.from(getContext()).inflate(R.layout.fragment_exam_form,container,false);
        head=LayoutInflater.from(getContext()).inflate(R.layout.question_head,null,false);
        initView();
        exam.addHeaderView(head);
        exam.setAdapter(adapter);
        exam.setDividerHeight(0);
        viewModule.getQuestions().observe(this, new Observer<ArrayList<QuestionBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<QuestionBean> questionBeans) {
                viewModule.getQues().setValue(questionBeans.get(pos));
            }
        });
        viewModule.getQues().observe(this, new Observer<QuestionBean>() {
            @Override
            public void onChanged(@Nullable QuestionBean questionBean) {
                adapter.setmData(questionBean.getOptions());
                title.setText(questionBean.getTitle());
            }
        });
        return main;
    }

    public void initView(){
        exam=main.findViewById(R.id.lv_exam);
        title=head.findViewById(R.id.tv_title);
    }

    public void setListViewHeight(ListView listView) {
        ListAdapter listAdapter=listView.getAdapter();
        if (listAdapter==null) {
            return;
        }
        int totalHeight=0;
        for (int i=0;i<listAdapter.getCount();i++) {
            View listItem=listAdapter.getView(i,null,listView);
            listItem.measure(0,0);
            totalHeight +=listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params=listView.getLayoutParams();
        params.height=totalHeight+(listView.getDividerHeight()*(listAdapter.getCount()-1));
        params.height+=5;
        listView.setLayoutParams(params);
    }
}
