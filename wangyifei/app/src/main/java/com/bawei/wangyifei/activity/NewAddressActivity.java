package com.bawei.wangyifei.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.presenter.AddressPresenter;
import com.bawei.wangyifei.view.AddressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.leefeng.citypicker.CityPicker;
import me.leefeng.citypicker.CityPickerListener;

public class NewAddressActivity extends AppCompatActivity implements CityPickerListener ,AddressView {

    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.address)
    EditText address;

    @BindView(R.id.assaddress)
    EditText assaddress;
    @BindView(R.id.mail)
    EditText mail;
    @BindView(R.id.my_button1)
    Button myButton1;
    @BindView(R.id.arrow)
    Button arrow;
    private CityPicker cityPicker;
    private AddressPresenter addressPresenter;
    private SharedPreferences sp;
    private String userId;
    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);
        ButterKnife.bind(this);

        cityPicker = new CityPicker(NewAddressActivity.this, this);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityPicker.show();
            }

        });






        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        userId = sp.getString("userId", null);
        sessionId = sp.getString("sessionId", null);

        //presenter
        addressPresenter = new AddressPresenter(this);

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user1 = user.getText().toString();
                final String phone1 = phone.getText().toString();
                final String address1 = address.getText().toString();
                final String assaddress1 = assaddress.getText().toString();
                final String mail1 = mail.getText().toString();
                addressPresenter.sendAddress(userId,sessionId,user1,phone1,address1+" "+assaddress1,mail1);
                Log.i("dsds",mail1);


                finish();
            }
        });



    }

    @Override
    public void getCity(String s) {
        address.setText(s);
    }

    @Override
    public void onBackPressed() {
        if (cityPicker.isShow()) {
            cityPicker.close();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onAddress(String status) {
        Log.i("hhhh",status);
        if (status.equals("0000")){
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        }




    }
}
