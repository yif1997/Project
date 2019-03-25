package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.Login;
import com.bawei.wangyifei.bean.LoginBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName LoginModel
 * @package com.bawei.wangyifei.model
 **/
public class LoginModel {
    public interface OnLoginListener{
        void onLogin(String status,Login result);
    }
    public OnLoginListener onLoginListener;
    public void setOnLoginListener(OnLoginListener onLoginListener){
        this.onLoginListener=onLoginListener;
    }

    private Map<String,String> map = new HashMap<>();
    public void sendLogin(String phone, String pwd) {
       map.put("phone",phone);
       map.put("pwd",pwd);
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.loginUrl, null, null, ApiService.class);
        apiService.getLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        String status = loginBean.getStatus();
                        Login result = loginBean.getResult();
                        if (onLoginListener!=null){
                            onLoginListener.onLogin(status,result);
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
