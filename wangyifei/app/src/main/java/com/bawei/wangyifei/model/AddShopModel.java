package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.AddShopBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author 王艺霏
 * @fileName AddShopModel
 * @package com.bawei.wangyifei.model
 **/
public class AddShopModel {

    public void sendAddShop(String jsonArray,String userId, String sessionId) {
        Log.i("qqqq",userId);
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.addShopUrl,  ApiService.class);
        apiService.getaddShop(RequestBody.create(MediaType.parse("text/plain"),jsonArray) ,userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<AddShopBean>() {
                    @Override
                    public void onNext(AddShopBean addShopBean) {
                        String status = addShopBean.getMessage();
                        Log.i("aaaa",status);
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
