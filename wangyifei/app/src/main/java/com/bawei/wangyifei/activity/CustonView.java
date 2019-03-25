package com.bawei.wangyifei.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.wangyifei.R;

/**
 * @author 王艺霏
 * @fileName CustonView
 * @package com.bawei.wangyifei.activity
 **/
public class CustonView extends LinearLayout {


    private EditText et;
    private ImageView search;
    private ImageView menu;

    public CustonView(Context context) {
        super(context);
    }

    public CustonView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    private void initData(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,null,false);
        addView(view);
        menu = view.findViewById(R.id.menu);
        et = view.findViewById(R.id.et);
        search = view.findViewById(R.id.search);


        //菜单
        menu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onMenuListener.onMenu();
            }
        });

        //点击搜素
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框的值
                String goods = et.getText().toString();
                if (goods.equals("")){
                    Toast.makeText(getContext(), "输入框不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                onSearchListener.onSearch(goods);
            }
        });
    }


    public CustonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //menu
    public interface OnMenuListener{
        void onMenu();
    }
    public OnMenuListener onMenuListener;
    public void setOnMenuListener(OnMenuListener onMenuListener){
        this.onMenuListener=onMenuListener;
    }


    //search
    public interface OnSearchListener{
        void onSearch(String goods);
    }
    public OnSearchListener onSearchListener;
    public void setOnSearchListener(OnSearchListener onSearchListener){
        this.onSearchListener=onSearchListener;
    }
}
