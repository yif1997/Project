package com.bawei.wangyifei.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.bean.Details;
import com.bawei.wangyifei.bean.Shop;
import com.bawei.wangyifei.presenter.AddShopPresenter;
import com.bawei.wangyifei.presenter.DetailsPresenter;
import com.bawei.wangyifei.presenter.ShopPresenter;
import com.bawei.wangyifei.view.DetailsView;
import com.bawei.wangyifei.view.ShopView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity implements DetailsView ,ShopView {
    private String sessionId;
    private String userId;

    private SharedPreferences de_sp;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.jia)
    TextView jia;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.add_shop)
    ImageView addShop;
    @BindView(R.id.btn_buy)
    ImageView btnBuy;
    private DetailsPresenter detailsPresenter;
    private String commodityId;
    private AddShopPresenter addShopPresenter;
    private JSONObject jsonObject1;
    private ShopPresenter shopPresenter;

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

        shopPresenter = new ShopPresenter(this);
        //查询购物车
        addShop.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                de_sp = getSharedPreferences("Login", Context.MODE_PRIVATE );
                userId = de_sp.getString("userId", null);
                sessionId = de_sp.getString("sessionId", null);
//                if (!TextUtils.isEmpty(userId)&&!TextUtils.isEmpty(sessionId)){
//                    Toast.makeText(DetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                shopPresenter.sendShop(userId,sessionId);

            }
        });


    }


    @Override
    public void onDetails(Details result) {
        commodityId = result.getCommodityId();
        final List<String> list = new ArrayList<>();
        String[] split = result.getPicture().split("\\,");
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        list.add(result.getPicture());
        xbanner.setData(list, null);
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


        //实例化
        addShopPresenter = new AddShopPresenter();

    }


    @Override
    public void onShop(List<Shop> result, String status) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        if (result.size()!=0){
                for (int i=0;i<result.size();i++){
                    Shop shop = result.get(i);
                    String commodityId = shop.getCommodityId();
                    int count = shop.getCount();
                    jsonObject1 = new JSONObject();
                    try {
                        jsonObject1.put("commodityId",commodityId);
                        jsonObject1.put("count",count);
                        jsonArray.put(jsonObject1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            try {
                jsonObject.put("commodityId",commodityId);
                jsonObject.put("count",1);
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //添加
            addShopPresenter.senfAddShop(jsonArray.toString(),userId,sessionId);
        }
        else {
            try {
                jsonObject1.put("commodityId",commodityId);
                jsonObject1.put("count",1);
                jsonArray.put(jsonObject1);
                addShopPresenter.senfAddShop(jsonArray.toString(),userId,sessionId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
