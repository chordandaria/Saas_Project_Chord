package aria.p.chord.saas_project_chord.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

import aria.p.chord.saas_project_chord.R;
import aria.p.chord.saas_project_chord.adapters.IndexFragmentAdapter;
import aria.p.chord.saas_project_chord.bean.SectionsBean;
import aria.p.chord.saas_project_chord.viewmodel.IndexViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class IndexFragment extends Fragment {
    @BindView(R.id.lv_index)
    RecyclerView index;
    Unbinder unbinder;

    private IndexFragmentAdapter adapter;
    private IndexViewModel viewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(getActivity()).get(IndexViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_index,container,false);
        unbinder= ButterKnife.bind(this,view);
        adapter=new IndexFragmentAdapter(viewModel.getSections().getValue(),getContext());
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        index.setLayoutManager(manager);
        index.setAdapter(adapter);
        viewModel.getSections().observe(this, new Observer<ArrayList<SectionsBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<SectionsBean> sectionsBeans) {
                adapter.setmData(sectionsBeans);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        viewModel.requestIndex();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
