package aria.p.chord.exam_module.interfaces;

import aria.p.chord.exam_module.bean.ExamInfoBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import static aria.p.chord.exam_module.Contants.GETINFO;

public interface GetExamInfo_Interface {
    @GET(GETINFO)
    Call<ExamInfoBean> getCall(@Header("Authorization")String auth, @Path("exam")int id);
}
