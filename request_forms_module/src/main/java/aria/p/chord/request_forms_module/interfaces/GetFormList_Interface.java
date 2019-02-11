package aria.p.chord.request_forms_module.interfaces;

import android.support.annotation.NonNull;

import aria.p.chord.request_forms_module.bean.FormListBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import static aria.p.chord.request_forms_module.Contants.GETFORMS;

public interface GetFormList_Interface {
    @GET(GETFORMS)
    Call<FormListBean> getCall(@Header("Authorization")String auth, @Query("page")int i, @NonNull @Query("status")String status, @Query("is_published")int is_published);
}
