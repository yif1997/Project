package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.Shop;
import com.bawei.wangyifei.bean.ShopBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName ShopModel
 * @package com.bawei.wangyifei.model
 **/
public class ShopModel {
    public interface OnShopListener{
        void onShop(List<Shop> result,String status);
    }
    public OnShopListener onShopListener;
    public void setOnShopListener(OnShopListener onShopListener){
        this.onShopListener=onShopListener;
    }
    public void sendShop(String userId, String sessionId) {


        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.shopUrl,  ApiService.class);
        apiService.getShop(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShopBean>() {
                    @Override
                    public void onNext(ShopBean shopBean) {
                        Log.i("yyyy",shopBean.toString());
                        String status = shopBean.getStatus();
                        List<Shop> result = shopBean.getResult();
                        if (onShopListener!=null){
                            onShopListener.onShop(result,status);
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
