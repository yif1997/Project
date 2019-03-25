package com.bawei.wangyifei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.adapter.MyClassityAdapter;
import com.bawei.wangyifei.adapter.MyShowAdapter;
import com.bawei.wangyifei.base.BaseActivity;
import com.bawei.wangyifei.bean.Classity;
import com.bawei.wangyifei.presenter.ClassifyPresenter;
import com.bawei.wangyifei.view.ClassityView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssActivity extends BaseActivity implements ClassityView {


    private RecyclerView classity;

    @Override
    protected int layoutResID() {
        return R.layout.activity_ass;
    }

    @Override
    protected void initView() {
        classity = findViewById(R.id.classity);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("categoryId");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(AssActivity.this,2);
        classity.setLayoutManager(gridLayoutManager);

        ClassifyPresenter classifyPresenter = new ClassifyPresenter(this);
        classifyPresenter.sendClassity(id);
    }


    @Override
    public void onClassity(List<Classity> result) {
        MyClassityAdapter myClassityAdapter = new MyClassityAdapter(this, result);
        classity.setAdapter(myClassityAdapter);
        myClassityAdapter.setOnClickItemListener(new MyShowAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(String commodityId) {
                Intent intent = new Intent(AssActivity.this, DetailsActivity.class);
                intent.putExtra("id",commodityId);
                startActivityForResult(intent,1);
            }
        });
    }
}
