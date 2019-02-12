package aria.p.chord.exam_module.interfaces;

import android.support.annotation.NonNull;

import aria.p.chord.exam_module.bean.ExamListBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import static aria.p.chord.exam_module.Contants.GETEXAMS;

public interface GetExamList_Interface {
    @GET(GETEXAMS)
    Call<ExamListBean> getCall(@Header("Authorization")String auth, @Query("page")int i, @NonNull @Query("status")String status);

    @GET(GETEXAMS)
    Call<ExamListBean> getCall(@Header("Authorization")String auth, @Query("page")int i);
}
