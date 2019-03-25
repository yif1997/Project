package com.bawei.wangyifei.frag;

import android.view.View;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseFragment;
import com.bawei.wangyifei.presenter.AssPresenter;

/**
 * @author 王艺霏
 * @fileName AssFragment
 * @package com.bawei.wangyifei.frag
 **/
public class AssFragment extends BaseFragment<AssPresenter>{


    @Override
    protected AssPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.assfragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
