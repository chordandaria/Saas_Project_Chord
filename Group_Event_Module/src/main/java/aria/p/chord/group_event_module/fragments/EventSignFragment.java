package aria.p.chord.group_event_module.fragments;

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

import aria.p.chord.group_event_module.R;
import aria.p.chord.group_event_module.adapters.SignRecAdapter;
import aria.p.chord.group_event_module.beans.OptionDataBean;
import aria.p.chord.group_event_module.viewmodule.EventInfoViewModule;

public class EventSignFragment extends Fragment {
    private EventInfoViewModule viewModule;
    private LinearLayoutManager manager;
    private SignRecAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(EventInfoViewModule.class);
        manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter=new SignRecAdapter(viewModule.getOptions().getValue(),getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.event_sign_fragment,container,false);
        RecyclerView form=view.findViewById(R.id.rv_sign);
        form.setLayoutManager(manager);
        form.setAdapter(adapter);
        viewModule.getOptions().observe(this, new Observer<ArrayList<OptionDataBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<OptionDataBean> optionDataBeans) {
                adapter.setmData(optionDataBeans);
            }
        });
        return view;
    }
}
