package aria.p.chord.group_event_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import java.util.ArrayList;
import aria.p.chord.group_event_module.beans.EventExtraBean;
import aria.p.chord.group_event_module.beans.EventInfoBean;
import aria.p.chord.group_event_module.beans.EventInfoDataBean;
import aria.p.chord.group_event_module.beans.OptionDataBean;
import aria.p.chord.group_event_module.interfaces.GetEventInfo_Interface;
import aria.p.chord.myutilslibrary.ShareHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static aria.p.chord.group_event_module.Contants.retrofit;

public class EventInfoViewModule extends ViewModel {
    private MutableLiveData<EventInfoDataBean> info=new MutableLiveData<EventInfoDataBean>();

    private MutableLiveData<ArrayList<EventExtraBean>> extras=new MutableLiveData<ArrayList<EventExtraBean>>();

    private MutableLiveData<ArrayList<OptionDataBean>> options=new MutableLiveData<ArrayList<OptionDataBean>>();

    private MutableLiveData<Integer> pos=new MutableLiveData<Integer>();

    private Context mContext;

    public MutableLiveData<EventInfoDataBean> getInfo() {
        return info;
    }

    public MutableLiveData<ArrayList<OptionDataBean>> getOptions() {
        return options;
    }

    public MutableLiveData<ArrayList<EventExtraBean>> getExtras() {
        return extras;
    }

    public MutableLiveData<Integer> getPos() {
        return pos;
    }

    public void initViewModule(Context mContext){
        this.mContext=mContext;
        extras.setValue(new ArrayList<EventExtraBean>());
        options.setValue(new ArrayList<OptionDataBean>());
        pos.setValue(1);
    }

    public void requestInfo(int id){
        GetEventInfo_Interface request=retrofit.create(GetEventInfo_Interface.class);
        Call<EventInfoBean> call=request.getCall(new ShareHelper(mContext).getAuth(),String.valueOf(id));
        call.enqueue(new Callback<EventInfoBean>() {
            @Override
            public void onResponse(Call<EventInfoBean> call, Response<EventInfoBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        options.setValue(response.body().getData().getOptions());
                        info.setValue(response.body().getData());
                        ArrayList<EventExtraBean> temp=new ArrayList<EventExtraBean>();
                        String []start=response.body().getData().getStart_time().split("\\s+");
                        String []end=response.body().getData().getEnd_time().split("\\s+");
                        temp.add(new EventExtraBean("报名时间",start[0]+" - "+end[0]));
                        if (response.body().getData().getExtra()!=null&&response.body().getData().getExtra().size()!=0){
                            temp.addAll(response.body().getData().getExtra());
                        }
                        extras.setValue(temp);
                    }
                }
            }

            @Override
            public void onFailure(Call<EventInfoBean> call, Throwable t) {

            }
        });
    }
}
