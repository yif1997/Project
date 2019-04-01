package com.bawei.wangyifei.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.activity.BalanceActivity;
import com.bawei.wangyifei.adapter.MyShopAdapter;
import com.bawei.wangyifei.base.BaseFragment;
import com.bawei.wangyifei.bean.Shop;
import com.bawei.wangyifei.presenter.ShopPresenter;
import com.bawei.wangyifei.view.ShopView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王艺霏
 * @fileName ShopFragment
 * @package com.bawei.wangyifei.frag
 **/
public class ShopFragment extends BaseFragment<ShopPresenter> implements ShopView {
    private List<Shop> shop_list = new ArrayList<>();
    private List<Shop> creation_bill;
    private RecyclerView recy_shop;
    private CheckBox check_all;
    private TextView price_all;
    private Button price_go;
    private SharedPreferences sp_login;
    private String userId;
    private String sessionId;
    private ShopPresenter shopPresenter;
    private MyShopAdapter myShopAdapter;
    private int sum =0;
    private List<Shop> list;
    @Override
    protected ShopPresenter getPresenter() {

        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.shopfragment;
    }
@Override
public void onResume() {
    super.onResume();
    shopPresenter.sendShop(userId,sessionId);
}


    @Override
    protected void initView(View view) {
        //找控件
        recy_shop = view.findViewById(R.id.recy_shop);
        check_all = view.findViewById(R.id.check_all);
        price_all = view.findViewById(R.id.price_all);
        price_go = view.findViewById(R.id.price_go);

        //从sharedpreference取出
        sp_login = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        userId = sp_login.getString("userId", null);
        sessionId = sp_login.getString("sessionId", null);


        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recy_shop.setLayoutManager(linearLayoutManager);

        //设置分割线
        recy_shop.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        shopPresenter = new ShopPresenter(this);
    }

    @Override
    protected void initData() {

        if (!TextUtils.isEmpty(userId)&&!TextUtils.isEmpty(sessionId)){
            shopPresenter.sendShop(userId,sessionId);
        }

    //全选点击
        check_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAll(check_all.isChecked());
                myShopAdapter.notifyDataSetChanged();
            }


        });


        //去结算
        price_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String price_alll = price_all.getText().toString();
                //判断总价不为空
                if (!price_alll.equals("0")&&!price_alll.equals("0.0")){
                    Intent intent = new Intent(getContext(), BalanceActivity.class);
                    creation_bill = new ArrayList<>();
                    //判断商品是否选中
                    //如果呗选中就放到集合里，通过intent传值
                    for (int i=0;i<shop_list.size();i++){
                        if (shop_list.get(i).isItem_check()){
                            creation_bill.add(new Shop(
                               shop_list.get(i).getCommodityId(),
                               shop_list.get(i).getCommodityName(),
                               shop_list.get(i).getPic(),
                               shop_list.get(i).getPrice(),
                                    shop_list.get(i).getCount()
                            ));
                        }
                    }
                    intent.putExtra("creation_bill", (Serializable) creation_bill);
                    startActivity(intent);
                }
            }
        });

    }




    @Override
    public void onShop(final List<Shop> result, String status) {
        list=result;
//        if (!status.equals("0000")){
//            Toast.makeText(getContext(), "没有登录", Toast.LENGTH_SHORT).show();
//            return;
//        }

        if (result!=null){
            myShopAdapter = new MyShopAdapter(getContext(), result);
            recy_shop.setAdapter(myShopAdapter);

            myShopAdapter.setOnCallBackListener(new MyShopAdapter.OnCallBackListener() {
                @Override
                public void callBack(List<Shop> result) {
                    int priceAll=0;
                    int num=0;
                    int totalNum=0;
                    for (int i=0;i<result.size();i++){
                        boolean item_check = result.get(i).isItem_check();
                        totalNum=result.get(i).getCount();

                        //选中状态
                        if (item_check){
                            priceAll+=(result.get(i).getCount()*result.get(i).getPrice());
                            num+=result.get(i).getCount();
                        }
                    }
                    if (num==totalNum){
                        check_all.setChecked(true);
                    }
                    else {
                        check_all.setChecked(false);
                    }
                    price_all.setText("合计："+priceAll);
                    price_go.setText("去结算：("+num+")");
                }
            });
        }



//        check_all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (check_all.isChecked()){
//                    for (int i=0;i<result.size();i++){
//                        result.get(i).setItem_check(true);
//                        int count = result.get(i).getCount();
//                        int price = result.get(i).getPrice();
//                        sum+=(count*price);
//                    }
//                    price_all.setText(sum+"");
//                }
//                else {
//                    for (int i=0;i<result.size();i++){
//                        result.get(i).setItem_check(false);
//                    }
//                    sum=0;
//                    price_all.setText(sum+"");
//                }
//                myShopAdapter.notifyDataSetChanged();
//            }
//        });






    }
    private void checkAll(boolean checked) {
        int priceAll = 0;
        int num = 0;
        for (int i=0;i<list.size();i++){
            //修改商品的复选框
            list.get(i).setItem_check(checked);
            priceAll = priceAll+(list.get(i).getCount()*list.get(i).getPrice());
            num = num+list.get(i).getCount();
        }
        if (checked){
            price_all.setText("合计："+priceAll);
            price_go.setText("去结算：("+num+")");
        }
        else {
            price_all.setText("合计："+0.0);
            price_go.setText("去结算：("+0+")");
        }
    }





}
