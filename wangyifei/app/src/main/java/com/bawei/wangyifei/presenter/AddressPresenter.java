package com.bawei.wangyifei.presenter;

import android.util.Log;

import com.bawei.wangyifei.activity.NewAddressActivity;
import com.bawei.wangyifei.model.AddressModel;
import com.bawei.wangyifei.view.AddressView;

/**
 * @author 王艺霏
 * @fileName AddressPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class AddressPresenter {

    private final AddressModel addressModel;
    private final AddressView addressView;

    public AddressPresenter(AddressView view){
        addressModel = new AddressModel();
        addressView = view;
    }

    public void sendAddress(String userId, String sessionId, String user1, String phone1, String s, String mail1) {
        Log.i("model",phone1);
        addressModel.sendAddress(userId,sessionId,user1,phone1,s,mail1);
        addressModel.setOnAddressListener(new AddressModel.OnAddressListener() {
            @Override
            public void onAddress(String status) {
                addressView.onAddress(status);
            }
        });
    }
}
