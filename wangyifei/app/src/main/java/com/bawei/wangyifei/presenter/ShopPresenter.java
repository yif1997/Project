package com.bawei.wangyifei.presenter;

import android.util.Log;

import com.bawei.wangyifei.bean.Shop;
import com.bawei.wangyifei.frag.ShopFragment;
import com.bawei.wangyifei.model.ShopModel;
import com.bawei.wangyifei.view.ShopView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName ShopPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class ShopPresenter extends BasePresenter<ShopView> {


    private final ShopModel shopModel;
    private final ShopView shopView;

    public ShopPresenter(ShopView view){
        shopModel = new ShopModel();
        shopView = view;
    }

    @Override
    public void sendShop(String userId, String sessionId) {
        shopModel.sendShop(userId,sessionId);
        shopModel.setOnShopListener(new ShopModel.OnShopListener() {
            @Override
            public void onShop(List<Shop> result,String status) {
                //Log.i("dfdfd",result.toString());
                shopView.onShop(result,status);
            }
        });
    }
}
