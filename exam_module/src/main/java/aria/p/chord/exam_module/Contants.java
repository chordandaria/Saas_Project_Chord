package aria.p.chord.exam_module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Contants {
    public static final String BASEURL="http://dev.gjy.shangbanzugroup.com/";
    public static final String GETEXAMS="api/gonghui/exams";
    public static final String GETINFO="api/gonghui/exams/{exam}";
    //    实现当前工程内只有一个retrofit实例
    public static final OkHttpClient client=new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).
            readTimeout(30,TimeUnit.SECONDS).writeTimeout(15,TimeUnit.SECONDS).build();
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
