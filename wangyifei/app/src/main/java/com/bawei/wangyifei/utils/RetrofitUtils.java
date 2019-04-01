package com.bawei.wangyifei.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 王艺霏
 * @fileName RetrofitUtils
 * @package com.bawei.wangyifei.utils
 **/
public class RetrofitUtils {
    //单例
    private static RetrofitUtils retrofitUtils;
    private RetrofitUtils(){

    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


    //okHttp
    private static OkHttpClient okHttpClient;
    public synchronized static OkHttpClient getOkHttpClient(final String userId,final String sessionId){
        //拦截器
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan",message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("userId",userId)
                                .addHeader("sessionId",sessionId)
                                .build();

                        Log.i("yiyi",userId);
                        return chain.proceed(request);
                    }
                })
                .build();
        return okHttpClient;
    }



    //retrofit带拦截器 请求头
    public static Retrofit getRetrofits(String url,String userId,String sessionId){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient(userId,sessionId))
                .baseUrl(url)
                .build();
        return retrofit;
    }



    //retrofit 方法(不带拦截器请求头)
    public static Retrofit getRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
        return retrofit;
    }


    //获取动态代理（带拦截器）
    public <T> T doGet(String url,String userId,String sessionId,Class<T> service){

        Retrofit retrofit = getRetrofits(url, userId, sessionId);
        return retrofit.create(service);
    }



    //获取动态代理（不带拦截器）
    public <T> T doGet(String url,Class<T> service){
        Retrofit retrofit = getRetrofit(url);
        return retrofit.create(service);
    }

}
