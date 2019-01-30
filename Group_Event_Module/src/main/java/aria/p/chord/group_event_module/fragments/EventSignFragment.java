package aria.p.chord.group_event_module.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import aria.p.chord.group_event_module.viewmodule.EventInfoViewModule;

public class EventSignFragment extends Fragment {
    private EventInfoViewModule viewModule;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModule= ViewModelProviders.of(getActivity()).get(EventInfoViewModule.class);
    }

}
