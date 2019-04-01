package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.activity.MyAddressActivity;
import com.bawei.wangyifei.bean.MyAddress;
import com.bawei.wangyifei.model.MyAddressModel;
import com.bawei.wangyifei.view.MyAddressView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyAddressPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class MyAddressPresenter {

    private final MyAddressModel myAddressModel;
    private final MyAddressView myAddressView;

    public MyAddressPresenter(MyAddressView view){
        myAddressModel = new MyAddressModel();
        myAddressView = view;
    }
    public void sendMyAddress(String userId, String sessionId) {
        myAddressModel.sendMyAddress(userId,sessionId);
        myAddressModel.setOnMyAddressListener(new MyAddressModel.OnMyAddressListener() {
            @Override
            public void onMyAddress(List<MyAddress> result) {
                myAddressView.onMyAddress(result);
            }
        });
    }
}
