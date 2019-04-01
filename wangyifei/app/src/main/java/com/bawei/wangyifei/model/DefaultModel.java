package com.bawei.wangyifei.model;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.DefaultBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName DefaultModel
 * @package com.bawei.wangyifei.model
 **/
public class DefaultModel {
    public interface OnMoListener{
        void onMoren(String message,String status);
    }
    public OnMoListener onMoListener;
    public void setOnMoListener(OnMoListener onMoListener){
        this.onMoListener=onMoListener;
    }
    public void sendDefault(String userId, String sessionId, String id) {

        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.defaultUrl, ApiService.class);
        apiService.getDefault(userId,sessionId,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DefaultBean>() {
                    @Override
                    public void onNext(DefaultBean defaultBean) {
                        String message = defaultBean.getMessage();
                        String status = defaultBean.getStatus();
                        if (onMoListener!=null){
                            onMoListener.onMoren(message,status);
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
