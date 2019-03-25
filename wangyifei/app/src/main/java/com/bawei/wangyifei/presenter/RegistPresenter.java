package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.activity.RegistActivity;
import com.bawei.wangyifei.model.RegistMode;
import com.bawei.wangyifei.view.RegistView;

/**
 * @author 王艺霏
 * @fileName RegistPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class RegistPresenter {

    private final RegistMode registMode;
    private final RegistView registView;

    public RegistPresenter(RegistView view){
        registMode = new RegistMode();
        registView = view;
    }
    public void sendParameter(String phone, String pwd) {
        registMode.sendRegist(phone,pwd);
        registMode.setOnRegistListener(new RegistMode.OnRegistListener() {
            @Override
            public void onRegist(String message, String status) {
                registView.onRegist(message,status);
            }
        });
    }
}
