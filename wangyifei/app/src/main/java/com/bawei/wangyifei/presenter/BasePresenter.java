package com.bawei.wangyifei.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author 王艺霏
 * @fileName BasePresenter
 * @package com.bawei.wangyifei.presenter
 **/
public abstract class BasePresenter<T> {
    public abstract void sendShop(String userId, String sessionId);


   private WeakReference<T> tWeakReference;

    public void attachView(T t){
        tWeakReference = new WeakReference<T>(t);
    }

    public void destoryView(){
        if (tWeakReference!=null){
            tWeakReference.clear();
            tWeakReference=null;
        }
    }




}
