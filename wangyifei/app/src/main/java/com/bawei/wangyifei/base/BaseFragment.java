package com.bawei.wangyifei.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bawei.wangyifei.presenter.BasePresenter;

/**
 * @author 王艺霏
 * @fileName BaseFragment
 * @package com.bawei.wangyifei.base
 **/
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    public T presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = LinearLayout.inflate(getContext(),layoutResID(),null);

        presenter = getPresenter();


        //绑定
        //presenter.attachView(presenter);

        initView(view);

        initData();

        return view;
    }



    protected abstract T getPresenter();

    protected abstract int layoutResID();

    protected abstract void initView(View view);

    protected abstract void initData();

    //解绑
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        presenter.destoryView();
//    }
}
