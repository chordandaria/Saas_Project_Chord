package aria.p.chord.saas_project_chord.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.inject.Inject;

import aria.p.chord.myutilslibrary.ShareHelper;
import aria.p.chord.saas_project_chord.DaggerIndexComponent;
import aria.p.chord.saas_project_chord.IndexActivity;
import aria.p.chord.saas_project_chord.IndexComponent;
import aria.p.chord.saas_project_chord.bean.IndexBean;
import aria.p.chord.saas_project_chord.bean.InfoBean;
import aria.p.chord.saas_project_chord.bean.InfoDataBean;
import aria.p.chord.saas_project_chord.bean.SectionsBean;
import aria.p.chord.saas_project_chord.bean.SlidersBean;
import aria.p.chord.saas_project_chord.interfaces.GetIndexData_Interface;
import aria.p.chord.saas_project_chord.interfaces.GetInfo_Interface;
import dagger.internal.DaggerCollections;
import kotlin.jvm.JvmField;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static aria.p.chord.saas_project_chord.Constants.retrofit;

public class IndexViewModel extends ViewModel {
    private Context mContext;

    private MutableLiveData<ArrayList<SlidersBean>> sliders=new MutableLiveData<ArrayList<SlidersBean>>();

    private MutableLiveData<ArrayList<SectionsBean>> sections=new MutableLiveData<ArrayList<SectionsBean>>();

    private MutableLiveData<InfoDataBean> infoData=new MutableLiveData<InfoDataBean>();

    public MutableLiveData<ArrayList<SlidersBean>> getSliders() {
        return sliders;
    }

    public MutableLiveData<ArrayList<SectionsBean>> getSections() {
        return sections;
    }

    public MutableLiveData<InfoDataBean> getInfoData() {
        return infoData;
    }

    public void initViewModel(Context mContext,IndexActivity indexActivity) {
        this.mContext=mContext;
        sliders.setValue(new ArrayList<SlidersBean>());
        sections.setValue(new ArrayList<SectionsBean>());
    }

    public void requestIndex() {
        GetIndexData_Interface request=retrofit.create(GetIndexData_Interface.class);
        Call<IndexBean> call=request.getIndex(new ShareHelper(mContext).getAuth());
        call.enqueue(new Callback<IndexBean>() {
            @Override
            public void onResponse(Call<IndexBean> call, Response<IndexBean> response) {
                if (response.body()!=null) {
                    if (response.body().isSuccess()&&response.body().getStatus()==200&&response.body().getData()!=null){
                        sliders.setValue(response.body().getData().getConfig().getSliders());
                        sections.setValue(response.body().getData().getConfig().getSections());
                        Log.e("response========",String.valueOf(response.body().getData().getConfig().getSections().size()));
                    }
                }
            }

            @Override
            public void onFailure(Call<IndexBean> call, Throwable t) {
                Log.e("response========",t.toString());
            }
        });
    }

    public void requestInfo(){
        GetInfo_Interface request=retrofit.create(GetInfo_Interface.class);
        Call<InfoBean> call=request.getInfo(new ShareHelper(mContext).getAuth());
        call.enqueue(new Callback<InfoBean>() {
            @Override
            public void onResponse(Call<InfoBean> call, Response<InfoBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        infoData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<InfoBean> call, Throwable t) {

            }
        });
    }





}
