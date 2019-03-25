package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.activity.AssActivity;
import com.bawei.wangyifei.bean.Classity;
import com.bawei.wangyifei.model.ClassityModel;
import com.bawei.wangyifei.view.ClassityView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName ClassifyPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class ClassifyPresenter {

    private final ClassityModel classityModel;
    private final ClassityView classityView;

    public ClassifyPresenter(ClassityView view){
        classityModel = new ClassityModel();
        classityView = view;
    }
    public void sendClassity(String id) {
        classityModel.sendClassity(id);
        classityModel.setOnClassityListener(new ClassityModel.OnClassityListener() {
            @Override
            public void onClassity(List<Classity> result) {
                classityView.onClassity(result);
            }
        });
    }
}
