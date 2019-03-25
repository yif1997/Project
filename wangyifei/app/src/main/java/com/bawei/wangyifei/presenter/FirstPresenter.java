package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.bean.First;
import com.bawei.wangyifei.frag.HomeFragment;
import com.bawei.wangyifei.model.FirstModel;
import com.bawei.wangyifei.view.FirstView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName FirstPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class FirstPresenter {

    private final FirstModel firstModel;
    private final FirstView firstView;

    public FirstPresenter(FirstView view){
        firstModel = new FirstModel();
        firstView = view;
    }
    public void sendFirst() {
        firstModel.sendFirst();
        firstModel.setOnFirstListener(new FirstModel.OnFirstListener() {
            @Override
            public void onFirst(List<First> result) {
                firstView.onFirst(result);
            }
        });
    }
}
