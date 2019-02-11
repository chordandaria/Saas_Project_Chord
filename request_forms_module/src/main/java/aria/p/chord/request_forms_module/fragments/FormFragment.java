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
import aria.p.chord.request_forms_module.adapter.FormRecAdaper;
import aria.p.chord.request_forms_module.bean.FormControlsBean;
import aria.p.chord.request_forms_module.viewmodule.InfoViewModule;

public class FormFragment extends Fragment {
    private InfoViewModule viewModule;
    private LinearLayoutManager manager;
    private FormRecAdaper adaper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(InfoViewModule.class);
        manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adaper=new FormRecAdaper(viewModule.getControls().getValue(),getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_form,container,false);
        RecyclerView form=view.findViewById(R.id.rv_form);
        form.setLayoutManager(manager);
        form.setAdapter(adaper);
        viewModule.getControls().observe(this, new Observer<ArrayList<FormControlsBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<FormControlsBean> formControlsBeans) {
                adaper.setmData(formControlsBeans);
            }
        });
        return view;
    }
}
