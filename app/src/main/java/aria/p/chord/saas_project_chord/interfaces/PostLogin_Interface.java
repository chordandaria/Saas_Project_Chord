package aria.p.chord.saas_project_chord.interfaces;

import aria.p.chord.saas_project_chord.bean.LoginBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static aria.p.chord.saas_project_chord.Constants.LOGIN;

public interface PostLogin_Interface {
    @POST(LOGIN)
    @FormUrlEncoded
    Call<LoginBean> getCall(@Field("username")String username, @Field("password")String pass, @Field("login_type")String login_type);
}
