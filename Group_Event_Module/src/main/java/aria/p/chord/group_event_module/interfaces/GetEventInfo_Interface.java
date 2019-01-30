package aria.p.chord.group_event_module.interfaces;

import aria.p.chord.group_event_module.beans.EventInfoBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import static aria.p.chord.group_event_module.Contants.GETEVENTINFO;

public interface GetEventInfo_Interface {
    @GET(GETEVENTINFO)
    Call<EventInfoBean> getCall(@Header("Authorization")String auth, @Path("reserve")String id);
}
