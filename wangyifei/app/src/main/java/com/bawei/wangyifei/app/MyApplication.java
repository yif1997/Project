package com.bawei.wangyifei.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author 王艺霏
 * @fileName MyApplication
 * @package com.bawei.wangyifei.app
 **/
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
