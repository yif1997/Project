package com.bawei.wangyifei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.bean.Details;
import com.bawei.wangyifei.presenter.DetailsPresenter;
import com.bawei.wangyifei.view.DetailsView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity implements DetailsView {


    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.jia)
    TextView jia;
    @BindView(R.id.webview)
    WebView webview;
    private DetailsPresenter detailsPresenter;

    @Override
    protected int layoutResID() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        detailsPresenter = new DetailsPresenter(this);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        detailsPresenter.sendDetails(id);
    }


    @Override
    public void onDetails(Details result) {
        final List<String> list = new ArrayList<>();
        String[] split = result.getPicture().split("\\,");
        for (int i=0;i<split.length;i++){
            list.add(split[i]);
        }
        list.add(result.getPicture());
        xbanner.setData(list,null);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DetailsActivity.this).load(list.get(position)).into((ImageView) view);
                banner.setPageChangeDuration(2000);
            }
        });

        String commodityName = result.getCommodityName();
        String price = result.getPrice();

        name.setText(commodityName);
        jia.setText(price);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);//支持JS
        String js = "<script type=\"text/javascript\">" +
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";
        webview.loadDataWithBaseURL(null, result.getDetails() + js, "text/html", "utf-8", null);
    }
}
