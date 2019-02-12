package aria.p.chord.exam_module.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.ArrayList;

import aria.p.chord.exam_module.bean.ExamInfoBean;
import aria.p.chord.exam_module.bean.ExamInfoDataBean;
import aria.p.chord.exam_module.bean.QuestionBean;
import aria.p.chord.exam_module.interfaces.GetExamInfo_Interface;
import aria.p.chord.myutilslibrary.ShareHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static aria.p.chord.exam_module.Contants.retrofit;

public class ExamViewModule extends ViewModel {
    private Context mContext;
    private MutableLiveData<ExamInfoDataBean> info=new MutableLiveData<ExamInfoDataBean>();
    private MutableLiveData<ArrayList<QuestionBean>> questions=new MutableLiveData<ArrayList<QuestionBean>>();
    private MutableLiveData<QuestionBean> ques=new MutableLiveData<QuestionBean>();
    private MutableLiveData<Integer> pos=new MutableLiveData<Integer>();

    public MutableLiveData<ExamInfoDataBean> getInfo() {
        return info;
    }

    public MutableLiveData<ArrayList<QuestionBean>> getQuestions() {
        return questions;
    }

    public MutableLiveData<QuestionBean> getQues() {
        return ques;
    }

    public MutableLiveData<Integer> getPos() {
        return pos;
    }

    public void initViewModule(Context mContext){
        this.mContext=mContext;
        pos.setValue(0);
    }

    public void requsetInfo(int id){
        GetExamInfo_Interface request=retrofit.create(GetExamInfo_Interface.class);
        Call<ExamInfoBean> call=request.getCall(new ShareHelper(mContext).getAuth(),id);
        call.enqueue(new Callback<ExamInfoBean>() {
            @Override
            public void onResponse(Call<ExamInfoBean> call, Response<ExamInfoBean> response) {
                if (response.body()!=null){
                    if (response.body().isSuccess()&&response.body().getStatus()==200){
                        info.setValue(response.body().getData());
                        questions.setValue(response.body().getData().getQuestions());
                    }
                }
            }

            @Override
            public void onFailure(Call<ExamInfoBean> call, Throwable t) {

            }
        });
    }

    public void setQuestion(int pos){
        ques.setValue(questions.getValue().get(pos));
    }
}
