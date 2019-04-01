package com.bawei.wangyifei.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.adapter.MyAddressAdapter;
import com.bawei.wangyifei.bean.MyAddress;
import com.bawei.wangyifei.presenter.DefaultPresenter;
import com.bawei.wangyifei.presenter.MyAddressPresenter;
import com.bawei.wangyifei.view.DefaultView;
import com.bawei.wangyifei.view.MyAddressView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAddressActivity extends AppCompatActivity implements MyAddressView,DefaultView {

    @BindView(R.id.my_recy)
    RecyclerView myRecy;

    private Button my_button;
    private MyAddressPresenter myAddressPresenter;
    private String userId;
    private String sessionId;
    private DefaultPresenter defaultPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myRecy.setLayoutManager(linearLayoutManager);

        my_button = findViewById(R.id.my_button);
//点击跳转
        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAddressActivity.this, NewAddressActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        userId = sp.getString("userId", null);
        sessionId = sp.getString("sessionId", null);


        //实例化
        myAddressPresenter = new MyAddressPresenter(this);
        myAddressPresenter.sendMyAddress(userId,sessionId);

        //默认
        defaultPresenter = new DefaultPresenter(this);

    }

    @Override
    public void onMyAddress(List<MyAddress> result) {
        MyAddressAdapter myAddressAdapter = new MyAddressAdapter(this, result);
        myRecy.setAdapter(myAddressAdapter);


        myAddressAdapter.setOnDefaultListener(new MyAddressAdapter.OnDefaultListener() {
            @Override
            public void onDedault(String id) {
                defaultPresenter.sendDefault(userId,sessionId,id);
            }
        });
    }

    @Override
    public void onDeafault(String message, String status) {
        myAddressPresenter.sendMyAddress(userId,sessionId);
        if (status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
