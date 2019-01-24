package aria.p.chord.saas_project_chord.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.LinkedList;

import aria.p.chord.saas_project_chord.bean.IndexConfigBean;
import aria.p.chord.saas_project_chord.bean.SectionsBean;
import aria.p.chord.saas_project_chord.bean.SlidersBean;

public class IndexViewModel extends ViewModel {
    private Context mContext;

    private MutableLiveData<LinkedList<SlidersBean>> sliders=new MutableLiveData<LinkedList<SlidersBean>>();

    private MutableLiveData<LinkedList<SectionsBean>> sections=new MutableLiveData<LinkedList<SectionsBean>>();

    public MutableLiveData<LinkedList<SlidersBean>> getSliders() {
        return sliders;
    }

    public MutableLiveData<LinkedList<SectionsBean>> getSections() {
        return sections;
    }

    public void initViewModel(Context mContext) {
        this.mContext=mContext;
        sliders.setValue(new LinkedList<SlidersBean>());
        sections.setValue(new LinkedList<SectionsBean>());
    }

    public void requestIndex() {

    }
}
