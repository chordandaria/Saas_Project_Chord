package aria.p.chord.group_event_module.interfaces;

import android.support.annotation.NonNull;

import aria.p.chord.group_event_module.beans.EventListBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static aria.p.chord.group_event_module.Contants.GETEVENTLIST;

public interface GetEventList_Interface {
    @Headers(
            "Content-Type:application/json")
    @GET(GETEVENTLIST)
    Call<EventListBean> getCall(@Header("Authorization")String auth, @Query("page")int i, @NonNull @Query("status")String status, @Query("is_published")int is_published);
}
