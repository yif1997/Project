package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.bean.ResultBean1;
import com.bawei.wangyifei.frag.HomeFragment;
import com.bawei.wangyifei.model.PicModel;
import com.bawei.wangyifei.view.PicView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName PicPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class PicPresenter extends BasePresenter {

    private final PicModel picModel;
    private final PicView picView;

    public PicPresenter(PicView view){
        picModel = new PicModel();
        picView = view;
    }
    public void sendPic() {
        picModel.sendPic();
        picModel.setOnPicListener(new PicModel.OnPicListener() {
            @Override
            public void onPic(List<ResultBean1> result) {
                picView.onPic(result);
            }
        });
    }

    @Override
    public void sendShop(String userId, String sessionId) {

    }
}
