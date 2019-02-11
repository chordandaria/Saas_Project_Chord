package aria.p.chord.request_forms_module.fragments;

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

import aria.p.chord.request_forms_module.R;
import aria.p.chord.request_forms_module.adapter.FormListRecAdapter;
import aria.p.chord.request_forms_module.bean.FormListDataBean;
import aria.p.chord.request_forms_module.viewmodule.ListViewModule;

public class InactiveFragment extends Fragment {
    private ListViewModule viewModule;
    private LinearLayoutManager manager;
    private FormListRecAdapter adapter;
    private int page=1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(ListViewModule.class);
        manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_form,container,false);
        RecyclerView form=view.findViewById(R.id.rv_form);
        adapter=new FormListRecAdapter(viewModule.getTotalData().getValue(),getContext());
        form.setLayoutManager(manager);
        form.setAdapter(adapter);
        viewModule.getInactiveData().observe(this, new Observer<ArrayList<FormListDataBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<FormListDataBean> formListDataBeans) {
                adapter.setmData(formListDataBeans);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModule.requestInactiveData(page);
    }
}
