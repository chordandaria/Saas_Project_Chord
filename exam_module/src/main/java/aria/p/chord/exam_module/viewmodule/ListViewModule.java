package aria.p.chord.exam_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.ArrayList;

import aria.p.chord.exam_module.bean.ExamListBean;
import aria.p.chord.exam_module.bean.ExamListDataBean;
import aria.p.chord.exam_module.interfaces.GetExamList_Interface;
import aria.p.chord.myutilslibrary.ShareHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static aria.p.chord.exam_module.Contants.retrofit;

public class ListViewModule extends ViewModel {
    private Context mContext;
    private MutableLiveData<ArrayList<ExamListDataBean>> totalData=new MutableLiveData<ArrayList<ExamListDataBean>>();
    private MutableLiveData<ArrayList<ExamListDataBean>> activeData=new MutableLiveData<ArrayList<ExamListDataBean>>();
    private MutableLiveData<ArrayList<ExamListDataBean>> inactiveData=new MutableLiveData<ArrayList<ExamListDataBean>>();

    public MutableLiveData<ArrayList<ExamListDataBean>> getTotalData() {
        return totalData;
    }

    public MutableLiveData<ArrayList<ExamListDataBean>> getActiveData() {
        return activeData;
    }

    public MutableLiveData<ArrayList<ExamListDataBean>> getInactiveData() {
        return inactiveData;
    }

    public void initViewModule(Context mContext){
        this.mContext=mContext;
        totalData.setValue(new ArrayList<ExamListDataBean>());
        activeData.setValue(new ArrayList<ExamListDataBean>());
        inactiveData.setValue(new ArrayList<ExamListDataBean>());
    }

    public void requestTotalData(int page){
        GetExamList_Interface request=retrofit.create(GetExamList_Interface.class);
        Call<ExamListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page);
        call.enqueue(new Callback<ExamListBean>() {
            @Override
            public void onResponse(Call<ExamListBean> call, Response<ExamListBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        totalData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<ExamListBean> call, Throwable t) {

            }
        });
    }

    public void requestActiveData(int page){
        GetExamList_Interface request=retrofit.create(GetExamList_Interface.class);
        Call<ExamListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,"active");
        call.enqueue(new Callback<ExamListBean>() {
            @Override
            public void onResponse(Call<ExamListBean> call, Response<ExamListBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        activeData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<ExamListBean> call, Throwable t) {

            }
        });
    }

    public void requestInactiveData(int page){
        GetExamList_Interface request=retrofit.create(GetExamList_Interface.class);
        Call<ExamListBean> call=request.getCall(new ShareHelper(mContext).getAuth(),page,"inactive");
        call.enqueue(new Callback<ExamListBean>() {
            @Override
            public void onResponse(Call<ExamListBean> call, Response<ExamListBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        inactiveData.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<ExamListBean> call, Throwable t) {

            }
        });
    }

}
