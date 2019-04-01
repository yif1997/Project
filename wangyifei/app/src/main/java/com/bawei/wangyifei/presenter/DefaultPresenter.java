package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.activity.MyAddressActivity;
import com.bawei.wangyifei.model.DefaultModel;
import com.bawei.wangyifei.view.DefaultView;

/**
 * @author 王艺霏
 * @fileName DefaultPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class DefaultPresenter {

    private final DefaultModel defaultModel;
    private final DefaultView defaultView;

    public DefaultPresenter(DefaultView view){
        defaultModel = new DefaultModel();
        defaultView = view;
    }
    public void sendDefault(String userId, String sessionId, String id) {
        defaultModel.sendDefault(userId,sessionId,id);
        defaultModel.setOnMoListener(new DefaultModel.OnMoListener() {
            @Override
            public void onMoren(String message, String status) {
                defaultView.onDeafault(message,status);
            }
        });
    }
}
