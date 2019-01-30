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
import android.widget.Toast;

import java.util.ArrayList;

import aria.p.chord.group_event_module.R;
import aria.p.chord.group_event_module.adapters.EventListAdapter;
import aria.p.chord.group_event_module.beans.EventListDataBean;
import aria.p.chord.group_event_module.viewmodule.EventListViewModule;

public class EventOnActiveFragment extends Fragment {
    private int currentPage=1;
    private int totalPage=1;
    private EventListViewModule viewModule;
    private EventListAdapter adapter;
    private LinearLayoutManager manager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(EventListViewModule.class);
        manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter=new EventListAdapter(viewModule.getEventActive().getValue(),getContext());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.event_list_rec,container,false);
        RecyclerView eventList=view.findViewById(R.id.rv_event);
        eventList.setLayoutManager(manager);
        eventList.setAdapter(adapter);
        viewModule.getEventActive().observe(this, new Observer<ArrayList<EventListDataBean>>() {
            @Override
            public void onChanged(@Nullable ArrayList<EventListDataBean> eventListDataBeans) {
                adapter.setmData(eventListDataBeans);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshList();
    }

    public void refreshList(){
        currentPage=1;
        viewModule.requestEventActive(currentPage,true);
    }

    public void loadList(){
        currentPage++;
        if (currentPage>totalPage){
            currentPage--;
            Toast.makeText(getContext(),"已经到底部了",Toast.LENGTH_SHORT).show();
        }else {
            viewModule.requestEventActive(currentPage,false);
        }
    }
}
