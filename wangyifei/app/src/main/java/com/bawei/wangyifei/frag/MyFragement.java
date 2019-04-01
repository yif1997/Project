package com.bawei.wangyifei.frag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.activity.LoginActivity;
import com.bawei.wangyifei.activity.MyAddressActivity;
import com.bawei.wangyifei.bean.Login;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author 王艺霏
 * @fileName MyFragement
 * @package com.bawei.wangyifei.frag
 **/
public class MyFragement extends Fragment{

    private SimpleDraweeView head;
    private TextView myname;
    private TextView my_address;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment,null,false);

        //找控件
        head = view.findViewById(R.id.head);
        myname = view.findViewById(R.id.my_name);
        my_address = view.findViewById(R.id.my_address);

        my_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyAddressActivity.class);
                startActivity(intent);
            }
        });


        //注册
        EventBus.getDefault().register(this);

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });






        return view;
    }

    //接收到值
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventBus(Login result){
        String headPic = result.getHeadPic();
        String nickName = result.getNickName();
        head.setImageURI(Uri.parse(headPic));
        myname.setText(nickName);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}
