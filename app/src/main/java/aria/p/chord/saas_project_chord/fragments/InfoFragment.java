package aria.p.chord.saas_project_chord.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aria.p.chord.saas_project_chord.R;
import aria.p.chord.saas_project_chord.bean.InfoDataBean;
import aria.p.chord.saas_project_chord.viewmodel.IndexViewModel;

public class InfoFragment extends Fragment {

    private IndexViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(getActivity()).get(IndexViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_info,container,false);
        viewModel.getInfoData().observe(this, new Observer<InfoDataBean>() {
            @Override
            public void onChanged(@Nullable InfoDataBean infoDataBean) {
                
            }
        });
        return view;
    }
}
