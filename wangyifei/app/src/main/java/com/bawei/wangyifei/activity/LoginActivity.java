package com.bawei.wangyifei.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.bean.Login;
import com.bawei.wangyifei.presenter.LoginPresenter;
import com.bawei.wangyifei.utils.Utils;
import com.bawei.wangyifei.view.LoginView;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends BaseActivity implements LoginView ,View.OnClickListener {


    private EditText et_phone;
    private EditText et_pwd;
    private Button login;
    private LoginPresenter loginPresenter;
    private TextView regist;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected int layoutResID() {
        return R.layout.login1;
    }

    @Override
    protected void initView() {
        et_phone = findViewById(R.id.et_phone);
        et_pwd = findViewById(R.id.et_pwd);
        login = findViewById(R.id.login);
        regist = findViewById(R.id.regist);

        //实例化presenter
        loginPresenter = new LoginPresenter(this);

        login.setOnClickListener(this);
        regist.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        //获得edit对象
        edit = sp.edit();

    }


    @Override
    public void onLogin(String status, Login result) {
        if (status.equals("0000")){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            EventBus.getDefault().post(result);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String phone = et_phone.getText().toString();
                String pwd = et_pwd.getText().toString();
                //正则验证手机号
                boolean mobileNO = Utils.isMobileNO(phone);
                if (!mobileNO){
                    Toast.makeText(LoginActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.length()<3){
                    Toast.makeText(LoginActivity.this, "密码格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                

                loginPresenter.sendLogin(phone,pwd);
                break;
            case R.id.regist:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
