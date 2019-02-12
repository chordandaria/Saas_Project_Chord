package aria.p.chord.exam_module.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aria.p.chord.exam_module.R;
import aria.p.chord.exam_module.adapter.ExamListRecAdapter;
import aria.p.chord.exam_module.bean.ExamListDataBean;
import aria.p.chord.exam_module.viewmodule.ListViewModule;

public class TotalFragment extends Fragment {
    private ListViewModule viewModule;
    private LinearLayoutManager manager;
    private ExamListRecAdapter adapter;
    private int page=1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(ListViewModule.class);
        manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter=new ExamListRecAdapter(viewModule.getTotalData().getValue(),getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.rec_list_fragment,container,false);
        RecyclerView exam=view.findViewById(R.id.rv_exam);
        exam.setLayoutManager(manager);
        exam.setAdapter(adapter);
        viewModule.getTotalData().observe(this, new Observer<ArrayList<ExamListDataBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<ExamListDataBean> examListDataBeans) {
                adapter.setmData(examListDataBeans);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModule.requestTotalData(page);
    }
}
