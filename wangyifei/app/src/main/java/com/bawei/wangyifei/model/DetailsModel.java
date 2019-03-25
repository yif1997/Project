package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.Details;
import com.bawei.wangyifei.bean.DetailsBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName DetailsModel
 * @package com.bawei.wangyifei.model
 **/
public class DetailsModel {
    public interface OnDetailsListener{
        void onDetails(Details result);
    }
    public OnDetailsListener onDetailsListener;
    public void setOnDetailsListener(OnDetailsListener onDetailsListener){
        this.onDetailsListener=onDetailsListener;
    }
    public void sendDetails(String id) {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.detailsUrl, ApiService.class);
        apiService.getDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DetailsBean>() {
                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        Log.i("qqqq",detailsBean.toString());
                        Details result = detailsBean.getResult();
                        if (onDetailsListener!=null){
                            onDetailsListener.onDetails(result);
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
