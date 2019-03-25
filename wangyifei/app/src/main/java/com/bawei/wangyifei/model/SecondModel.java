package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.Second;
import com.bawei.wangyifei.bean.SecondBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName SecondModel
 * @package com.bawei.wangyifei.model
 **/
public class SecondModel {
    public interface OnSecondListener{
        void onSecond(List<Second> result);
    }
    public OnSecondListener onSecondListener;
    public void setOnSecondListener(OnSecondListener onSecondListener){
        this.onSecondListener = onSecondListener;
    }
    public void sendSecond(String id) {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.secondUrl, ApiService.class);
        apiService.getSecond(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SecondBean>() {
                    @Override
                    public void onNext(SecondBean secondBean) {
                        Log.i("zzzz",secondBean.toString());
                        List<Second> result = secondBean.getResult();
                        if (onSecondListener!=null){
                            onSecondListener.onSecond(result);
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
