package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.MyAddress;
import com.bawei.wangyifei.bean.MyAddressBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName MyAddressModel
 * @package com.bawei.wangyifei.model
 **/
public class MyAddressModel {
    public interface OnMyAddressListener{
        void onMyAddress(List<MyAddress> result);
    }
    public OnMyAddressListener onMyAddressListener;
    public void setOnMyAddressListener(OnMyAddressListener onMyAddressListener){
        this.onMyAddressListener=onMyAddressListener;
    }
    public void sendMyAddress(String userId, String sessionId) {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.myaddressUrl, ApiService.class);
        apiService.getMyAddress(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<MyAddressBean>() {
                    @Override
                    public void onNext(MyAddressBean myAddressBean) {
                        Log.i("eeee",myAddressBean.toString());
                        List<MyAddress> result = myAddressBean.getResult();
                        if (onMyAddressListener!=null){
                            onMyAddressListener.onMyAddress(result);
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
