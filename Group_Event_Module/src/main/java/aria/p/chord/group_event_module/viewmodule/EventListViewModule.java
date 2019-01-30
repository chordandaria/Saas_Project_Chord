package aria.p.chord.group_event_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import aria.p.chord.group_event_module.beans.EventListBean;
import aria.p.chord.group_event_module.beans.EventListDataBean;
import aria.p.chord.group_event_module.interfaces.GetEventList_Interface;
import aria.p.chord.myutilslibrary.ShareHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void requestEventList(int page, final boolean isRefresh){
        GetEventList_Interface request=retrofit.create(GetEventList_Interface.class);
        Call<EventListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,null,1);
        call.enqueue(new Callback<EventListBean>() {
            @Override
            public void onResponse(Call<EventListBean> call, Response<EventListBean> response) {
                if (response.body()!=null){
                    if(response.body().isSuccess()&&response.body().getStatus()==200){
                        if (isRefresh){
                            eventAll.setValue(response.body().getData());
                        }else {
                            ArrayList<EventListDataBean> data=eventAll.getValue();
                            data.addAll(response.body().getData());
                            eventAll.setValue(data);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<EventListBean> call, Throwable t) {

            }
        });
    }
    public void requestEventActive(int page, final boolean isRefresh){
        GetEventList_Interface request=retrofit.create(GetEventList_Interface.class);
        Call<EventListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,"active",1);
        call.enqueue(new Callback<EventListBean>() {
            @Override
            public void onResponse(Call<EventListBean> call, Response<EventListBean> response) {
                if (response.body()!=null){
                    if(response.body().isSuccess()&&response.body().getStatus()==200){
                        if (isRefresh){
                            eventActive.setValue(response.body().getData());
                        }else {
                            ArrayList<EventListDataBean> data=eventAll.getValue();
                            data.addAll(response.body().getData());
                            eventActive.setValue(data);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<EventListBean> call, Throwable t) {

            }
        });
    }
    public void requestEventInactive(int page, final boolean isRefresh){
        GetEventList_Interface request=retrofit.create(GetEventList_Interface.class);
        Call<EventListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,"inactive",1);
        call.enqueue(new Callback<EventListBean>() {
            @Override
            public void onResponse(Call<EventListBean> call, Response<EventListBean> response) {
                if (response.body()!=null){
                    if(response.body().isSuccess()&&response.body().getStatus()==200){
                        if (isRefresh){
                            eventOutActive.setValue(response.body().getData());
                        }else {
                            ArrayList<EventListDataBean> data=eventAll.getValue();
                            data.addAll(response.body().getData());
                            eventOutActive.setValue(data);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<EventListBean> call, Throwable t) {

            }
        });
    }
}
