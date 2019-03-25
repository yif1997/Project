package com.bawei.wangyifei.model;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.First;
import com.bawei.wangyifei.bean.FirstBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName FirstModel
 * @package com.bawei.wangyifei.model
 **/
public class FirstModel {
    public interface OnFirstListener{
        void onFirst( List<First> result);
    }
    public OnFirstListener onFirstListener;
    public void setOnFirstListener(OnFirstListener onFirstListener){
        this.onFirstListener=onFirstListener;
    }
    public void sendFirst() {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.firstUrl, ApiService.class);
        apiService.getFirst()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<FirstBean>() {
                    @Override
                    public void onNext(FirstBean firstBean) {
                        List<First> result = firstBean.getResult();
                        if (onFirstListener!=null){
                            onFirstListener.onFirst(result);
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
