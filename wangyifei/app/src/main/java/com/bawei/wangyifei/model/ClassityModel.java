package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.Classity;
import com.bawei.wangyifei.bean.ClassityBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName ClassityModel
 * @package com.bawei.wangyifei.model
 **/
public class ClassityModel {

    public interface OnClassityListener{
        void onClassity(List<Classity> result);
    }
    public OnClassityListener onClassityListener;
    public void setOnClassityListener(OnClassityListener onClassityListener){
        this.onClassityListener = onClassityListener;
    }
    public void sendClassity(String id) {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.classUrl, ApiService.class);
        apiService.getClassity(id,1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ClassityBean>() {
                    @Override
                    public void onNext(ClassityBean classityBean) {
                        Log.i("hhhh",classityBean.toString());
                        List<Classity> result = classityBean.getResult();
                        if (onClassityListener!=null){
                            onClassityListener.onClassity(result);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("yyyy",t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
