package aria.p.chord.request_forms_module.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aria.p.chord.request_forms_module.R;
import aria.p.chord.request_forms_module.viewmodule.InfoViewModule;

public class FormFragment extends Fragment {
    private InfoViewModule viewModule;
    private LinearLayoutManager manager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(InfoViewModule.class);
        manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_form,container,false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
