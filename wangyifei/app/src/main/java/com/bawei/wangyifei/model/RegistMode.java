package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.RegistBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName RegistMode
 * @package com.bawei.wangyifei.model
 **/
public class RegistMode {
    public interface OnRegistListener{
        void onRegist(String message,String status);
    }
    public OnRegistListener onRegistListener;
    public void setOnRegistListener(OnRegistListener onRegistListener){
        this.onRegistListener=onRegistListener;
    }

    public void sendRegist(String phone, String pwd) {

        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.registUrl, ApiService.class);
        apiService.getRegist(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RegistBean>() {
                    @Override
                    public void onNext(RegistBean registBean) {
                        Log.i("kkkk",registBean.toString());
                        String message = registBean.getMessage();
                        String status = registBean.getStatus();
                        if (onRegistListener!=null){
                            onRegistListener.onRegist(message,status);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
