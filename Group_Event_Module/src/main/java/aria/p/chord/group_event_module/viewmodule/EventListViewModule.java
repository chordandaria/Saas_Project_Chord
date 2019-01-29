package aria.p.chord.group_event_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import aria.p.chord.group_event_module.beans.EventListBean;
import aria.p.chord.group_event_module.beans.EventListDataBean;
import aria.p.chord.group_event_module.interfaces.GetEventList_Interface;
import retrofit2.Call;

import static aria.p.chord.group_event_module.Contants.retrofit;

public class EventListViewModule extends ViewModel {
    private MutableLiveData<ArrayList<EventListDataBean>> eventAll=new MutableLiveData<ArrayList<EventListDataBean>>();
    private MutableLiveData<ArrayList<EventListDataBean>> eventActive=new MutableLiveData<ArrayList<EventListDataBean>>();
    private MutableLiveData<ArrayList<EventListDataBean>> eventOutActive=new MutableLiveData<ArrayList<EventListDataBean>>();
    private Context mContext;

    public MutableLiveData<ArrayList<EventListDataBean>> getEventAll() {
        return eventAll;
    }

    public MutableLiveData<ArrayList<EventListDataBean>> getEventActive() {
        return eventActive;
    }

    public MutableLiveData<ArrayList<EventListDataBean>> getEventOutActive() {
        return eventOutActive;
    }

    public void initViewModele(Context mContext){
        this.mContext=mContext;
        eventAll.setValue(new ArrayList<EventListDataBean>());
        eventActive.setValue(new ArrayList<EventListDataBean>());
        eventOutActive.setValue(new ArrayList<EventListDataBean>());
    }

    public void requestEventList(){
        GetEventList_Interface request=retrofit.create(GetEventList_Interface.class);
//        Call<EventListBean> call=request
    }
}
