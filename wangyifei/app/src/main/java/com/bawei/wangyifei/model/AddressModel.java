package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.AddAddressBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName AddressModel
 * @package com.bawei.wangyifei.model
 **/
public class AddressModel {
    public interface OnAddressListener{
        void onAddress(String status);
    }
    public OnAddressListener onAddressListener;
    public void setOnAddressListener(OnAddressListener onAddressListener){
        this.onAddressListener=onAddressListener;
    }
    public void sendAddress(String userId, String sessionId, String user1, String phone1, String s, String mail1) {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.addressUrl,ApiService.class);
        apiService.getAddress(userId,sessionId,user1,phone1,s,mail1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<AddAddressBean>() {
                    @Override
                    public void onNext(AddAddressBean addAddressBean) {
                        String status = addAddressBean.getStatus();
                        Log.i("kkkk",status);
                        if (onAddressListener!=null){
                            onAddressListener.onAddress(status);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("ffff",t.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
