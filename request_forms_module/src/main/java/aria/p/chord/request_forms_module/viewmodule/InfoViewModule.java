package aria.p.chord.request_forms_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.ArrayList;

import aria.p.chord.myutilslibrary.ShareHelper;
import aria.p.chord.request_forms_module.bean.FormControlsBean;
import aria.p.chord.request_forms_module.bean.FormInfoBean;
import aria.p.chord.request_forms_module.bean.FormInfoDataBean;
import aria.p.chord.request_forms_module.interfaces.GetFormInfo_Interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static aria.p.chord.request_forms_module.Contants.retrofit;

public class InfoViewModule extends ViewModel {
    private Context mContext;
    MutableLiveData<FormInfoDataBean> infoData=new MutableLiveData<FormInfoDataBean>();
    MutableLiveData<ArrayList<FormControlsBean>> controls=new MutableLiveData<ArrayList<FormControlsBean>>();

    public MutableLiveData<FormInfoDataBean> getInfoData() {
        return infoData;
    }

    public MutableLiveData<ArrayList<FormControlsBean>> getControls() {
        return controls;
    }

    public void initViewModule(Context mContext){
        this.mContext=mContext;
        infoData.setValue(new FormInfoDataBean());
        controls.setValue(new ArrayList<FormControlsBean>());
    }

    public void requestInfo(int id){
        GetFormInfo_Interface request=retrofit.create(GetFormInfo_Interface.class);
        Call<FormInfoBean> call=request.getCall(new ShareHelper(mContext).getAuth(),id);
        call.enqueue(new Callback<FormInfoBean>() {
            @Override
            public void onResponse(Call<FormInfoBean> call, Response<FormInfoBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        infoData.setValue(response.body().getData());
                        controls.setValue(response.body().getData().getControls());
                    }
                }
            }

            @Override
            public void onFailure(Call<FormInfoBean> call, Throwable t) {

            }
        });
    }

}
