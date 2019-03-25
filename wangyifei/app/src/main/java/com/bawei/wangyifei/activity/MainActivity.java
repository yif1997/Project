package com.bawei.wangyifei.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.frag.AssFragment;
import com.bawei.wangyifei.frag.HomeFragment;
import com.bawei.wangyifei.frag.MyFragement;
import com.bawei.wangyifei.frag.RingFragment;
import com.bawei.wangyifei.frag.ShopFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.frag)
    FrameLayout frag;
    @BindView(R.id.radiobutton1)
    RadioButton radiobutton1;
    @BindView(R.id.radiobutton2)
    RadioButton radiobutton2;
    @BindView(R.id.radiobutton3)
    RadioButton radiobutton3;
    @BindView(R.id.radiobutton4)
    RadioButton radiobutton4;
    @BindView(R.id.radiobutton5)
    RadioButton radiobutton5;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;

    @Override
    protected int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        final HomeFragment homeFragment = new HomeFragment();
        final AssFragment assFragment = new AssFragment();
        final ShopFragment shopFragment = new ShopFragment();
        final RingFragment ringFragment = new RingFragment();
        final MyFragement myFragement = new MyFragement();

        transaction.add(R.id.frag,homeFragment);
        transaction.add(R.id.frag,assFragment);
        transaction.add(R.id.frag,shopFragment);
        transaction.add(R.id.frag,ringFragment);
        transaction.add(R.id.frag,myFragement);

        transaction.show(homeFragment).hide(assFragment).hide(shopFragment).hide(ringFragment).hide(myFragement);
        transaction.commit();

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.radiobutton1:
                        transaction1.show(homeFragment).hide(assFragment).hide(shopFragment).hide(ringFragment).hide(myFragement).commit();
                        break;
                    case R.id.radiobutton2:
                        transaction1.show(assFragment).hide(homeFragment).hide(shopFragment).hide(ringFragment).hide(myFragement).commit();
                        break;
                    case R.id.radiobutton3:
                        transaction1.show(shopFragment).hide(assFragment).hide(homeFragment).hide(ringFragment).hide(myFragement).commit();
                        break;
                    case R.id.radiobutton4:
                        transaction1.show(ringFragment).hide(assFragment).hide(shopFragment).hide(homeFragment).hide(myFragement).commit();
                        break;
                    case R.id.radiobutton5:
                        transaction1.show(myFragement).hide(assFragment).hide(shopFragment).hide(ringFragment).hide(homeFragment).commit();
                        break;
                }
            }
        });
    }

}
