package aria.p.chord.saas_project_chord.interfaces;

import aria.p.chord.saas_project_chord.Constants;
import aria.p.chord.saas_project_chord.bean.IndexBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import static aria.p.chord.saas_project_chord.Constants.GETHOMECONFIGS;

public interface GetIndexData_Interface {
    @GET(GETHOMECONFIGS)
    Call<IndexBean> getIndex(@Header("Authorization")String auth);
}
