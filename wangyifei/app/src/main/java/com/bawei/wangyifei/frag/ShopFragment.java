package com.bawei.wangyifei.frag;

import android.view.View;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseFragment;
import com.bawei.wangyifei.presenter.ShopPresenter;

/**
 * @author 王艺霏
 * @fileName ShopFragment
 * @package com.bawei.wangyifei.frag
 **/
public class ShopFragment extends BaseFragment<ShopPresenter>{


    @Override
    protected ShopPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.shopfragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
