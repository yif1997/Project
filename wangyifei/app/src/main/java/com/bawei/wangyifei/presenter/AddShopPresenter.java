package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.model.AddShopModel;

/**
 * @author 王艺霏
 * @fileName AddShopPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class AddShopPresenter {

    private final AddShopModel addShopModel;

    public AddShopPresenter(){
        addShopModel = new AddShopModel();
    }
    public void senfAddShop(String jsonArray, String userId, String sessionId) {
        addShopModel.sendAddShop( jsonArray,userId,sessionId);
    }
}
