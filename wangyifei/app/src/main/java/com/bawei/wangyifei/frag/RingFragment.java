package com.bawei.wangyifei.frag;

import android.view.View;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseFragment;
import com.bawei.wangyifei.presenter.RingPresenter;

/**
 * @author 王艺霏
 * @fileName RingFragment
 * @package com.bawei.wangyifei.frag
 **/
public class RingFragment extends BaseFragment<RingPresenter>{


    @Override
    protected RingPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.ringfragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
