package com.bawei.wangyifei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.bean.Shop;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BalanceActivity extends BaseActivity {


    @BindView(R.id.bala_recy)
    RecyclerView balaRecy;
    @BindView(R.id.bala_shop)
    TextView balaShop;
    @BindView(R.id.submit)
    Button submit;
    private List<Shop> list;


    @Override
    protected int layoutResID() {
        return R.layout.activity_balance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //获得传递过来的值
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        list =(List<Shop>) intent.getSerializableExtra("creation_bill");
        //算出数量和总价格
        setAllNumPrice(list);
    }

    private void setAllNumPrice(List<Shop> list) {
        double totalPrice =0;
        int num=0;
        for (int i=0;i<list.size();i++){
            totalPrice=totalPrice+list.get(i).getPrice()*list.get(i).getCount();
            num=num+list.get(i).getCount();
        }
        balaShop.setText(""+num+""+totalPrice);
    }


}
