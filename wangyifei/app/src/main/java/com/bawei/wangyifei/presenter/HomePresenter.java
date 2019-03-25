package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.bean.ResultBean;
import com.bawei.wangyifei.frag.HomeFragment;
import com.bawei.wangyifei.model.HomeModel;
import com.bawei.wangyifei.view.SearchView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName HomePresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class HomePresenter extends BasePresenter<SearchView> {

    private final HomeModel homeModel;
    private final SearchView searchView;

    //在构造方法里实例化model
    public HomePresenter(SearchView view){
        homeModel = new HomeModel();
        searchView = view;
    }


    public void sendParameter(String goods) {
        homeModel.sendParameter(goods);


        homeModel.setOnSearchListener(new HomeModel.OnSearchListener() {
            @Override
            public void onSearch(List<ResultBean> result) {
                searchView.onSearch(result);
            }
        });
    }


}
