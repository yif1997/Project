package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.bean.Second;
import com.bawei.wangyifei.frag.HomeFragment;
import com.bawei.wangyifei.model.SecondModel;
import com.bawei.wangyifei.view.SecondView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName SecondPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class SecondPresenter {

    private final SecondModel secondModel;
    private final SecondView secondView;

    public SecondPresenter(SecondView view){
        secondModel = new SecondModel();
        secondView = view;
    }
    public void sendSecond(String id) {
        secondModel.sendSecond(id);
        secondModel.setOnSecondListener(new SecondModel.OnSecondListener() {
            @Override
            public void onSecond(List<Second> result) {
                secondView.onSecond(result);
            }
        });
    }
}
