package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.activity.LoginActivity;
import com.bawei.wangyifei.bean.Login;
import com.bawei.wangyifei.model.LoginModel;
import com.bawei.wangyifei.view.LoginView;

/**
 * @author 王艺霏
 * @fileName LoginPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class LoginPresenter {

    private final LoginModel loginModel;
    private final LoginView loginView;

    public LoginPresenter(LoginView view){
        loginModel = new LoginModel();
        loginView = view;
    }
    public void sendLogin(String phone, String pwd) {
        loginModel.sendLogin(phone,pwd);
        loginModel.setOnLoginListener(new LoginModel.OnLoginListener() {
            @Override
            public void onLogin(String status, Login result) {
                loginView.onLogin(status,result);
            }
        });
    }
}
