package aria.p.chord.request_forms_module.interfaces;

import aria.p.chord.request_forms_module.bean.FormInfoBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import static aria.p.chord.request_forms_module.Contants.GETFORMINFO;

public interface GetFormInfo_Interface {
    @GET(GETFORMINFO)
    Call<FormInfoBean> getCall(@Header("Authorization")String Token, @Path("id")int id);
}
