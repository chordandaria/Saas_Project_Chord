package aria.p.chord.saas_project_chord.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.LinkedList;

import aria.p.chord.myutilslibrary.ShareHelper;
import aria.p.chord.saas_project_chord.bean.IndexBean;
import aria.p.chord.saas_project_chord.bean.SectionsBean;
import aria.p.chord.saas_project_chord.bean.SlidersBean;
import aria.p.chord.saas_project_chord.interfaces.GetIndexData_Interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static aria.p.chord.saas_project_chord.Constants.retrofit;

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
        GetIndexData_Interface request=retrofit.create(GetIndexData_Interface.class);
        Call<IndexBean> call=request.getIndex(new ShareHelper(mContext).getAuth());
        call.enqueue(new Callback<IndexBean>() {
            @Override
            public void onResponse(Call<IndexBean> call, Response<IndexBean> response) {
                if (response.body()!=null) {
                    if (response.body().isSuccess()&&response.body().getStatus()==200&&response.body().getData()!=null){
                        sliders.setValue(response.body().getData().getConfig().getSliders());
                        sections.setValue(response.body().getData().getConfig().getSections());
                    }
                }
            }

            @Override
            public void onFailure(Call<IndexBean> call, Throwable t) {

            }
        });
    }
}
