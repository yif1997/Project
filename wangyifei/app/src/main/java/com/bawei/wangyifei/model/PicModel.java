package com.bawei.wangyifei.model;

import android.util.Log;

import com.bawei.wangyifei.api.Api;
import com.bawei.wangyifei.api.ApiService;
import com.bawei.wangyifei.bean.PicBean;
import com.bawei.wangyifei.bean.ResultBean1;
import com.bawei.wangyifei.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 王艺霏
 * @fileName PicModel
 * @package com.bawei.wangyifei.model
 **/
public class PicModel {
    public interface OnPicListener{
        void onPic(List<ResultBean1> result);
    }
    public OnPicListener onPicListener;
    public void setOnPicListener(OnPicListener onPicListener){
        this.onPicListener=onPicListener;
    }
    public void sendPic() {
        ApiService apiService = RetrofitUtils.getInstance().doGet(Api.picUrl, ApiService.class);
        apiService.getPic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<PicBean>() {
                    @Override
                    public void onNext(PicBean picBean) {
                        Log.i("aaaa",picBean.toString());
                        List<ResultBean1> result = picBean.getResult();
                        if (onPicListener!=null){
                            onPicListener.onPic(result);
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
