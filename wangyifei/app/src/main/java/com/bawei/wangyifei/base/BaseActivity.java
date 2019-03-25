package com.bawei.wangyifei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.wangyifei.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * @author 王艺霏
 * @fileName BaseActivity
 * @package com.bawei.wangyifei.base
 **/
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layoutResID());
        ButterKnife.bind(this);
        initView();

        initData();

    }

    protected abstract int layoutResID();

    protected abstract void initView();

    protected abstract void initData();
}
