package com.bawei.wangyifei.presenter;

import com.bawei.wangyifei.activity.DetailsActivity;
import com.bawei.wangyifei.bean.Details;
import com.bawei.wangyifei.model.DetailsModel;
import com.bawei.wangyifei.view.DetailsView;

/**
 * @author 王艺霏
 * @fileName DetailsPresenter
 * @package com.bawei.wangyifei.presenter
 **/
public class DetailsPresenter {

    private final DetailsModel detailsModel;
    private final DetailsView detailsView;

    public DetailsPresenter(DetailsView view){
        detailsModel = new DetailsModel();
        detailsView = view;
    }
    public void sendDetails(String id) {
        detailsModel.sendDetails(id);
        detailsModel.setOnDetailsListener(new DetailsModel.OnDetailsListener() {
            @Override
            public void onDetails(Details result) {
                detailsView.onDetails(result);
            }
        });
    }
}
