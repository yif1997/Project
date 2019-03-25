package com.bawei.wangyifei.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.presenter.RegistPresenter;
import com.bawei.wangyifei.view.RegistView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistActivity extends BaseActivity implements RegistView {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.regist)
    Button regist;
    private RegistPresenter registPresenter;

    @Override
    protected int layoutResID() {
        return R.layout.regist;
    }

    @Override
    protected void initView() {
        registPresenter = new RegistPresenter(this);
    }

    @Override
    protected void initData() {

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框的值
                String phone = etPhone.getText().toString();
                String pwd = etPwd.getText().toString();
                if (phone.equals("")||pwd.equals("")){
                    Toast.makeText(RegistActivity.this, "手机号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                registPresenter.sendParameter(phone,pwd);
            }
        });



    }


    @Override
    public void onRegist(String message, String status) {
        Log.i("ddddd",status);
        Log.i("llll",message);
        if (status.equals("0000"))
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        return;
    }
}
