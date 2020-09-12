package platform.client.android.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import platform.client.android.Api;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {


    private static Api instance;
    /**
     * 超时时间
     */
    private static final int TIME_OUT = 10;

    public static Api getApi() {
        if (instance == null) {
            String baseUrl = "https://www.wanandroid.com/";
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS);
            instance = new Retrofit.Builder().baseUrl(baseUrl)
                    .client(builder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build().create(Api.class);
        }
        return instance;
    }


}