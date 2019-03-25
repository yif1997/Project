package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.bean.ShowBean;
import com.bawei.wangyifei.bean.ShowResult;
import com.bawei.wangyifei.frag.HomeFragment;
import com.bawei.wangyifei.model.ShowModel;
import com.bawei.wangyifei.view.ShowView;

/**
 * @author 王艺霏
 * @fileName ShowPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class ShowPresenter extends BasePresenter{

    private final ShowModel showModel;
    private final ShowView showView;


    //实例化model
    public ShowPresenter(ShowView view){
        showModel = new ShowModel();
        showView = view;

    }
    public void sendShow() {
        showModel.sendShow();
        showModel.setOnShowListener(new ShowModel.OnShowListener() {
            @Override
            public void onShow(ShowResult result) {
                showView.onShow(result);
            }
        });
    }
}
