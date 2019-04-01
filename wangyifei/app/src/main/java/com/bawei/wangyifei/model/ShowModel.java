package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.ShowBean;
import com.bawei.wangyifei.bean.ShowResult;
import com.bawei.wangyifei.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName ShowModel
 * @package com.bawei.wangyifei.model
 **/
public class ShowModel {

    public interface OnShowListener{
        void onShow(ShowResult result);
    }
    public OnShowListener onShowListener;
    public void setOnShowListener(OnShowListener onShowListener){
        this.onShowListener=onShowListener;
    }
    public void sendShow() {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.showUrl, ApiService.class);
        apiService.getShow()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShowBean>() {
                    @Override
                    public void onNext(ShowBean showBean) {

                        ShowResult result = showBean.getResult();
                        if (onShowListener!=null){
                            onShowListener.onShow(result);
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
