package aria.p.chord.saas_project_chord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constants {
    public static final String BASEURL="http://dev.gjy.shangbanzugroup.com/";
    public static final String GETHOMECONFIGS="api/common/configs/home";
    public static final String LOGIN="api/passport/login";
    public static final String GETINFO="api/usercenter/info";




//    实现当前工程内只有一个retrofit实例
    public static final OkHttpClient client=new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).
            readTimeout(15,TimeUnit.SECONDS).writeTimeout(15,TimeUnit.SECONDS).build();
    public static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .serializeNulls()
            .create();
    public static final Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();
}
