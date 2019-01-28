package aria.p.chord.saas_project_chord.interfaces;

import aria.p.chord.saas_project_chord.bean.InfoBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import static aria.p.chord.saas_project_chord.Constants.GETINFO;

public interface GetInfo_Interface {
    @GET(GETINFO)
    Call<InfoBean> getInfo(@Header("Authorization")String auth);
}
