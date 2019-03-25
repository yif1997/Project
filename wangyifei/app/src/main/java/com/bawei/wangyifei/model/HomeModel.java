package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.JsonBean;
import com.bawei.wangyifei.bean.ResultBean;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName HomeModel
 * @package com.bawei.wangyifei.model
 **/
public class HomeModel {
    public interface OnSearchListener{
        void onSearch(List<ResultBean> result);
    }
    public OnSearchListener onSearchListener;
    public void setOnSearchListener(OnSearchListener onSearchListener){
        this.onSearchListener=onSearchListener;
    }
    public void sendParameter(String goods) {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.searchUrl, ApiService.class);
        apiService.getSearch(goods,1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<JsonBean>() {
                    @Override
                    public void onNext(JsonBean jsonBean) {
                        Log.i("xxx",jsonBean.toString());
                        List<ResultBean> result = jsonBean.getResult();
                        if (onSearchListener!=null){
                            onSearchListener.onSearch(result);
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
