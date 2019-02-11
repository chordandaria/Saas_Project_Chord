package aria.p.chord.request_forms_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.ArrayList;

import aria.p.chord.myutilslibrary.ShareHelper;
import aria.p.chord.request_forms_module.bean.FormListBean;
import aria.p.chord.request_forms_module.bean.FormListDataBean;
import aria.p.chord.request_forms_module.interfaces.GetFormList_Interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static aria.p.chord.request_forms_module.Contants.retrofit;

public class ListViewModule extends ViewModel {
    private Context mContext;
    private MutableLiveData<ArrayList<FormListDataBean>> totalData=new MutableLiveData<ArrayList<FormListDataBean>>();
    private MutableLiveData<ArrayList<FormListDataBean>> activeData=new MutableLiveData<ArrayList<FormListDataBean>>();
    private MutableLiveData<ArrayList<FormListDataBean>> inactiveData=new MutableLiveData<ArrayList<FormListDataBean>>();

    public MutableLiveData<ArrayList<FormListDataBean>> getTotalData() {
        return totalData;
    }

    public MutableLiveData<ArrayList<FormListDataBean>> getActiveData() {
        return activeData;
    }

    public MutableLiveData<ArrayList<FormListDataBean>> getInactiveData() {
        return inactiveData;
    }

    public void initViewModule(Context mContext){
        this.mContext=mContext;
        totalData.setValue(new ArrayList<FormListDataBean>());
        activeData.setValue(new ArrayList<FormListDataBean>());
        inactiveData.setValue(new ArrayList<FormListDataBean>());
    }
    public void requestToTalData(int page){
        GetFormList_Interface request=retrofit.create(GetFormList_Interface.class);
        Call<FormListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,null,1);
        call.enqueue(new Callback<FormListBean>() {
            @Override
            public void onResponse(Call<FormListBean> call, Response<FormListBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        totalData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<FormListBean> call, Throwable t) {

            }
        });
    }

    public void requestActiveData(int page){
        GetFormList_Interface request=retrofit.create(GetFormList_Interface.class);
        Call<FormListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,"active",1);
        call.enqueue(new Callback<FormListBean>() {
            @Override
            public void onResponse(Call<FormListBean> call, Response<FormListBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        activeData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<FormListBean> call, Throwable t) {

            }
        });
    }

    public void requestInactiveData(int page){
        GetFormList_Interface request=retrofit.create(GetFormList_Interface.class);
        Call<FormListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,"inactive",1);
        call.enqueue(new Callback<FormListBean>() {
            @Override
            public void onResponse(Call<FormListBean> call, Response<FormListBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        inactiveData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<FormListBean> call, Throwable t) {

            }
        });
    }
}
